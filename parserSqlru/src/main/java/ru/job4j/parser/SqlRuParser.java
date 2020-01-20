package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;

public class SqlRuParser {

    private final Logger logger = LogManager.getLogger(SqlRuParser.class.getName());

    private void start() {
        Config config = new ConfigForSQLParser();
        Parser parser = new SimpleParser();
        config.init();
        ConnectManager connectManager = new ConnectStoreSQL(config);
        Store store = new StoreSQL(connectManager.getConnection());
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            JobDetail job = newJob(ParserJob.class)
                    .withIdentity("ParserJob", "group1")
                    .usingJobData("parser.url", config.getProperty("parser.url"))
                    .build();
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule(config.getProperty("cron.time")))
                    .forJob("ParserJob", "group1")
                    .build();
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            logger.error(e.getMessage(), e);
        }
        store.addVacancies(parser.parse(config.getProperty("parser.url"), store.getSetDateCreate()));
    }

    public static void main(String[] args) {
        new SqlRuParser().start();
    }
}
