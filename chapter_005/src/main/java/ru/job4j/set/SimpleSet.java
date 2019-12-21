package ru.job4j.set;

import ru.job4j.list.DynamicContainer;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private DynamicContainer<E> ss = new DynamicContainer<>(10);

    /**
     * Метод позволяет добавить элемент в коллекцию
     */
    public void add(E value) {
        if (checkUnique(value)) {
            ss.add(value);
        }
    }

    /**
     * Метод выполняет проверку является ли элемент уникальным для коллекции
     */
    private boolean checkUnique(E value) {
        Iterator<E> it = ss.iterator();
        boolean result = true;
        while (it.hasNext()) {
            if ((it.next().equals(value))) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return ss.iterator();
    }
}
