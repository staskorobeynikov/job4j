package ru.job4j.generic;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int sizeArray = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        if (sizeArray >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Массив переполнен");
        }
        array[sizeArray++] = model;
    }

    public void set(int index, T model) {
        if (index > sizeArray - 1) {
            throw new ArrayIndexOutOfBoundsException("Индекс больше размера "
                    + "массива");
        }
        array[index] = model;
    }

    public void remove(int index) {
        sizeArray--;
        System.arraycopy(array, index + 1, array,
                index, sizeArray - index);
        array[sizeArray] = null;
    }
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int marker = 0;
            @Override
            public boolean hasNext() {
                return marker < sizeArray;
            }

            @Override
            public T next() {
                return (T) array[marker++];
            }
        };
    }

    public int getLength() {
        return sizeArray;
    }
}
