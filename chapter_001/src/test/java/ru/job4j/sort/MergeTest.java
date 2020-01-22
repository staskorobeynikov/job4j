package ru.job4j.sort;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MergeTest {

    @Test
    public void whenBothEmpty() {
        Merge merge = new Merge();
        int[] expect = new int[0];
        assertThat(merge.merge(new int[0], new int[0]), is(expect));
    }

    @Test
    public void whenAscOrder() {
        Merge merge = new Merge();
        int[] expect = {1, 2, 3, 4};
        assertThat(merge.merge(new int[] {1, 2}, new int[] {3, 4}), is(expect));
    }

    @Test
    public void whenLeftLess() {
        Merge merge = new Merge();
        int[] expect = {1, 2, 3, 3, 4};
        assertThat(merge.merge(new int[] {1, 2, 3}, new int[] {3, 4}), is(expect));
    }

    @Test
    public void whenLeftGreat() {
        Merge merge = new Merge();
        int[] expect = {1, 2, 3, 4, 4};
        assertThat(merge.merge(new int[] {1, 2}, new int[] {3, 4, 4}), is(expect));
    }

    @Test
    public void whenLeftEmpty() {
        Merge merge = new Merge();
        int[] expect = {1, 2, 3, 4};
        assertThat(merge.merge(new int[] {}, new int[] {1, 2, 3, 4}), is(expect));
    }
}
