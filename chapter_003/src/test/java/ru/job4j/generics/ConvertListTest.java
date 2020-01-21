package ru.job4j.generics;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenLengthFirstGreaterSecond() {
        List<int[]> list = List.of(
                new int[]{1, 2, 3, 4},
                new int[]{5, 6}
        );
        List<Integer> result = ConvertList.convert(list);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }

    @Test
    public void whenLengthSecondGreaterFirst() {
        List<int[]> list = List.of(
                new int[]{1, 2},
                new int[]{3, 4, 5, 6}
        );
        List<Integer> result = ConvertList.convert(list);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }

    @Test
    public void whenThreeArray() {
        List<int[]> list = List.of(
                new int[]{1, 2},
                new int[]{3, 4, 5, 6},
                new int[]{7, 8, 9}
        );
        List<Integer> result = ConvertList.convert(list);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result, is(expect));
    }

    @Test
    public void whenTestMainMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        ConvertList.main(args);

        String expect = String.format(
                "[1, 2, 3, 4, 5, 6]%s",
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
