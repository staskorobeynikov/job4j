package ru.job4j.parser;

import org.junit.Test;
import org.mockito.Mockito;
import ru.job4j.tracker.ConnectionRollback;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApplicationTest {

    private Connection init() {
        try (InputStream in = StoreSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            if (in != null) {
                config.load(in);
            }
            Class.forName(config.getProperty("driver"));
            return DriverManager.getConnection(
                    config.getProperty("urlTest"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenSetTimeStampSizeIsOne() {
        Config config = new ConfigForSQLParser();
        config.init();
        StoreSQL storeSQL = null;
        try {
            storeSQL = new StoreSQL(ConnectionRollback.create(this.init()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Application application = new Application(
                config,
                storeSQL,
                new SuperJobParser());
        application.start();
        assert storeSQL != null;
        Set<Timestamp> set = storeSQL.getSetDateCreate();

        int result = set.size();

        assertThat(result, is(1));
    }

    @Test
    public void whenSetTimeStampContainsGetCreateDateFromStubParser() {
        Config config = new ConfigForSQLParser();
        config.init();
        StoreSQL storeSQL = null;
        try {
            storeSQL = new StoreSQL(ConnectionRollback.create(this.init()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SuperJobParser superJobParser = new SuperJobParser();
        Application application = new Application(
                config,
                storeSQL,
                superJobParser);
        application.start();
        assert storeSQL != null;
        Set<Timestamp> set = storeSQL.getSetDateCreate();

        boolean result = set.contains(superJobParser.getCreateDate());

        assertThat(result, is(true));
    }

    @Test
    public void whenConnectionIsNotNull() {
        Config config = mock(ConfigForSQLParser.class);
        when(config.getProperty("driver")).thenReturn("org.postgresql.Driver");
        when(config.getProperty("url")).thenReturn("jdbc:postgresql://127.0.0.1:5432/tracker");
        when(config.getProperty("username")).thenReturn("postgres");
        when(config.getProperty("password")).thenReturn("password");
        config.init();
        ConnectStoreSQL connect = new ConnectStoreSQL(config);
        assertNotNull(connect.getConnection());
    }
}