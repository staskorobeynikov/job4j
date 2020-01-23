package ru.job4j.ex;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindElTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestIndexOfIsTwo() throws ElementNotFoundException {
        FindEl findEl = new FindEl();
        String[] value = new String[]{"name", "name1", "name2"};

        int result = findEl.indexOf(value, "name2");

        assertThat(result, is(2));
    }

    @Test(expected = ElementNotFoundException.class)
    public void whenTestIndexOfIsNotFound() throws ElementNotFoundException {
        FindEl findEl = new FindEl();
        String[] value = new String[]{"name", "name1", "name2"};

        int result = findEl.indexOf(value, "name3");

        assertThat(result, is(2));
    }

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        FindEl.main(args);

        String expect = String.format(
                "Index element is: 2%s",
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}