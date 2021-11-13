package ru.job4j.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    private final Logger logger = LogManager.getLogger(TrackerSQLTest.class.getName());

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL(this.init());
        assertThat(sql.init(), is(true));
    }

    @Test
    public void whenConnectionIsTrue() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            assertThat(sql.tableExist(this.init()), is(true));
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }

    }

    @Test
    public void whenAddItem() {
        try (TrackerSQL trackerSQL = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            trackerSQL.add(new Item("name"));
            assertThat(trackerSQL.findByName("name").get(0).getName(), is("name"));
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void whenFindByName() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.add(new Item("name1"));
            sql.add(new Item("name1"));
            sql.add(new Item("name2"));
            sql.add(new Item("name1"));
            sql.add(new Item("name3"));
            assertThat(sql.findByName("name1").size(), is(3));
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void whenReplaceItemIsTrue() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            String id = sql.add(new Item("name4")).getId();
            boolean replaceItem = sql.replace(id, new Item("nameReplace"));
            assertTrue(replaceItem);
            assertThat(sql.findByName("nameReplace").get(0).getName(), is("nameReplace"));
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void whenReplaceItemIsFalse() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.add(new Item("name4"));
            boolean replaceItem = sql.replace(String.valueOf(5), new Item("nameReplace"));
            assertFalse(replaceItem);
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void whenDeleteItemIsTrue() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            String id = sql.add(new Item("name5")).getId();
            String id1 = sql.add(new Item("name6")).getId();
            String id2 = sql.add(new Item("name7")).getId();
            assertThat(sql.findAll().size(), is(3));
            assertTrue(sql.delete(id));
            assertThat(sql.findAll().size(), is(2));
            assertTrue(sql.delete(id1));
            assertThat(sql.findAll().size(), is(1));
            assertTrue(sql.delete(id2));
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void whenDeleteItemIsFalse() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.add(new Item("name5"));
            sql.add(new Item("name6"));
            sql.add(new Item("name7"));
            assertThat(sql.findAll().size(), is(3));
            assertFalse(sql.delete(String.valueOf(100)));
            assertThat(sql.findAll().size(), is(3));
            assertFalse(sql.delete(String.valueOf(200)));
            assertThat(sql.findAll().size(), is(3));
            assertFalse(sql.delete(String.valueOf(300)));
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void whenFindAllItem() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.add(new Item("name1"));
            sql.add(new Item("name2"));
            sql.add(new Item("name3"));
            sql.add(new Item("name4"));
            sql.add(new Item("name5"));
            assertThat(sql.findAll().size(), is(5));
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void whenFindByIdItem() {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            String id = sql.add(new Item("name")).getId();
            String id1 = sql.add(new Item("name1")).getId();
            String id2 = sql.add(new Item("name2")).getId();
            String id3 = sql.add(new Item("name3")).getId();
            assertThat(sql.findById(id).getName(), is("name"));
            assertThat(sql.findById(id1).getName(), is("name1"));
            assertThat(sql.findById(id2).getName(), is("name2"));
            assertThat(sql.findById(id3).getName(), is("name3"));
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }
}