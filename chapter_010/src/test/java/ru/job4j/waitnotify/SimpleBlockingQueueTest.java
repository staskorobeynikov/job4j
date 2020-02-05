package ru.job4j.waitnotify;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {

    @Test
    public void whenTestClassBlockQueue() throws InterruptedException {
        SimpleBlockingQueue<Integer> producerQueue = new SimpleBlockingQueue<>(5);
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    producerQueue.offer(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (producerQueue.getSize() > 2) {
                try {
                    producerQueue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

        List<Integer> result = producerQueue.getElement();

        assertThat(producerQueue.getSize(), is(2));
        assertThat(result, is(List.of(4, 5)));
    }
}