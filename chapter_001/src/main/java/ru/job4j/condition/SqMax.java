package ru.job4j.condition;

public class SqMax {

    public int max(int first, int second, int third, int forth) {
        return max(max(first, second), max(third, forth));
    }

    private int max(int first, int second) {
        return first >= second ? first : second;
    }
}

