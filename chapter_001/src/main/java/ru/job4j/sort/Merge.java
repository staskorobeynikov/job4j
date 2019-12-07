package ru.job4j.sort;

import java.util.Arrays;

public class Merge {
    public int[] merge(int[] left, int[] right) {
        int i = 0;
        int leftI = 0;
        int rightI = 0;
        int[] result = new int[left.length + right.length];
        while (i < left.length + right.length) {
            if (leftI >= left.length) {
                result[i] = right[rightI];
                rightI++;
            } else if (rightI >= right.length) {
                result[i] = left[leftI];
                leftI++;
            } else if (left[leftI] < right[rightI]) {
                result[i] = left[leftI];
                leftI++;
            } else {
                result[i] = right[rightI];
                rightI++;
            }
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        Merge process = new Merge();
        int[] result = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(result));
    }
}
