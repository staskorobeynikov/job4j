package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundredTwenty() {
        Factorial check = new Factorial();
        int result = check.calc(5);
        assertThat(result, is(120));
    }
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial check = new Factorial();
        int result = check.calc(0);
        assertThat(result, is(1));
    }
    @Test
    public void whenCalculateFactorialForOneThenOne() {
        Factorial check = new Factorial();
        int result = check.calc(1);
        assertThat(result, is(1));
    }
}
