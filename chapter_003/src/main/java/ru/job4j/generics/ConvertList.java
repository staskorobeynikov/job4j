package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertList {
    /**
     * Метод позволяет сформировать общий лист Integer
     * @param list список состоящий из массивов
     * @return List<Integer> общий листо сформированный из массивов
     */
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] nums : list) {
            for (int i : nums) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = convert(Arrays.asList(new int[]{1, 2}, new int[]{3, 4, 5, 6}));
        System.out.println(result);
    }
}
