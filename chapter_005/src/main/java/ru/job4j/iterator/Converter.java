package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    /**
     * Метод позволяет пройтись по вложенным итераторам
     * @param itAll итератор с вложенными итераторами
     * @return итератор чисел
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> itAll) {
        return new Iterator<>() {
            private Iterator<Integer> marker = itAll.next();

            @Override
            public boolean hasNext() {
                Iterator<Integer> itInner;
                while (!marker.hasNext() && itAll.hasNext()) {
                    marker = itAll.next();
                }
                itInner = marker;
                return itInner.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Элемент не найден");
                }
                return marker.next();
            }
        };
    }
}