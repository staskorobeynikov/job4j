package ru.job4j.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;

@ThreadSafe
public class SingleLockList<E> implements Iterable<E> {
    @GuardedBy("this")
    private DynamicContainer<E> container;

    SingleLockList(DynamicContainer<E> container) {
        this.container = container;
    }

    synchronized void add(E value) {
        container.add(value);
    }

    synchronized E get(int index) {
        return container.get(index);
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return copy().iterator();
    }

    private synchronized DynamicContainer<E> copy() {
        DynamicContainer<E> result = new DynamicContainer<>();
        for (E value : container) {
            result.add(value);
        }
        return result;
    }
}
