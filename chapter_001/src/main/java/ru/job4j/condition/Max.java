package ru.job4j.condition;

public class Max {

    public static int max(int first, int second) {
        return first >= second ? first : second;
    }

    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    public int max(int first, int second, int third, int forth) {
        return max(first, max(second, max(third, forth)));
    }
}
