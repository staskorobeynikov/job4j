package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentInfoTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void testMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        StudentInfo.main(args);

        String expect = String.format(
                "My name is Stas Korobeynikov%s"
                        + "I born 17.11.1988%s",
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}