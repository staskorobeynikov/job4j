package ru.job4j.pojo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CollegeTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestConsoleOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        College.main(new String[0]);

        String expect = String.format("Коробейников Стас Евгеньевич учится в группе Стажер%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}