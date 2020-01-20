package ru.job4j.oop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JarTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenGetValue() {
        Jar jar = new Jar(10);

        int result = jar.getValue();

        assertThat(result, is(10));
    }

    @Test
    public void whenPourGetValueFirstJar() {
        Jar first = new Jar(10);
        Jar second = new Jar(5);
        first.pour(second);

        int result = first.getValue();

        assertThat(result, is(15));
    }

    @Test
    public void whenPourGetValueSecondJar() {
        Jar first = new Jar(10);
        Jar second = new Jar(5);
        first.pour(second);

        int result = second.getValue();

        assertThat(result, is(0));
    }

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Jar.main();

        String expect = String.format(
                "first : 10. second : 5%s"
                        + "first : 15. second : 0%s",
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}