package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void distance() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance3d() {
        double expected = 10;
        Point a = new Point(0, 0, 6);
        Point b = new Point(0, 8, 0);
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        Point.main(args);

        String expect = String.format(
                "2.0%s5.0%s", LN, LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
