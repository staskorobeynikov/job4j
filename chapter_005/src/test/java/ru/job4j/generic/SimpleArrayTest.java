package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    private SimpleArray<Integer> simpleArray;

    @Before
    public void init() {
        simpleArray = new SimpleArray<>(3);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
    }

    @Test
    public void whenAddModel() {
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(2));
        assertThat(simpleArray.get(2), is(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddNewModelMoreArrayLength() {
        simpleArray.add(4);
    }

    @Test
    public void whenRemoveSecondModel() {
        simpleArray.remove(1);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(3));
        assertNull(simpleArray.get(2));
    }

    @Test
    public void whenRemoveLastModel() {
        simpleArray.remove(2);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(2));
        assertNull(simpleArray.get(2));
    }

    @Test
    public void whenSetNewModelIsInArray() {
        simpleArray.set(2, 100);
        assertThat(simpleArray.get(2), is(100));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenSetNewModelNotInArray() {
        simpleArray.set(100, 1000);
    }

    @Test
    public void whenIteratorWorksCorrectly() {
        Iterator simpleArrayIt = simpleArray.iterator();
        assertThat(simpleArrayIt.hasNext(), is(true));
        assertThat(simpleArrayIt.next(), is(1));
        assertThat(simpleArrayIt.hasNext(), is(true));
        assertThat(simpleArrayIt.next(), is(2));
        assertThat(simpleArrayIt.hasNext(), is(true));
        assertThat(simpleArrayIt.next(), is(3));
        assertThat(simpleArrayIt.hasNext(), is(false));
    }
}