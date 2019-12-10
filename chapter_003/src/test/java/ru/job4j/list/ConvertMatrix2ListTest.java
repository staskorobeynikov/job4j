package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
    @Test
    public void when7on4ArrayThenList11() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 5, 20, 4, 3, 7},
                {3, 4, 11, 8}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 5, 20, 4, 3, 7, 3, 4, 11, 8
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
    @Test
    public void when0on4ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {},
                {3, 4, 11, 8}
        };
        List<Integer> expect = Arrays.asList(
                3, 4, 11, 8
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}
