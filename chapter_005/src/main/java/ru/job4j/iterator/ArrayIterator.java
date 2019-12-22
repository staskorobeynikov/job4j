package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private int i = 0;
    private int j = 0;
    private T[][] array;

    public ArrayIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return j != array[i].length || i < array.length - 1;
    }

    @Override
    public T next() {
        while ((j >= array[i].length) && (i < array.length - 1)) {
            i++;
            j = 0;
        }
        if (!hasNext()) {
            throw new NoSuchElementException("Элемент не найден");
        }
        return array[i][j++];
    }
}
