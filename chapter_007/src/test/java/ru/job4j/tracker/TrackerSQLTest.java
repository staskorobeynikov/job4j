package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {

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
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }

    @Test
    public void when() {
        TrackerSQLTest sqlTest = new TrackerSQLTest();
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.tableExist(sqlTest.init()), is(true));
    }

    @Test
    public void whenAddItem() {
        TrackerSQLTest sqlTest = new TrackerSQLTest();
        TrackerSQL sql = new TrackerSQL(sqlTest.init());
        sql.add(new Item("name"));
        assertThat(sql.findByName("name").get(0).getName(), is("name"));
    }

    @Test
    public void whenFindByName() {
        TrackerSQLTest sqlTest = new TrackerSQLTest();
        TrackerSQL sql = new TrackerSQL(sqlTest.init());
        sql.add(new Item("name1"));
        sql.add(new Item("name1"));
        sql.add(new Item("name2"));
        sql.add(new Item("name1"));
        sql.add(new Item("name3"));
        assertThat(sql.findByName("name1").size(), is(3));
    }

    @Test
    public void whenReplaceItem() {
        TrackerSQLTest sqlTest = new TrackerSQLTest();
        TrackerSQL sql = new TrackerSQL(sqlTest.init());
        String id = sql.add(new Item("name4")).getId();
        boolean replaceItem = sql.replace(id, new Item("nameReplace"));
        assertTrue(replaceItem);
        assertThat(sql.findByName("nameReplace").get(0).getName(), is("nameReplace"));
    }

    @Test
    public void whenDeleteItem() {
        TrackerSQLTest sqlTest = new TrackerSQLTest();
        TrackerSQL sql = new TrackerSQL(sqlTest.init());
        String id = sql.add(new Item("name5")).getId();
        String id1 = sql.add(new Item("name6")).getId();
        String id2 = sql.add(new Item("name7")).getId();
        assertThat(sql.findAll().size(), is(3));
        assertTrue(sql.delete(id));
        assertThat(sql.findAll().size(), is(2));
        assertTrue(sql.delete(id1));
        assertThat(sql.findAll().size(), is(1));
        assertTrue(sql.delete(id2));
    }

    @Test
    public void whenFindAllItem() {
        TrackerSQLTest sqlTest = new TrackerSQLTest();
        TrackerSQL sql = new TrackerSQL(sqlTest.init());
        sql.add(new Item("name1"));
        sql.add(new Item("name2"));
        sql.add(new Item("name3"));
        sql.add(new Item("name4"));
        sql.add(new Item("name5"));
        assertThat(sql.findAll().size(), is(5));
    }

    @Test
    public void whenFindByIdItem() {
        TrackerSQLTest sqlTest = new TrackerSQLTest();
        TrackerSQL sql = new TrackerSQL(sqlTest.init());
        String id = sql.add(new Item("name")).getId();
        String id1 = sql.add(new Item("name1")).getId();
        String id2 = sql.add(new Item("name2")).getId();
        String id3 = sql.add(new Item("name3")).getId();
        assertThat(sql.findById(id).getName(), is("name"));
        assertThat(sql.findById(id1).getName(), is("name1"));
        assertThat(sql.findById(id2).getName(), is("name2"));
        assertThat(sql.findById(id3).getName(), is("name3"));
    }
}