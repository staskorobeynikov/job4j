package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private int[] array;
    private int marker;

    public EvenIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        int nextMarker = -1;
        for (int i = marker; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                marker = i;
                nextMarker++;
                break;
            }
        }
        return nextMarker == 0;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return array[marker++];
        } else {
            throw new NoSuchElementException("Элемент не найден");
        }
    }
}
