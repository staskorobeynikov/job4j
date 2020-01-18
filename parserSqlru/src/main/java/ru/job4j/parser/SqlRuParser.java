package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;

public class SqlRuParser {

    private final Logger logger = LogManager.getLogger(SqlRuParser.class.getName());

    private void start() {
        Config config = new Config();
        SimpleParser parser = new SimpleParser();
        StoreSQL storeSQL = new StoreSQL(config.init());
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            JobDetail job = newJob(ParserJob.class)
                    .withIdentity("ParserJob", "group1")
                    .usingJobData("parser.url", config.get("parser.url"))
                    .build();
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule(config.get("cron.time")))
                    .forJob("ParserJob", "group1")
                    .build();
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            logger.error(e.getMessage(), e);
        }
        storeSQL.addVacancies(parser.parse(config.get("parser.url"), storeSQL.getSetDateCreate()));
    }

    public static void main(String[] args) {
        new SqlRuParser().start();
    }
}
