package ru.job4j.exam;

import java.util.HashMap;
import java.util.Map;

public class MostUsedCharacter {
    /**
     * Метод определяет символ в строке, который употребляется в ней наибольшее количество
     * раз. Предварительно из строки удаляются пробелы и все символы приводятся к нижнему регистру.
     * @param str - строка в которой необходимо найти наиболее употребительный символ, не содержит
     *            знаки препинания.
     * @return - тип char - наиболее употребительный символ.
     */
    public static char getMaxCount(String str) {
        Map<Character, Integer> characters = new HashMap<>();
        for (Character c : str.replace(" ", "").toLowerCase().toCharArray()) {
            characters.computeIfPresent(c, (key, value) -> value + 1);
            characters.putIfAbsent(c, 1);
        }
        Integer max = characters
                .values()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);
        return characters
                .keySet()
                .stream()
                .filter(c -> characters.get(c).equals(max))
                .findFirst()
                .orElse(' ');
    }
}
