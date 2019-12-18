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
        return !(i == array.length - 1 && j == array[i].length);
    }

    @Override
    public T next() {
        while ((j >= array[i].length) && (i < array.length - 1)) {
            i++;
            j = 0;
        }
        if (j >= array[i].length) {
            throw new NoSuchElementException("Элемент не найден");
        } else {
            return array[i][j++];
        }
    }
}
