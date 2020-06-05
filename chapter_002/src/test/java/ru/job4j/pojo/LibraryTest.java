package ru.job4j.pojo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LibraryTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestConsoleOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Library.main(new String[0]);

        String expect = String.format(
                "Евгений Онегин - 3%s"
                        + "Китайский язык - 2%s"
                        + "Инструкция пользователя - 5%s"
                        + "Clean Code - 1%s%s"
                        + "Инструкция пользователя - 5%s"
                        + "Китайский язык - 2%s"
                        + "Евгений Онегин - 3%s"
                        + "Clean Code - 1%s%s"
                        + "Show book with name - Clean code%s"
                        + "Clean Code - 1%s",
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
                LN,
                LN
        );
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}