package ru.job4j.loop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SlashTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestDraw() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Slash slash = new Slash();
        slash.draw(5);

        String expect = String.format(
                "0   0%s"
                        + " 0 0 %s"
                        + "  0  %s"
                        + " 0 0 %s"
                        + "0   0%s%s",
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