package ru.job4j.exam;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {

    public static boolean equalWithEvenNumber(String left, String right) {
        Map<Character, Integer> leftMap = new HashMap<>();
        for (Character c : left.toCharArray()) {
            int count = 1;
            Integer value = leftMap.get(c);
            if (value != null) {
                count = value + 1;
            }
            leftMap.put(c, count);
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

    public static boolean equal(String left, String right) {
        boolean result = true;
        String combine = String.format("%s%s", left, right);
        Map<Character, Integer> letters = new HashMap<>();
        for (Character c : combine.toCharArray()) {
            int count = 1;
            Integer value = letters.get(c);
            if (value != null) {
                count = value + 1;
            }
            letters.put(c, count);
        }
        for (Character c : letters.keySet()) {
            if (letters.get(c) % 2 != 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (Character c : s.toCharArray()) {
            result.put(c, result.size());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(FreezeStr.getMap("Hello"));
    }
}
