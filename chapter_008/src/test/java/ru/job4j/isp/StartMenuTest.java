package ru.job4j.isp;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartMenuTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        StartMenu.main(args);

        assertThat(new String(out.toByteArray()), is(String.format(
                "Task 1%s----Task 1.1%s--------Task 1.1.1%s--------Task 1.1.2%s----Task 1.2%s",
                LN,
                LN,
                LN,
                LN,
                LN)));
        System.setOut(def);
    }
}