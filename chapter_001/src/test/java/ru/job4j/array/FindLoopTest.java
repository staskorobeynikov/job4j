package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHas4ThenNot() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 8, 3, 10, 9, 13};
        int value = 4;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHas8Then4() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 2, 3, 10, 8, 13, 8, 8, 8};
        int value = 8;
        int result = find.indexOf(input, value);
        int expect = 4;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind3() {
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind10() {
        int[] input = new int[] {5, 2, 17, 2, 10, 8, 11, 30, 15};
        int value = 10;
        int start = 1;
        int finish = 6;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = 4;
        assertThat(result, is(expect));
    }
}
