package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;

    @Before
    public void init() {
        list = new SimpleArrayList<>();
        list.add(5);
        list.add(10);
        list.add(15);
    }

    @Test
    public void whenSecondElementIsTen() {
        assertThat(list.get(0), is(15));
    }

    @Test
    public void whenUseGetSizeMethod() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteFirstElement() {
        Integer data = list.delete();
        assertThat(data, is(15));
        assertThat(list.getSize(), is(2));
        assertThat(list.get(0), is(10));
        assertThat(list.get(1), is(5));
    }
}