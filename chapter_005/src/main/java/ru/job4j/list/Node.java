package ru.job4j.list;

public class Node<E> {
    E value;
    Node<E> next;

    public Node(E value) {
        this.value = value;
    }
}
