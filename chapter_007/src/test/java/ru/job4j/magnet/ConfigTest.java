package ru.job4j.magnet;

import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

@Ignore public class ConfigTest {
    Config config = new Config();

    @Test
    public void whenConnectionUrlNotNull() {
        Connection conn = config.init("url");
        assertNotNull(conn);
    }

    @Test
    public void whenConnectionUrlCreateDbNotNull() {
        Connection conn = config.init("urlCreateDb");
        assertNotNull(conn);
    }
}