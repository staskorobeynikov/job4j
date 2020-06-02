package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    private SqMax check = new SqMax();

    @Test
    public void whenFirstMax() {
        int result = check.max(4, 1, 2, 3);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstMax1() {
        int result = check.max(4, 1, 3, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstMax2() {
        int result = check.max(4, 2, 1, 3);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstMax3() {
        int result = check.max(4, 2, 3, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstMax4() {
        int result = check.max(4, 3, 1, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstMax5() {
        int result = check.max(4, 3, 2, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMax() {
        int result = check.max(1, 4, 2, 3);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMax1() {
        int result = check.max(1, 4, 3, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMax2() {
        int result = check.max(2, 4, 1, 3);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMax3() {
        int result = check.max(2, 4, 3, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMax4() {
        int result = check.max(3, 4, 1, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMax5() {
        int result = check.max(3, 4, 2, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdMax() {
        int result = check.max(1, 2, 4, 3);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdMax1() {
        int result = check.max(1, 3, 4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdMax2() {
        int result = check.max(2, 1, 4, 3);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdMax3() {
        int result = check.max(2, 3, 4, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdMax4() {
        int result = check.max(3, 1, 4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdMax5() {
        int result = check.max(3, 2, 4, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenForthMax() {
        int result = check.max(1, 2, 3, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenForthMax1() {
        int result = check.max(1, 3, 2, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenForthMax2() {
        int result = check.max(2, 1, 3, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenForthMax3() {
        int result = check.max(2, 3, 1, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenForthMax4() {
        int result = check.max(3, 1, 2, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenForthMax5() {
        int result = check.max(3, 2, 1, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenThird12Max() {
        int result = check.max(10, 7, 12, 1);
        assertThat(result, is(12));
    }
}
