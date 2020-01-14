package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.util.Objects;
import java.util.Set;

public class ParserJob implements Job {

    private final Logger logger = LogManager.getLogger(ParserJob.class.getName());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String str = dataMap.getString("parser.url");
        SimpleParser ps = new SimpleParser();
        Config config = new Config();
        StoreSQL storeSQL = new StoreSQL(config.init());
        Set<Vacancy> result = null;
        result = ps.parse(config.get(str), storeSQL.getSetDateCreate());
        storeSQL.addVacancies(Objects.requireNonNull(result));
    }
}
