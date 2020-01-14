package ru.job4j.magnet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class StoreSQL implements AutoCloseable {
    private final Logger logger = LogManager.getLogger(StoreSQL.class.getName());
    private final Connection connection;

    public StoreSQL(Connection connection) {
        this.connection = connection;
    }

    public void generate(int size) {
        createTableInDB();
        try (PreparedStatement pr = connection.prepareStatement("insert into entry(field) values(?);")) {
            connection.setAutoCommit(false);
            for (int i = 0; i < size; i++) {
                pr.setInt(1, i);
                pr.addBatch();
            }
            pr.executeBatch();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
    }

    public List<Entry> load() {
        List<Entry> result = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("select * from entry;")) {
            while (rs.next()) {
                result.add(new Entry(rs.getInt(1)));
            }
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return result;
    }

    private void createTableInDB() {
        if (connection != null) {
            try (Statement st = connection.createStatement()) {
                st.execute("drop table if exists entry;");
                st.execute("create table entry (field integer);");
            } catch (SQLException exc) {
                throw new IllegalStateException();
            }
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}
