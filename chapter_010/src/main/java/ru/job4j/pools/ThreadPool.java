package ru.job4j.pools;

import ru.job4j.waitnotify.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

class ThreadPool {
    private final int size = Runtime.getRuntime().availableProcessors();

    private final List<Thread> threads = new LinkedList<>();

    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(size);

    void work(Runnable job) throws InterruptedException {
        tasks.offer(job);
        if (threads.size() != size) {
            Thread thread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        tasks.poll().run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }
    }

    void shutdown() {
        for (Thread threadPool : threads) {
            threadPool.interrupt();
        }
    }
}
