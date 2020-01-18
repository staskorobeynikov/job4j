package ru.job4j.parser;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

public class ParserJob implements Job {

    private final Store store;

    private final Parser parser;

    public ParserJob(Store store, Parser parser) {
        this.store = store;
        this.parser = parser;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String string = dataMap.getString("parser.url");
        Config config = new Config();
        store.addVacancies(parser.parse(config.get(string), store.getSetDateCreate()));
    }
}
