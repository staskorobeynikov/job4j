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
            try (ResultSet rs = connection.getMetaData().getTables(null, null, TABLE, null)) {
                while (rs.next()) {
                    if (TABLE.equals(rs.getString("TABLE_NAME"))) {
                        result = true;
                        break;
                    }
                }
            } catch (SQLException exc) {
                logger.error(exc.getMessage(), exc);
            }
            if (!result) {
                try (Statement st = connection.createStatement()) {
                    st.execute("create table items ("
                            + "id serial primary key,"
                            + "name varchar(100) not null"
                            + ");");
                } catch (SQLException exc) {
                    logger.error(exc.getMessage(), exc);
                }
                System.out.println(String.format("Создана таблица %s", TABLE));
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
        try (PreparedStatement addSt =
                     connection.prepareStatement("insert into items(name) values (?);");
             PreparedStatement selectSt =
                     connection.prepareStatement("select * from items where name = ?;")) {
            addSt.setString(1, item.getName());
            addSt.executeUpdate();
            selectSt.setString(1, item.getName());
            ResultSet rs = selectSt.executeQuery();
            result = getResult(rs).get(0);
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
        boolean result = false;
        try (PreparedStatement replaceSt =
                     connection.prepareStatement("update items set name = ? where id = ?;")) {
            replaceSt.setString(1, item.getName());
            replaceSt.setInt(2, Integer.parseInt(id));
            replaceSt.executeUpdate();
            result = true;
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
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
        boolean result = false;
        try (PreparedStatement deleteSt = connection.prepareStatement("delete from items where id = ?;")) {
            deleteSt.setInt(1, Integer.parseInt(id));
            deleteSt.executeUpdate();
            result = true;
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return result;
    }

    /**
     * Метод предназначен для получения списка всех заявок.
     */
    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("select * from items;");
            result = getResult(rs);
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
        try (PreparedStatement findByNameSt =
                     connection.prepareStatement("select * from items where name = ?;")) {
            findByNameSt.setString(1, key);
            ResultSet rs = findByNameSt.executeQuery();
            result = getResult(rs);
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
        try (PreparedStatement findByIdSt =
                     connection.prepareStatement("select * from items where id = ?;")) {
            findByIdSt.setInt(1, Integer.parseInt(id));
            ResultSet rs = findByIdSt.executeQuery();
            result = getResult(rs).get(0);
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return result;
    }

    private List<Item> getResult(ResultSet resultSet) {
        List<Item> result = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Item it = new Item(resultSet.getString("name"));
                it.setId(String.valueOf(resultSet.getInt("id")));
                result.add(it);
            }
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
