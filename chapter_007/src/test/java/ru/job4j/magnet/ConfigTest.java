package ru.job4j.magnet;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class ConfigTest {
    Config config = new Config();

    @Test
    public void when() {
        Connection conn = config.init("url");
        assertNotNull(conn);
    }

    @Test
    public void when1() {
        Connection conn = config.init("urlCreateDb");
        assertNotNull(conn);
    }
}