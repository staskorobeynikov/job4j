package ru.job4j.magnet;

import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


@Ignore public class StoreSQLTest {
    private Connection conn = new Config().init("url");
    private StoreSQL storeSQL = new StoreSQL(conn);

    @Test
    public void whenAdd2Items() {
        storeSQL.generate(2);
        List<Entry> res = storeSQL.load();
        Iterator<Entry> it = res.iterator();
        assertThat(res.size(), is(2));
        assertThat(it.next().getField(), is(0));
        assertThat(it.next().getField(), is(1));
    }
}