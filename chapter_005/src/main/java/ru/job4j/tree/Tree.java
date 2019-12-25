package ru.job4j.tree;

import java.util.*;

/**
 * Дерево для хранения элементов
 *
 * @ author Stas Korobeynikov
 * @ 23.12.2019
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public Tree(E value) {
        root = new Node(value);
    }

    /**
     * Метод позволяет добавить элемент в дерево.
     * Дубликаты не допустимы.
     * @param parent - элемент родитель.
     * @param child - добавляемый элемент.
     * @return - true, если элемент добавлен в дерево
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> par = findBy(parent);
        if (!par.isPresent()) {
            throw new NoSuchElementException("Element not found");
        }
        Node<E> newNode = par.get();
        if (!newNode.leaves().contains(child)) {
            newNode.add(new Node<>(child));
            result = true;
        }
        return result;
    }

    /**
     * Позволяет найти узел по значению на основе алгоритма поиска по ширине
     * дерева.
     * @param value - искомое значение.
     * @return - узел Node<E>.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public boolean isBinary() {
        boolean result = false;
        int amountChildren = 0;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        Node<E> el = data.poll();
        for (Node<E> child : el.leaves()) {
            amountChildren++;
        }
        if (amountChildren <= 2) {
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        return new Iterator<E>() {
            Node<E> actual = root;
            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = actual.getValue();
                if (!actual.leaves().isEmpty()) {
                    for (Node<E> child : actual.leaves()) {
                        data.offer(child);
                    }
                }
                actual = data.isEmpty() ? null : data.poll();
                return value;
            }
        };
    }
}
