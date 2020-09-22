package ru.job4j.exam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Job4jStreamTest {
    @Test
    public void whenStringCollect() {
        List<String> list = List.of(
                "one", "two",
                "three", "four",
                "five"
        );
        Predicate<String> predicate = s -> s.length() > 4;
        List<String> collect = Job4jStream
                .of(list)
                .filter(predicate)
                .collect(new ArrayList<>());
        List<String> expected = List.of("three");
        assertThat(collect, is(expected));
    }

    @Test
    public void whenIntegerCollect() {
        List<Integer> list = List.of(
                1, 5, -10, 7, -100, 18
        );
        Predicate<Integer> predicate = i -> i < 0;
        List<Integer> collect = Job4jStream
                .of(list)
                .filter(predicate)
                .collect(new ArrayList<>());
        List<Integer> expected = List.of(-10, -100);
        assertThat(collect, is(expected));
    }
}