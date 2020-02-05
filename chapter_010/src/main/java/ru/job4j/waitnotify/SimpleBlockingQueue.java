package ru.job4j.waitnotify;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@ThreadSafe
class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    private int limit;

    SimpleBlockingQueue(int limit) {
        this.limit = limit;
    }

    synchronized void offer(T value) throws InterruptedException {
        while (queue.size() == limit) {
            this.wait();
        }
        queue.offer(value);
        notify();
    }

    synchronized T poll() throws InterruptedException {
        while (queue.size() == 0) {
            this.wait();
        }
        T result = this.queue.poll();
        notify();
        return result;
    }

    synchronized int getSize() {
        return queue.size();
    }

    synchronized List<T> getElement() {
        return new ArrayList<>(queue);
    }
}
