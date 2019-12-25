package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Контейнер на базе ассоциативного массива, который хранит пары
 * типа "ключ - значение".
 *
 * @author Stas Korobeynikov
 * @since 23.12.2019
 */
public class SimpleHashMap<K, V> implements Iterable {
    private Node<K, V>[] table;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    /**
     * Количество элементов в массиве
     */
    private int size = 0;
    private int capacity;

    public SimpleHashMap() {
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        table = new Node[capacity];
    }

    /**
     * Метод повзоляет добавить элемент в коллекцию по ключу.
     * Вставка осуществляется по индексу, который расчитывается по значению хэшкода ключа
     * и размеру массива. Если ячейка с таким индексом уже заполнена - вставка элемента производится
     * в первую пустую ячейку (отсчет начинается с начала массива).
     */
    public boolean insert(K key, V value) {
        boolean result = true;
        Node<K, V> e;
        if (size >= 0.75 * capacity) {
            resize();
        }
        int i = getIndex(key);
        if (table[i] == null) {
            table[i] = new Node<>(key.hashCode(), key, value, null);
            size++;
        } else {
            e = table[i];
            if (e.hash == key.hashCode() && (e.key == key || e.key.equals(key))) {
                e.value = value;
                result = false;
            } else {
                for (int j = 0; j < table.length; j++) {
                    if (table[j] == null) {
                        table[j] = new Node<>(key.hashCode(), key, value, null);
                        size++;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Метод осуществляет поиск элемента по ключу. При несовпадении хэшкода, дополнительно поиск
     * производится по всему массиву.
     */
    public V get(K key) {
        V result = null;
        int i = getIndex(key);
        Node<K, V> e = table[i];
        if (e != null) {
            if (e.hash == key.hashCode() && (e.key == key || e.key.equals(key))) {
                result = e.value;
            } else {
                for (Node<K, V> elFind : table) {
                    if (elFind.hash == key.hashCode()
                            && (elFind.key == key || elFind.key.equals(key))) {
                        result = elFind.value;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Метод осуществляет удаление элемента из коллекции по ключу, на основе которого расчитывается
     * индекс элемента в массиве. Если при обращении к этой ячейке окажется, что хэшкод ключей
     * не совпадает - поиск элемента осуществляется по всему массиву.
     */
    public boolean delete(K key) {
        boolean result = false;
        int i = getIndex(key);
        Node<K, V> e = table[i];
        if (e.hash == key.hashCode() && (e.key == key || e.key.equals(key))) {
            table[i] = null;
            result = true;
            size--;
        } else {
            for (Node<K, V> elFind : table) {
                if (elFind.hash == key.hashCode()
                        && (elFind.key == key || elFind.key.equals(key))) {
                    elFind = null;
                    result = true;
                    size--;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Возвращает индекс в массиве по ключу, для которого вычисляется хэш-код
     */
    private int getIndex(K key) {
        return key.hashCode() & (capacity - 1);
    }

    public int getSize() {
        return size;
    }

    public int getLength() {
        return table.length;
    }

    /**
     * Вспомогательный метод, позволяет увеличить размер массива при его переполнении.
     */
    private void resize() {
        capacity *= 2;
        Node<K, V>[] oldTable = table;
        table = new Node[capacity];
        for (Node<K, V> e : oldTable) {
            if (e != null) {
                table[getIndex(e.key)] = e;
            }
        }
    }

    static class Node<K, V> {
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

        public V getValue() {
            return value;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index;
            Node<K, V> e = table[index];

            @Override
            public boolean hasNext() {
                while ((index < (capacity - 1)) && e == null) {
                    index++;
                    e = table[index];
                }
                return e != null;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Element not found");
                }
                Node<K, V> result = e;
                if (e.next != null) {
                    e = e.next;
                } else {
                    while (index < capacity - 1) {
                        index++;
                        e = table[index];
                        if (e != null) {
                            break;
                        }
                    }
                }
                return result;
            }
        };
    }
}
