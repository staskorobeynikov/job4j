package ru.job4j.stragery;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PaintTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestMethodMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        Paint.main(args);

        String expect = String.format(
                "   +   %s"
                        + "  + +  %s"
                        + " +   + %s"
                        + "+++++++%s%s"
                        + "++++%s"
                        + "+  +%s"
                        + "+  +%s"
                        + "++++%s",
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