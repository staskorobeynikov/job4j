package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MainTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void testMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        Main.main(args);

        String expect = String.format(
                "Hello job4j!%s",
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}