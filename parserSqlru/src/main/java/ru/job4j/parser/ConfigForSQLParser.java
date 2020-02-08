package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

public class ConfigForSQLParser implements Config {

    private final Properties properties = new Properties();

    private final Logger logger = LogManager.getLogger(ConfigForSQLParser.class.getName());

    @Override
    public void init() {
        try (InputStream in = ConfigForSQLParser.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            if (in != null) {
                properties.load(in);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
