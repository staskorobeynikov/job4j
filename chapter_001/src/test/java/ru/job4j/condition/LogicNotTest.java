package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicNotTest {
    @Test
    public void when() {
        LogicNot log = new LogicNot();
        boolean b = log.notEvenAndPositive(-2);
        assertThat(b, is(false));
    }

    @Test
    public void when1() {
        LogicNot log = new LogicNot();
        boolean b = log.evenOrNotPositive(-2);
        assertThat(b, is(true));
    }
}