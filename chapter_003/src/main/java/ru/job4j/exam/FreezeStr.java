package ru.job4j.exam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FreezeStr {

    public static boolean equal(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        Map<Character, Integer> leftMap = new HashMap<>();
        for (Character c : left.toCharArray()) {
            leftMap.computeIfPresent(c, (key, value) -> value + 1);
            leftMap.putIfAbsent(c, 1);
        }
        for (Character c : right.toCharArray()) {
            leftMap.computeIfPresent(c, (key, value) -> value - 1);
            leftMap.remove(c, 0);
        }
        return leftMap.size() == 0;
    }

    public static boolean equalWithSetValues(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        Map<Character, Integer> leftMap = new HashMap<>();
        for (Character c : left.toCharArray()) {
            leftMap.computeIfPresent(c, (key, value) -> value + 1);
            leftMap.putIfAbsent(c, 1);
        }
        for (Character c : right.toCharArray()) {
            leftMap.computeIfPresent(c, (key, value) -> value - 1);
        }
        Set<Integer> integers = new HashSet<>(leftMap.values());
        return integers.size() == 1;
    }
}
