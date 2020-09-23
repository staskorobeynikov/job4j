package ru.job4j.exam;

import java.util.List;
import java.util.function.Predicate;

public class Job4jStream<T> {
    private List<T> source;

    private Predicate<T> filter;

    public static <T> Job4jStream<T> of(List<T> list) {
        return new Builder<T>()
                .buildSource(list)
                .build();
    }

    public Job4jStream<T> filter(Predicate<T> filter) {
        return new Builder<T>()
                .buildSource(source)
                .buildFilter(filter)
                .build();
    }

    public List<T> collect(List<T> list) {
        for (T t : source) {
            if (filter.test(t)) {
                list.add(t);
            }
        }
        return list;
    }

    static class Builder<T> {
        private List<T> source;

        private Predicate<T> filter;

        Builder<T> buildSource(List<T> list) {
            this.source = list;
            return this;
        }

        Builder<T> buildFilter(Predicate<T> filter) {
            this.filter = filter;
            return this;
        }

        Job4jStream<T> build() {
            Job4jStream<T> stream = new Job4jStream<>();
            stream.source = source;
            stream.filter = filter;
            return stream;
        }
    }
}
