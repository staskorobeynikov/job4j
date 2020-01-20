package ru.job4j.oop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HareTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTryEat() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Ball ball = new Ball();
        Hare hare = new Hare();
        hare.tryEat(ball);

        String expect = String.format("Заяц не съедает колобка%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}