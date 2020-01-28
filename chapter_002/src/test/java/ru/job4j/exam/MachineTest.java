package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MachineTest {
    @Test
    public void whenEquals() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] rsl = machine.change(100, 100);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when50by35is15() {
        Machine machine = new Machine();
        int[] expected = {10, 5};
        int[] rsl = machine.change(50, 35);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when50by32Is18() {
        Machine machine = new Machine();
        int[] expected = {10, 5, 2, 1};
        int[] rsl = machine.change(50, 32);
        assertThat(rsl, is(expected));
    }
}