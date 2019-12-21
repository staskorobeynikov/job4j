package ru.job4j.list;

public class SimpleQueue<E> {
    private SimpleStack<E> queue = new SimpleStack<>();
    private SimpleStack<E> changed = new SimpleStack<>();

    /**
     * Метод позволяет удалить элемент и вернуть его значение
     */
    public E poll() {
        if (changed.isEmpty()) {
            while (!queue.isEmpty()) {
                changed.push(queue.poll());
            }
        }
        return changed.poll();
    }

    /**
     * Метод позволяет добавить элемент
     */
    public void push(E value) {
        queue.push(value);
    }
}
