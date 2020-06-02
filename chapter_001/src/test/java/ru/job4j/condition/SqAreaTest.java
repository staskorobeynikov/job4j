package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqAreaTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void square() {
        SqArea sqArea = new SqArea();
        double expected = 2;
        double out = sqArea.square(6, 2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        SqArea.main(args);

        String expect = String.format(
                "p = 4, k = 1, S = 1, real = 1.0%s"
                        + "p = 6, k = 2, S = 2, real = 2.0%s",
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
