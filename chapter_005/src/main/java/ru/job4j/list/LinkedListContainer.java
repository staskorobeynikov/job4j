package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListContainer<E> implements Iterable {
    private Node<E> first = null;
    private Node<E> last = null;
    private int modCount = 0;
    public int listLength = 0;

    /**
     * Метод позволяет вставить элемент
     */
    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        listLength++;
        modCount++;
    }

    /**
     * Метод позволяет получить элемент по индексу
     */
    public E get(int index) {
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public E removeLast() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        E result = last.data;
        if (last == first) {
            last = null;
            first = null;
        } else {
            last = first;
            for (int i = 0; i < listLength - 2; i++) {
                last = last.next;
            }
            last.next = null;
        }
        listLength--;
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> lastReturned = first;
            private Node<E> nodeInMemory = null;
            private Node<E> temp = null;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkModCount();
                return lastReturned != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = lastReturned.data;
                temp = nodeInMemory;
                nodeInMemory = lastReturned;
                lastReturned = lastReturned.next;
                return result;
            }

            private void checkModCount() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
