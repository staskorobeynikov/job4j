package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class StoreSQL implements AutoCloseable, Store {

    private final Connection connection;

    private final Logger logger = LogManager.getLogger(StoreSQL.class.getName());

    public StoreSQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addVacancies(Set<Vacancy> vacancies) {
        try (PreparedStatement prStatement = connection.prepareStatement(
                "insert into vacancies (name, text, link, create_date) values (?, ?, ?, ?);")) {
            for (Vacancy vac : vacancies) {
                prStatement.setString(1, vac.getName());
                prStatement.setString(2, vac.getText());
                prStatement.setString(3, vac.getLink());
                prStatement.setTimestamp(4, vac.getCreateDate());
                prStatement.addBatch();
            }
            logger.info("{} vacancy(-ies) added", vacancies.size());
            prStatement.executeBatch();
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
    }

    @Override
    public Set<Timestamp> getSetDateCreate() {
        Set<Timestamp> result = new HashSet<>();
        try (PreparedStatement prSt = connection.prepareStatement(
                "select create_date from vacancies;"
        )) {
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getTimestamp("create_date"));
            }
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return result;
    }

    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}
