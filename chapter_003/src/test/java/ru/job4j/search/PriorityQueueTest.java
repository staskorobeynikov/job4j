package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPrioritySecond() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
    @Test
    public void whenHigherPriorityFirst() {
        var queue1 = new PriorityQueue();
        queue1.put(new Task("low", 1));
        queue1.put(new Task("urgent", 5));
        queue1.put(new Task("middle", 3));
        var result = queue1.take();
        assertThat(result.getDesc(), is("low"));
    }
    @Test
    public void whenHigherPriorityThird() {
        var queue1 = new PriorityQueue();
        queue1.put(new Task("low", 3));
        queue1.put(new Task("urgent", 5));
        queue1.put(new Task("middle", 1));
        var result = queue1.take();
        assertThat(result.getDesc(), is("middle"));
    }
    @Test
    public void whenHigherPriorityEquals() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 5));
        queue.put(new Task("middle", 5));
        var result = queue.take();
        assertThat(result.getDesc(), is("low"));
    }

}
