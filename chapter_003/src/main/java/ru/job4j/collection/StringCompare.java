package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    /**
     * Метод позволяет сравнить два слова
     * @param left слово с которым сравнивают
     * @param right слово которое сравнивают
     * @return возвращает число, которое означает где будет располагаться слово.
     */
    @Override
    public int compare(String left, String right) {
        boolean result;
        int exitCycle;
        int index = 0;
        exitCycle = Math.min(right.length(), left.length());
        do {
            if (exitCycle == 0) {
                return 1;
            }
            if (left.charAt(index) == right.charAt(index)) {
                result = true;
                index++;
            } else {
                result = false;
            }
        } while (result && index < exitCycle);
        return result ? left.length()
                - right.length() : left.charAt(index)
                - right.charAt(index);
    }
}
