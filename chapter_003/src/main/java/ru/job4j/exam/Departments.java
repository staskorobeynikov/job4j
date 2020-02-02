package ru.job4j.exam;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        HashSet<String> temp = new HashSet<>();
        for (String value : departments) {
            String[] valueSplit = value.split("/");
            temp.add(valueSplit[0]);
            if (valueSplit.length > 1) {
                String start = valueSplit[0];
                for (int i = 1; i < valueSplit.length; i++) {
                    String join = valueSplit[i];
                    start = String.join("/", start, join);
                    temp.add(start);
                }
            }
        }
        return new ArrayList<>(temp);
    }

    public static List<String> sortAsc(List<String> departments) {
        Set<String> result = new TreeSet<>(fillGaps(departments));
        return new ArrayList<>(result);
    }

    public static List<String> sortDesc(List<String> departments) {
        List<String> result = new ArrayList<>(fillGaps(departments));
        result.sort(new DepDescComp());
        return result;
    }
}
