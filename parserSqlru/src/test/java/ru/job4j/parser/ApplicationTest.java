package ru.job4j.parser;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ApplicationTest {

    @Test
    public void whenSetTimeStampSizeIsOne() {
        Config config = new ConfigForSQLParser();
        config.init();
        StoreSQL storeSQL =  new StoreSQL(new ConnectStoreSQL(config).getConnection());
        Application application = new Application(
                config,
                storeSQL,
                new SuperJobParser());
        application.start();
        Set<Timestamp> set = storeSQL.getSetDateCreate();

        int result = set.size();

        assertThat(result, is(1));
    }

    @Test
    public void whenSetTimeStampContainsGetCreateDateFromStubParser() {
        Config config = new ConfigForSQLParser();
        config.init();
        StoreSQL storeSQL =  new StoreSQL(new ConnectStoreSQL(config).getConnection());
        SuperJobParser superJobParser = new SuperJobParser();
        Application application = new Application(
                config,
                storeSQL,
                superJobParser);
        application.start();
        Set<Timestamp> set = storeSQL.getSetDateCreate();

        boolean result = set.contains(superJobParser.getCreateDate());

        assertThat(result, is(true));
    }
}