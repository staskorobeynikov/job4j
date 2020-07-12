package ru.job4j.exam;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class FlatItTest {
    @Test
    public void whenTestWithTwoIterators() {
        Iterator<Iterator<Integer>> it = List.of(
                List.of(1).iterator(),
                List.of(2, 3).iterator()
        ).iterator();
        assertThat(
                FlatIt.flatten(it),
                is(List.of(1, 2, 3))
        );
    }

    @Test
    public void whenTestMethodWithFiveIterators() {
        Iterator<Iterator<Integer>> it = List.of(
                List.of(1).iterator(),
                List.of(2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9, 10).iterator(),
                List.of(11, 12, 13, 14, 15).iterator()
        ).iterator();
        assertThat(
                FlatIt.flatten(it),
                is(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
        );
    }

    @Test
    public void whenTestMethodWithoutStream() {
        Iterator<Iterator<Integer>> it = List.of(
                List.of(1).iterator(),
                List.of(2, 3).iterator()
        ).iterator();
        assertThat(
                FlatIt.flattenWithoutStream(it),
                is(List.of(1, 2, 3))
        );
    }
}