package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Узел дерева
 *
 * @ author Stas Korobeynikov
 * @ 23.12.2019
 */
public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    /**
     * Конструктор, инициализирует узел
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Добавление ребенка
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Список детей узла
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Сравнивает узлы. Возвращает true, если значение текущего узла равно передаваемому значению
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    public E getValue() {
        return value;
    }
}
