package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    /**
     * Метод позволяет преобразовать список в двумерный массив
     * @param list список значений
     * @param cells количество необходимых разбиений
     * @return array[][] двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            if (cell < cells - 1) {
                array[row][cell] = num;
                cell++;
            } else {
                array[row][cell] = num;
                row++;
                cell = 0;
            }
        }
        return array;
    }
}
