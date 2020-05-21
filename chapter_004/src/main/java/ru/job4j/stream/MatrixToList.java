package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    /**
     * Метод позволяет преобразовать матрицу в список чисел
     * @param array матрица, которую необходимо преобразовать
     * @return List<Integer> возвращает преобразованную матрицу в виде списка
     */
    public List<Integer> convert(Integer[][] array) {
        return Arrays.stream(array)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
