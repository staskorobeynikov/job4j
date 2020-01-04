package ru.job4j.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Properties;

/**
 * Класс предназначен для хранения заявок в базе данных
 *
 * @author STAS KOROBEYNIKOV
 * @since 04.01.2020
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    private final Logger logger = LogManager.getLogger(TrackerSQL.class.getName());
    private Connection connection;
    private static final String TABLE = "items";

    public TrackerSQL() {
    }

    public TrackerSQL(Connection connection) {
        this.connection = connection;
    }

    /**
     * Метод предназначен для инициализации подключения.
     * @return true - подключение установлено
     */
    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        if (!tableExist(connection)) {
            logger.error("Таблицы нет в структуре");
        }
        return this.connection != null;
    }

    /**
     * Вспомогательный метод, предназначен для установления существует ли в структуре необходимая таблица.
     */
    public boolean tableExist(Connection connection) {
        boolean result = false;
        if (connection != null) {
            try {
                ResultSet rs = connection.getMetaData().getTables(null, null, TABLE, null);
                while (rs.next()) {
                    String str = rs.getString("TABLE");
                    if (TABLE.equals(str)) {
                        result = true;
                        break;
                    }
                }
            } catch (SQLException exc) {
                logger.error(exc.getMessage(), exc);
            }
            if (!result) {
                try {
                    Statement st = connection.createStatement();
                    st.execute("create table items ("
                            + "id serial primary key,"
                            + "name varchar(100) not null"
                            + ");");
                } catch (SQLException exc) {
                    logger.error(exc.getMessage(), exc);
                }
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод предназначен для добавления заявки в таблицу базы данных.
     */
    @Override
    public Item add(Item item) {
        Item result = null;
        try {
            PreparedStatement addSt = connection.prepareStatement("insert into items(name) values (?);");
            addSt.setString(1, item.getName());
            addSt.executeUpdate();
            PreparedStatement selectSt = connection.prepareStatement("select * from items where name = ?;");
            selectSt.setString(1, item.getName());
            ResultSet rs = selectSt.executeQuery();
            while (rs.next()) {
                result = new Item(rs.getString("name"));
                result.setId(String.valueOf(rs.getInt("id")));
            }
            rs.close();
            selectSt.close();
            addSt.close();
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return result;
    }

    /**
     * Метод предназначен для изменения заявки по id.
     * @param id заявки которую необходимо изменить.
     * @param item новая заявка.
     * @return true - заявка изменена.
     */
    @Override
    public boolean replace(String id, Item item) {
        boolean result;
        try {
            PreparedStatement replaceSt = connection.prepareStatement("update items set name = ? where id = ?;");
            replaceSt.setString(1, item.getName());
            replaceSt.setInt(2, Integer.parseInt(id));
            replaceSt.executeUpdate();
            result = true;
            replaceSt.close();
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
            result = false;
        }
        return result;
    }

    /**
     * Метод предназначен для удаления заявки по id.
     * @param id заявки которую необходимо удалить.
     * @return true - заявка удалена.
     */
    @Override
    public boolean delete(String id) {
        boolean result;
        try {
            PreparedStatement deleteSt = connection.prepareStatement("delete from items where id = ?;");
            deleteSt.setInt(1, Integer.parseInt(id));
            deleteSt.executeUpdate();
            result = true;
            deleteSt.close();
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
            result = false;
        }
        return result;
    }

    /**
     * Метод предназначен для получения списка всех заявок.
     */
    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from items;");
            while (rs.next()) {
                Item it = new Item(rs.getString("name"));
                it.setId(String.valueOf(rs.getInt("id")));
                result.add(it);
            }
            rs.close();
            st.close();
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return result;
    }

    /**
     * Метод предназначен для поиска заявки по имени.
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try {
            PreparedStatement findByNameSt = connection.prepareStatement("select * from items where name = ?;");
            findByNameSt.setString(1, key);
            ResultSet rs = findByNameSt.executeQuery();
            while (rs.next()) {
                Item it = new Item(rs.getString("name"));
                it.setId(String.valueOf(rs.getInt("id")));
                result.add(it);
            }
            rs.close();
            findByNameSt.close();
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return result;
    }

    /**
     * Метод предназначен для поиска заявки по id.
     */
    @Override
    public Item findById(String id) {
        Item result = null;
        try {
            PreparedStatement findByIdSt = connection.prepareStatement("select * from items where id = ?;");
            findByIdSt.setInt(1, Integer.parseInt(id));
            ResultSet rs = findByIdSt.executeQuery();
            while (rs.next()) {
                result = new Item(rs.getString("name"));
                result.setId(String.valueOf(rs.getInt("id")));
            }
            rs.close();
            findByIdSt.close();
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return result;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
