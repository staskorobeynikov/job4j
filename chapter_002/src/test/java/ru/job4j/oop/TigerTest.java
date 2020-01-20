package ru.job4j.oop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TigerTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestClassName() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Tiger tiger = new Tiger();

        String expect = String.format(
                "Class name: Animal%s"
                        + "Class name: Predator%s"
                        + "Class name: Tiger%s",
                LN,
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenTestClassNamePredator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Tiger tiger = new Tiger("lion");

        String expect = String.format(
                "Class name: Predator%s"
                        + "Class name: Tiger%s",
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}