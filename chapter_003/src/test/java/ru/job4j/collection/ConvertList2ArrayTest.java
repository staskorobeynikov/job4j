package ru.job4j.collection;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class ConvertList2ArrayTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when7ElementsThen2Groups() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 2);
        int[][] expect = {{1, 2}, {3, 4}, {5, 6}, {7, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTestMainMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        ConvertList2Array.main(args);

        String expect = String.format(
                "3%s"
                        + "1 2 3 4 %s"
                        + "5 6 7 8 %s"
                        + "9 10 0 0 %s",
                LN,
                LN,
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
