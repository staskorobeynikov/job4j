package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedListContainerTest {
    private LinkedListContainer<Integer> list;

    @Before
    public void init() {
        list = new LinkedListContainer<>();
    }

    @Test
    public void whenAddElements() {
        list.add(5);
        assertThat(list.get(0), is(5));
        list.add(10);
        assertThat(list.get(0), is(5));
    }

    @Test
    public void whenIteratorWorksCorrectly() {
        list.add(5);
        list.add(10);
        list.add(15);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(15));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorWorksWithException() {
        list.add(5);
        Iterator<Integer> it = list.iterator();
        it.next();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenException() {
        list.add(5);
        Iterator<Integer> it = list.iterator();
        it.next();
        list.add(10);
        it.next();
    }
}