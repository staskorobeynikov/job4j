package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CountTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenException() {
        int rsl = Count.add(10, 2);
    }

    @Test
    public void whenStart1Finish10IsSum44() {
        int start = 2;
        int finish = 10;
        int expected = 44;
        int result = Count.add(start, finish);
        assertThat(result, is(expected));
    }
}