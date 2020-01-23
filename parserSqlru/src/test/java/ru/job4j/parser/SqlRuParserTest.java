package ru.job4j.parser;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SqlRuParserTest {

    @Test
    public void whenSetTimeStampSizeIsOne() {
        Config config = new ConfigForSQLParser();
        config.init();
        StoreSQL storeSQL =  new StoreSQL(new ConnectStoreSQL(config).getConnection());
        SqlRuParser sqlRuParser = new SqlRuParser(
                config,
                storeSQL,
                new StubParser());
        sqlRuParser.start();
        Set<Timestamp> set = storeSQL.getSetDateCreate();

        int result = set.size();

        assertThat(result, is(1));
    }

    @Test
    public void whenSetTimeStampContainsGetCreateDateFromStubParser() {
        Config config = new ConfigForSQLParser();
        config.init();
        StoreSQL storeSQL =  new StoreSQL(new ConnectStoreSQL(config).getConnection());
        StubParser stubParser = new StubParser();
        SqlRuParser sqlRuParser = new SqlRuParser(
                config,
                storeSQL,
                stubParser);
        sqlRuParser.start();
        Set<Timestamp> set = storeSQL.getSetDateCreate();

        boolean result = set.contains(stubParser.getCreateDate());

        assertThat(result, is(true));
    }
}