package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable {
    private Node<K, V>[] table;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int index = 0;

    public SimpleHashMap() {
        table = new Node[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * Метод повзоляет добавить элемент в коллекцию по ключу
     */
    public boolean insert(K key, V value) {
        boolean result = true;
        if (get(key) != null) {
            getNode(key).setValue(value);
            result = false;
        } else {
            verifySize();
            table[index++] = new Node<>(key.hashCode(), key, value, null);
        }
        return result;
    }

    /**
     * Метод осуществляет поиск элемента по ключу
     */
    public V get(K key) {
        Node<K, V> result = getNode(key);
        return result == null ? null : result.getValue();
    }

    /**
     * Метод осуществляет удаление элемента из коллекции по ключу
     */
    public boolean delete(K key) {
        boolean result = false;
        for (int i = 0; i < index; i++) {
            if (table[i].getKey().equals(key)) {
                System.arraycopy(table, i + 1, table, i, table.length - 1 - i);
                result = true;
                index--;
                break;
            }
        }
        return result;
    }

    private void verifySize() {
        if (index == table.length) {
            table = Arrays.copyOf(table, table.length * 2);
        }
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> result = null;
        for (int i = 0; i < index; i++) {
            if (table[i].getKey().equals(key)) {
                result = table[i];
                break;
            }
        }
        return result;
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public String toString() {
            return String.format("Key: %s = Value: %s", key, value);
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int iterIndex;

            @Override
            public boolean hasNext() {
                return iterIndex < index;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Element not found");
                }
                return table[iterIndex++];
            }
        };
    }
}
