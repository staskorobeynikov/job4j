package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DivideBySixTest {
    @Test
    public void whenNumberDivideBy6() {
        String expected = "Исходное число делится на 6.";
        assertThat(DivideBySix.checkNumber(24), is(expected));
    }

    @Test
    public void whenNumberDivideBy3AndNotEven() {
        String expected = "Исходное число делится на 3, но не является четным.";
        assertThat(DivideBySix.checkNumber(9), is(expected));
    }

    @Test
    public void whenNumberNoDivideBy3AndEven() {
        String expected = "Исходное число не делится на 3, но является четным.";
        assertThat(DivideBySix.checkNumber(14), is(expected));
    }

    @Test
    public void whenNumberNoDivideBy3AndNotEven() {
        String expected = "Исходное число не делится на 3 и не является четным.";
        assertThat(DivideBySix.checkNumber(25), is(expected));
    }
}