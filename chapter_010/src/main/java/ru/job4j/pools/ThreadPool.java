package ru.job4j.pools;

import ru.job4j.waitnotify.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

class ThreadPool {
    private final int size = Runtime.getRuntime().availableProcessors();

    private final List<Thread> threads = new LinkedList<>();

    private final SimpleBlockingQueue<Runnable> tasks;

    ThreadPool() {
        tasks = new SimpleBlockingQueue<>(size);
    }

    void work(Runnable job) throws InterruptedException {
        if (threads.size() != size) {
            tasks.offer(job);
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
