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
        if (par.isEmpty()) {
            throw new NoSuchElementException("Element not found");
        }
        if (findBy(child).isEmpty()) {
            par.get().add(new Node<>(child));
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
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> e = data.poll();
            for (Node<E> child : e.leaves()) {
                data.offer(child);
            }
            if (e.leaves().size() > 2) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Collection is empty");
                }
                Node<E> e = data.poll();
                E result = null;
                if (e != null) {
                    for (Node<E> child : e.leaves()) {
                        data.offer(child);
                    }
                    result = e.getValue();
                }
                return result;
            }
        };
    }
}
