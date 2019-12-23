package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    private SimpleHashMap<String, String> map;

    @Test
    public void whenAddThreeElementsDuplicateKey() {
        map = new SimpleHashMap<>();
        map.insert("one", "1");
        map.insert("one", "2");
        map.insert("one", "3");
        assertThat(map.insert("one", "4"), is(false));
        map.insert("one", "4");
        assertThat(map.get("one"), is("4"));
    }

    @Test
    public void whenAddFourElementsDifferentKeys() {
        map = new SimpleHashMap<>();
        map.insert("one", "1");
        map.insert("two", "2");
        map.insert("three", "3");
        map.insert("four", "4");
        assertThat(map.get("one"), is("1"));
        assertThat(map.get("two"), is("2"));
        assertThat(map.get("three"), is("3"));
        assertThat(map.get("four"), is("4"));
    }

    @Test
    public void whenDeleteFourElements() {
        map = new SimpleHashMap<>();
        map.insert("one", "1");
        map.insert("two", "2");
        map.insert("three", "3");
        map.insert("four", "4");
        assertThat(map.delete("one"), is(true));
        assertThat(map.delete("two"), is(true));
        assertThat(map.delete("three"), is(true));
        assertThat(map.delete("four"), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUseIteratorWithException() {
        map = new SimpleHashMap<>();
        map.insert("one", "1");
        map.insert("two", "2");
        map.insert("three", "3");
        Iterator<SimpleHashMap.Node<String, String>> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("2"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("3"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}