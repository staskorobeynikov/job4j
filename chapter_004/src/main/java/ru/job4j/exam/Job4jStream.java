package ru.job4j.exam;

import java.util.List;
import java.util.function.Predicate;

public class Job4jStream<T> {
    private List<T> source;

    private Predicate<T> filter;

    public static <T> Job4jStream<T> of(List<T> list) {
        return null;
    }

    public Job4jStream<T> filter(Predicate<T> filter) {
        return null;
    }

    public List<T> collect(List<T> list) {
        return null;
    }

    static class Builder<T> {
        private Job4jStream<T> stream;

    }
}
