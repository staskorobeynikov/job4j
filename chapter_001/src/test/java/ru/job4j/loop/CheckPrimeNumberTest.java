package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CheckPrimeNumberTest {
    @Test
    public void whenTestNumber5IsTrue() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(5);
        assertThat(rsl, is(true));
    }
    @Test
    public void whenTestNumber4IsFalse() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(4);
        assertThat(rsl, is(false));
    }
    @Test
    public void whenTestNumber3IsTrue() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(3);
        assertThat(rsl, is(true));
    }
    @Test
    public void whenTestNumber1IsFalse() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(1);
        assertThat(rsl, is(false));
    }
}
