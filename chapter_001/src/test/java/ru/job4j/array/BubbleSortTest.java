package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithElevenElementsThenSortedArray() {
        int[] array = {11, 42, 7, 85, 5, 90, 25, 56, 70, 101, 16};
        int[] result = BubbleSort.sort(array);
        int[] expect = {5, 7, 11, 16, 25, 42, 56, 70, 85, 90, 101};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortArrayWithDuplicateElements() {
        int[] array = {19, 10, 0, 7, 19, 4, 17, 10, 55, 37, 107, 8, 16};
        int[] result = BubbleSort.sort(array);
        int[] expect = {0, 4, 7, 8, 10, 10, 16, 17, 19, 19, 37, 55, 107};
        assertThat(result, is(expect));
    }
}