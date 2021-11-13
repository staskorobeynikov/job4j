package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;

public class SortUser {
    public static List<User> sortNameLength(List<User> users) {
        users.sort(Comparator.comparingInt(one -> one.getName().length()));
        return users;
    }

    public static List<User> sortByAllFields(List<User> users) {
        users.sort(Comparator.comparing(User::getName).thenComparingInt(User::getAge));
        return users;
    }
}
