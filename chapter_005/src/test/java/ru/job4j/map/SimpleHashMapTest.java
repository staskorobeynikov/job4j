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
        assertThat(map.getSize(), is(1));
    }

    @Test
    public void whenAddTenElementsDifferentKeysWithDuplicateHashcodeKey() {
        map = new SimpleHashMap<>();
        map.insert("one", "1");
        map.insert("two", "2");
        map.insert("three", "3");
        map.insert("four", "4");
        map.insert("five", "5");
        map.insert("six", "6");
        map.insert("seven", "7");
        map.insert("eight", "8");
        map.insert("nine", "9");
        map.insert("ten", "10");
        assertThat(map.get("one"), is("1"));
        assertThat(map.get("two"), is("2"));
        assertThat(map.get("three"), is("3"));
        assertThat(map.get("four"), is("4"));
        assertThat(map.get("five"), is("5"));
        assertThat(map.get("six"), is("6"));
        assertThat(map.get("seven"), is("7"));
        assertThat(map.get("eight"), is("8"));
        assertThat(map.get("nine"), is("9"));
        assertThat(map.get("ten"), is("10"));
        assertThat(map.getSize(), is(10));
    }

    @Test
    public void whenDeleteFourElementsWithDuplicateIndex() {
        map = new SimpleHashMap<>();
        map.insert("one", "1");
        map.insert("two", "2");
        map.insert("three", "3");
        map.insert("four", "4");
        map.insert("five", "5");
        map.insert("six", "6");
        map.insert("seven", "7");
        map.insert("eight", "8");
        map.insert("nine", "9");
        map.insert("ten", "10");
        assertThat(map.delete("four"), is(true));
        assertThat(map.delete("six"), is(true));
        assertThat(map.delete("nine"), is(true));
        assertThat(map.delete("ten"), is(true));
        assertThat(map.getSize(), is(6));
    }

    @Test
    public void whenAddElementsAndResizeArray() {
        map = new SimpleHashMap<>();
        map.insert("one", "1");
        map.insert("two", "2");
        map.insert("three", "3");
        map.insert("four", "4");
        map.insert("five", "5");
        map.insert("six", "6");
        map.insert("seven", "7");
        map.insert("eight", "8");
        map.insert("nine", "9");
        map.insert("ten", "10");
        map.insert("eleven", "11");
        map.insert("twelve", "12");
        map.insert("thirteen", "13");
        map.insert("fourteen", "14");
        assertThat(map.getLength(), is(32));
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