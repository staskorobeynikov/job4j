package ru.job4j.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> source;

    private EasyStream() {
    }

    public static EasyStream of(List<Integer> source) {
        return new Builder()
                .buildSource(source)
                .build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer i : source) {
            rsl.add(fun.apply(i));
        }
        return new Builder()
                .buildSource(rsl)
                .build();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer i : source) {
            if (fun.test(i)) {
                rsl.add(i);
            }
        }
        return new Builder()
                .buildSource(rsl)
                .build();
    }

    public List<Integer> collect() {
        return source;
    }

    static class Builder {
        private List<Integer> source;

        Builder buildSource(List<Integer> source) {
            this.source = source;
            return this;
        }

        EasyStream build() {
            EasyStream stream = new EasyStream();
            stream.source = source;
            return stream;
        }
    }
}
