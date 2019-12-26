package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    private SimpleHashMap<Integer, String> map;

    @Test
    public void whenAddThreeElementsDuplicateKey() {
        map = new SimpleHashMap<>();
        map.insert(1, "one");
        map.insert(1, "two");
        map.insert(1, "three");
        map.insert(1, "four");
        assertThat(map.get(1), is("four"));
        assertThat(map.getSize(), is(1));
    }

    @Test
    public void whenDeleteFourElementsWithDuplicateIndex() {
        map = new SimpleHashMap<>();
        map.insert(1, "one");
        map.insert(2, "two");
        map.insert(3, "three");
        map.insert(4, "four");
        map.insert(5, "five");
        map.insert(6, "six");
        assertThat(map.delete(2), is(true));
        assertThat(map.delete(4), is(true));
        assertThat(map.delete(5), is(true));
        assertThat(map.delete(1), is(true));
        assertThat(map.getSize(), is(2));
    }

    @Test
    public void whenAddElementsAndResizeArray() {
        map = new SimpleHashMap<>();
        map.insert(1, "one");
        map.insert(2, "two");
        map.insert(3, "three");
        map.insert(4, "four");
        map.insert(5, "five");
        map.insert(6, "six");
        map.insert(7, "seven");
        map.insert(8, "eight");
        map.insert(9, "nine");
        map.insert(10, "ten");
        map.insert(11, "eleven");
        map.insert(12, "twelve");
        map.insert(13, "thirteen");
        map.insert(14, "fourteen");
        assertThat(map.getLength(), is(32));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUseIteratorWithException() {
        map = new SimpleHashMap<>();
        map.insert(1, "one");
        map.insert(2, "two");
        map.insert(3, "three");
        Iterator<SimpleHashMap.Node<Integer, String>> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("one"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("two"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("three"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}