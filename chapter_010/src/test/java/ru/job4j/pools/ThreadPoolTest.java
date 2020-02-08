package ru.job4j.pools;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@Ignore
public class ThreadPoolTest {

    private int actionForTest() {
        int result = 1;
        for (int i = 1; i <= 7; i++) {
            result *= i;
        }
        return result;
    }

    @Test
    public void whenCountRunEqualsCountProcessors() throws InterruptedException {
        AtomicInteger result = new AtomicInteger();
        Runnable run1 = () -> result.addAndGet(actionForTest());
        Runnable run2 = () -> result.addAndGet(actionForTest());
        Runnable run3 = () -> result.addAndGet(actionForTest());
        Runnable run4 = () -> result.addAndGet(actionForTest());
        Runnable run5 = () -> result.addAndGet(actionForTest());
        Runnable run6 = () -> result.addAndGet(actionForTest());
        Runnable run7 = () -> result.addAndGet(actionForTest());
        Runnable run8 = () -> result.addAndGet(actionForTest());

        ThreadPool threadPool = new ThreadPool();

        threadPool.work(run1);
        threadPool.work(run2);
        threadPool.work(run3);
        threadPool.work(run4);
        threadPool.work(run5);
        threadPool.work(run6);
        threadPool.work(run7);
        threadPool.work(run8);
        Thread.sleep(1000);
        threadPool.shutdown();

        assertThat(result.get(), is(40320));
    }

    @Test
    public void whenCountRunGreatCountProcessor() throws InterruptedException {
        AtomicInteger result = new AtomicInteger();
        Runnable run1 = () -> result.addAndGet(actionForTest());
        Runnable run2 = () -> result.addAndGet(actionForTest());
        Runnable run3 = () -> result.addAndGet(actionForTest());
        Runnable run4 = () -> result.addAndGet(actionForTest());
        Runnable run5 = () -> result.addAndGet(actionForTest());
        Runnable run6 = () -> result.addAndGet(actionForTest());
        Runnable run7 = () -> result.addAndGet(actionForTest());
        Runnable run8 = () -> result.addAndGet(actionForTest());
        Runnable run9 = () -> result.addAndGet(actionForTest());
        Runnable run10 = () -> result.addAndGet(actionForTest());
        Runnable run11 = () -> result.addAndGet(actionForTest());
        Runnable run12 = () -> result.addAndGet(actionForTest());
        Runnable run13 = () -> result.addAndGet(actionForTest());
        Runnable run14 = () -> result.addAndGet(actionForTest());
        Runnable run15 = () -> result.addAndGet(actionForTest());
        Runnable run16 = () -> result.addAndGet(actionForTest());

        ThreadPool threadPool = new ThreadPool();

        threadPool.work(run1);
        threadPool.work(run2);
        threadPool.work(run3);
        threadPool.work(run4);
        threadPool.work(run5);
        threadPool.work(run6);
        threadPool.work(run7);
        threadPool.work(run8);
        threadPool.work(run9);
        threadPool.work(run10);
        threadPool.work(run11);
        threadPool.work(run12);
        threadPool.work(run13);
        threadPool.work(run14);
        threadPool.work(run15);
        threadPool.work(run16);
        Thread.sleep(1000);
        threadPool.shutdown();

        assertThat(result.get(), is(40320));
    }

    @Test
    public void whenCountRunLessCountProcessor() throws InterruptedException {
        AtomicInteger result = new AtomicInteger();
        Runnable run1 = () -> result.addAndGet(actionForTest());
        Runnable run2 = () -> result.addAndGet(actionForTest());
        Runnable run3 = () -> result.addAndGet(actionForTest());
        Runnable run4 = () -> result.addAndGet(actionForTest());

        ThreadPool threadPool = new ThreadPool();

        threadPool.work(run1);
        threadPool.work(run2);
        threadPool.work(run3);
        threadPool.work(run4);
        Thread.sleep(1000);
        threadPool.shutdown();

        assertThat(result.get(), is(20160));
    }
}