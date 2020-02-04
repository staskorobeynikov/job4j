package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SingleLockListTest {

    @Test
    public void whenTestMethodAdd() throws InterruptedException {
        DynamicContainer<Integer> container = new DynamicContainer<>();
        SingleLockList<Integer> list = new SingleLockList<>(container);
        Thread first = new Thread(() -> list.add(1));
        Thread second = new Thread(() -> list.add(2));
        first.start();
        second.start();
        first.join();
        second.join();
        Set<Integer> result = new TreeSet<>();
        list.iterator().forEachRemaining(result::add);
        assertThat(result, is(Set.of(1, 2)));
    }

    @Test
    public void whenTestMethodGetValue() throws InterruptedException {
        DynamicContainer<Integer> container = new DynamicContainer<>();
        SingleLockList<Integer> list = new SingleLockList<>(container);
        Thread first = new Thread(() -> list.add(5));
        Thread second = new Thread(() -> list.add(10));
        first.start();
        second.start();
        first.join();
        second.join();

        int result = list.get(0);
        int result1 = list.get(1);

        assertThat(result, is(5));
        assertThat(result1, is(10));
    }

    @Test
    public void whenTestIterator() {
        DynamicContainer<Integer> container = new DynamicContainer<>();
        SingleLockList<Integer> list = new SingleLockList<>(container);
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenAddElementAfterCreateIteratorIsTestIteratorCorrectly() {
        DynamicContainer<Integer> container = new DynamicContainer<>();
        SingleLockList<Integer> list = new SingleLockList<>(container);
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        list.add(4);
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        list.add(5);
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        list.add(6);
        assertThat(iterator.hasNext(), is(false));

        Iterator iterator1 = list.iterator();
        assertThat(iterator1.hasNext(), is(true));
        assertThat(iterator1.next(), is(1));
        assertThat(iterator1.hasNext(), is(true));
        assertThat(iterator1.next(), is(2));
        assertThat(iterator1.hasNext(), is(true));
        assertThat(iterator1.next(), is(3));
        assertThat(iterator1.hasNext(), is(true));
        assertThat(iterator1.next(), is(4));
        assertThat(iterator1.hasNext(), is(true));
        assertThat(iterator1.next(), is(5));
        assertThat(iterator1.hasNext(), is(true));
        assertThat(iterator1.next(), is(6));
        assertThat(iterator1.hasNext(), is(false));
    }
}