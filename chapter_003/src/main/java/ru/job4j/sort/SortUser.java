package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;

public class SortUser {
    public static List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User one, User two) {
                return one.getName().length() - two.getName().length();
            }
        });
        return users;
    }
    public static List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User one, User two) {
                int result = one.getName().compareTo(two.getName());
                return result == 0 ? one.getAge() - two.getAge() : result;
            }
        });
        return users;
    }
}
