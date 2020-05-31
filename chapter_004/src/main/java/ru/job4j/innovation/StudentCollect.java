package ru.job4j.innovation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentCollect {
    /**
     * Метод позволяет получить список студентов, у которых балл аттестата
     * больше заданного значения
     * @param students Список студентов
     * @param bound количество баллов, выше которого должны иметь студенты
     * @return Список студентов которые прошли проверку
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        return students
                .stream()
                .flatMap(Stream::ofNullable)
                .sorted(Comparator.reverseOrder())
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
