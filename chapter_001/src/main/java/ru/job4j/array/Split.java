package ru.job4j.array;

import java.util.Arrays;

public class Split {
    public static char[][] split(char[] str, char c) {
        char[][] result = new char[str.length / 2][];
        int commonCount = 1;
        int k = 0;
        char[] chars = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            if (str[i] == c) {
                chars = Arrays.copyOf(chars, k);
                result[commonCount - 1] = chars;
                k = 0;
                chars = new char[str.length];
                commonCount++;
            } else {
                chars[k++] = str[i];
                if (i == str.length - 1){
                    chars = Arrays.copyOf(chars, k);
                    result[commonCount - 1] = chars;
                }
            }
        }
        return Arrays.copyOf(result, commonCount);
    }
}
