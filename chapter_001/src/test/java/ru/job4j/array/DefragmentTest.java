package ru.job4j.array;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DefragmentTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void notFirstNull() {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        Defragment defragment = new Defragment();
        String[] compressed = defragment.compress(input);
        String[] expected = {"I", "wanna", "be", "compressed", null, null, null};
        assertThat(compressed, is(expected));
    }

    @Test
    public void firstNull() {
        String[] input = {null, "I", "wanna", null, "be", null, "compressed"};
        Defragment defragment = new Defragment();
        String[] compressed = defragment.compress(input);
        String[] expected = {"I", "wanna", "be", "compressed", null, null, null};
        assertThat(compressed, is(expected));
    }
    @Test
    public void firstNullAnd() {
        String[] input = {null, "I", null, "wanna", null, null, "be",
                null, null, "Java", null, "developer"};
        Defragment defragment = new Defragment();
        String[] compressed = defragment.compress(input);
        String[] expected = {"I", "wanna", "be", "Java", "developer",
                null, null, null, null, null, null, null};
        assertThat(compressed, is(expected));
    }

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        Defragment.main(args);

        String expect = String.format(
                "I wanna be compressed null null null %s"
                        + "I wanna be compressed null null null ",
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
