package ru.job4j.exam;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {

    public static boolean equal(String left, String right) {
        Map<Character, Integer> leftMap = new HashMap<>();
        for (Character c : left.toCharArray()) {
            if (!leftMap.containsKey(c)) {
                leftMap.put(c, 1);
            } else {
                int count = leftMap.get(c) + 1;
                leftMap.put(c, count);
            }
        }
        for (Character c : right.toCharArray()) {
            Integer check = leftMap.get(c);
            if (check != null && check > 1) {
                check--;
                leftMap.put(c, check);
            } else {
                leftMap.remove(c);
            }
        }
        return leftMap.size() == 0;
    }
}
