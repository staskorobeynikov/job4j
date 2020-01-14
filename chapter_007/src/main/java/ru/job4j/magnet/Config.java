package ru.job4j.magnet;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();
    private Connection connection;

    public Connection init(String url) {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("appSQLLite.properties")) {
            values.load(in);
            connection = DriverManager.getConnection(get(url));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return connection;
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
