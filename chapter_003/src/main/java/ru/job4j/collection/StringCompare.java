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
        int exitCycle;
        int index = 0;
        exitCycle = Math.min(right.length(), left.length());
        for (int i = 0; i < exitCycle; i++) {
            index = Character.compare(left.charAt(i), right.charAt(i));
            if (index != 0) {
                break;
            }
        }
        return index == 0 ? Integer.compare(left.length(),
                right.length()) : index;
    }
}
