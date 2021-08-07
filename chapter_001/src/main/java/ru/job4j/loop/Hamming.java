package ru.job4j.loop;

public class Hamming {
    public static int checkStrings(String left, String right) {
        int rsl = 0;
        for (int i = 0; i < left.length(); i++) {
            char l = left.charAt(i);
            char r = right.charAt(i);
            if (l != r) {
                rsl++;
            }
        }
        return rsl;
    }
}
