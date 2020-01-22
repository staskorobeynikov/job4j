package ru.job4j.ru.job4j.loop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BoardTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void paint() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Board board = new Board();
        board.paint(3, 3);

        String expect = String.format(
                "XOX%s"
                        + "OXO%s"
                        + "XOX%s",
                LN,
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}