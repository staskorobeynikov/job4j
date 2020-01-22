package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3), is(expect));
    }

    @Test
    public void when7ElementsThen2Groups() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] expect = {{1, 2}, {3, 4}, {5, 6}, {7, 0}};
        assertThat(list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 2), is(expect));
    }
}