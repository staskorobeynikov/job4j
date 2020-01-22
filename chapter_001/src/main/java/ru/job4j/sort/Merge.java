package ru.job4j.sort;

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
}
