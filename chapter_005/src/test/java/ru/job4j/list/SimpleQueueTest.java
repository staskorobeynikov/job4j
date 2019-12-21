package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    SimpleQueue<Integer> queue;

    @Before
    public void init() {
        queue = new SimpleQueue<>();
    }

    @Test
    public void whenPush51015AndPoll() {
        queue.push(5);
        queue.push(10);
        queue.push(15);
        assertThat(queue.poll(), is(5));
        assertThat(queue.poll(), is(10));
        assertThat(queue.poll(), is(15));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenPushOneElementPollTwoElements() {
        queue.push(5);
        queue.poll();
        queue.poll();
    }
}