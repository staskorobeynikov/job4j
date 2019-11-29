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
    public void whenArrayHas10Then3() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 8, 3, 10, 9, 13};
        int value = 10;
        int result = find.indexOf(input, value);
        int expect = 3;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayHas8Then4() {
        FindLoop find = new FindLoop();
        // в массиве передаем значения где искомое значени
        // содержится несколько раз. Результатом будет
        // первое встречаемое значение
        int[] input = new int[] {5, 2, 3, 10, 8, 13, 8, 8, 8};
        int value = 8;
        int result = find.indexOf(input, value);
        int expect = 4;
        assertThat(result, is(expect));
    }
}
