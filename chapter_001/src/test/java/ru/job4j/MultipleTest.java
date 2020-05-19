package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MultipleTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void testMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        Multiple.main(args);

        String expect = String.format(
                "1 * 2 = 2%s"
                        + "1 * 3 = 3%s"
                        + "1 * 4 = 4%s"
                        + "1 * 5 = 5%s"
                        + "1 * 6 = 6%s"
                        + "1 * 7 = 7%s"
                        + "1 * 8 = 8%s"
                        + "1 * 9 = 9%s"
                        + "1 * 10 = 10%s",
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