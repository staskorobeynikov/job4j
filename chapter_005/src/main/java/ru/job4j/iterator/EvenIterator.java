package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private int[] array;
    private int marker = -1;

    public EvenIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return nextEvenNumber() != -1;
    }

    @Override
    public Object next() {
        marker = nextEvenNumber();
        if (marker == -1) {
            throw new NoSuchElementException("Элемент не найден");
        }
        return array[marker];
    }

    int nextEvenNumber() {
        int nextMarker = -1;
        for (int i = marker + 1; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                nextMarker = i;
                break;
            }
        }
        return nextMarker;
    }
}
