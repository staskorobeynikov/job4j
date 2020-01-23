package ru.job4j.ex;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenCalcTest() {
        Fact fact = new Fact();

        int result = fact.calc(4);

        assertThat(result, is(7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalcTestException() {
        Fact fact = new Fact();

        int result = fact.calc(0);

        assertThat(result, is(7));
    }

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        Fact.main(args);

        String expect = String.format(
                "Factorial 3 equal: 4%s",
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}