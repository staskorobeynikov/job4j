package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        boolean result;
        int exitCycle = 0;
        int index = 0;
        if (left.length() >= right.length()) {
            exitCycle = right.length();
        } else {
            exitCycle = left.length();
        }
        do {
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
