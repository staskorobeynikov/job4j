package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortSelectedTest {
    @Test
    public void whenSort() {
        int[] input = new int[] {3, 4, 1, 2, 5};
        int result[] = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }
    @Test
    public void whenSort3Numbers() {
        int[] input = new int[] {11, 42, 7};
        int result[] = SortSelected.sort(input);
        int[] expect = new int[] {7, 11, 42};
        assertThat(result, is(expect));
    }
    @Test
    public void whenSort10Numbers() {
        int[] input = new int[] {11, 42, 7, 85, 5, 90, 25, 56, 70, 101, 16};
        int result[] = SortSelected.sort(input);
        int[] expect = new int[] {5, 7, 11, 16, 25, 42, 56, 70, 85, 90, 101};
        assertThat(result, is(expect));
    }
}
