package ru.job4j.list;

public class SimpleStack<E> {
    LinkedListContainer<E> stack = new LinkedListContainer<>();

    /**
     *  Метод позволяет удалить элемент из стека
     * @return Элемент, который удаляют
     */
    public E poll() {
        return stack.removeLast();
    }

    /**
     * Метод позволяет добавить элемент в стек
     */
    public void push(E value) {
        stack.add(value);
    }

    public boolean isEmpty() {
        return stack.listLength == 0 ? true : false;
    }
}
