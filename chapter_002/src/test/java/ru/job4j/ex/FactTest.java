package ru.job4j.ex;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {
    @Test
    public void whenNumberIs4Then24() {
        Fact fact = new Fact();
        int result = fact.calc(4);
        assertThat(result, is(24));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNumberIsMinus1ThenException() {
        Fact fact = new Fact();
        fact.calc(-1);
    }

    @Test
    public void whenNumberIs0Then1() {
        Fact fact = new Fact();
        int result = fact.calc(0);
        assertThat(result, is(1));
    }

    @Test
    public void whenTestMain() {
        String ln = System.lineSeparator();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        Fact.main(args);

        String expect = String.format(
                "Factorial 3 equal: 6%s",
                ln);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}