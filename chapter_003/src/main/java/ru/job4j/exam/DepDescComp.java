package ru.job4j.exam;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        int result = 0;
        int exitCycle = Math.min(first.length(), second.length());
        for (int i = 0; i < exitCycle; i++) {
            result = Character.compare(second.charAt(i), first.charAt(i));
            if (result != 0) {
                break;
            }
        }
        return result == 0 ? Integer.compare(first.length(), second.length()) : result;
    }
}
