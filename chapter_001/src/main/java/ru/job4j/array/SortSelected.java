package ru.job4j.array;

public class SortSelected {
    public int[] sort(int[] data) {
        MinDiapason minDiapason = new MinDiapason();
        for (int i = 0; i < data.length; i++) {
            int min = minDiapason.findMin(data, i, data.length);
            int index = FindLoop.indexOf(data, min, i, data.length);
            if (min != data[i]) {
                int temp = data[i];
                data[i] = data[index];
                data[index] = temp;
            }
        }
        return data;
    }
}
