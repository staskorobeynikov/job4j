package ru.job4j.nba;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NonBlockingCacheTest {

    @Test
    public void whenResultIsThrowException() throws InterruptedException {
        NonBlockingCache nonBlockingCache = new NonBlockingCache();
        nonBlockingCache.add(new Base(1, "name1", 0));
        AtomicReference<Exception> ex = new AtomicReference<>();

        Thread first = new Thread(() -> {
            try {
                Base model = nonBlockingCache.getModel(1);
                model.setName("name2");
                Thread.sleep(500);
                nonBlockingCache.update(model);
            } catch (Exception e) {
                ex.set(e);
            }
        });

        Thread second = new Thread(() -> {
            try {
                Base model = nonBlockingCache.getModel(1);
                model.setName("name3");
                Thread.sleep(500);
                nonBlockingCache.update(model);
            } catch (Exception e) {
                ex.set(e);
            }
        });
        first.start();
        second.start();
        first.join();
        second.join();

        assertThat(ex.get().getMessage(), is("Data can't be changed."));
    }

    @Test
    public void when1() {
        NonBlockingCache nonBlockingCache = new NonBlockingCache();
        Base model1 = new Base(1, "name1", 0);
        Base model2 = new Base(2, "name2", 0);
        Base model3 = new Base(3, "name3", 0);
        nonBlockingCache.add(model1);
        nonBlockingCache.add(model2);
        nonBlockingCache.add(model3);

        String result = nonBlockingCache.delete(model2).toString();

        assertThat(result, is("Base: id=2, name=name2, version=0"));
    }

    @Test
    public void when2() {
        NonBlockingCache nonBlockingCache = new NonBlockingCache();
        Base model1 = new Base(1, "name1", 0);
        Base model2 = new Base(2, "name2", 0);
        Base model3 = new Base(3, "name3", 0);
        nonBlockingCache.add(model1);
        nonBlockingCache.add(model2);
        nonBlockingCache.add(model3);

        int result = nonBlockingCache.getModel(3).hashCode();

        assertThat(result, is(-1052800614));
    }

    @Test
    public void when() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                        throw new RuntimeException("Throw Exception in Thread");
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        thread.start();
        thread.join();
        assertThat(ex.get().getMessage(), is("Throw Exception in Thread"));
    }
}