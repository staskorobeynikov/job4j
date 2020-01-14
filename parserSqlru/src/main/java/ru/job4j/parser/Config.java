package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Config {

    private Connection connection;
    private final Properties config = new Properties();
    private final Logger logger = LogManager.getLogger(Config.class.getName());

    public Connection init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
            Class.forName(config.getProperty("jdbc.driver"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("jdbc.url"),
                    config.getProperty("jdbc.username"),
                    config.getProperty("jdbc.password")
            );
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return connection;
    }

    public String get(String key) {
        return config.getProperty(key);
    }
}
