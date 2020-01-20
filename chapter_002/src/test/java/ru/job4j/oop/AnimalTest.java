package ru.job4j.oop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnimalTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestClassName() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Animal animal = new Animal();

        String expect = String.format("Class name: Animal%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Animal.main();

        String expect = String.format(
                "Class name: Animal%s%s" +
                        "Class name: Predator%s" +
                        "Class name: Animal%s" +
                        "Class name: Predator%s%s" +
                        "Class name: Predator%s" +
                        "Class name: Tiger%s" +
                        "Class name: Animal%s" +
                        "Class name: Predator%s" +
                        "Class name: Tiger%s",
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

}