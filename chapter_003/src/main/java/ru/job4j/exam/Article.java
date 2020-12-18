package ru.job4j.exam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] splitO = origin.replaceAll("\\p{P}", "").split(" ");
        String[] splitL = line.replaceAll("\\p{P}", "").split(" ");
        Set<String> original = new HashSet<>(Arrays.asList(splitO));
        for (String s : splitL) {
            if (!original.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
