package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MinTest {

    @Test
    public void whenFirstMin() {
        Min min = new Min();
        assertThat(
                min.findMin(
                        new int[] {0, 5, 10}
                ),
                is(0)
        );
    }

    @Test
    public void whenLastMin() {
        Min min = new Min();
        assertThat(
                min.findMin(
                        new int[] {10, 5, 3}
                ),
                is(3)
        );
    }

    @Test
    public void whenMiddleMin() {
        Min min = new Min();
        assertThat(
                min.findMin(
                        new int[] {10, 2, 5}
                ),
                is(2)
        );
    }
}
