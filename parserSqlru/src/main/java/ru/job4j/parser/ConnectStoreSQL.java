package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectStoreSQL implements ConnectManager, AutoCloseable {

    private final Config config;

    private Connection connection;

    private final Logger logger = LogManager.getLogger(ConfigForSQLParser.class.getName());

    public ConnectStoreSQL(Config config) {
        this.config = config;
    }

    @Override
    public Connection getConnection() {
        try {
            Class.forName(config.getProperty("jdbc.driver"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("jdbc.url"),
                    config.getProperty("jdbc.username"),
                    config.getProperty("jdbc.password")
            );
        } catch (SQLException | ClassNotFoundException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return connection;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
