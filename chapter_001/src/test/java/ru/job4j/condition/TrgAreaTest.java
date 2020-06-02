package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrgAreaTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void area() {
        double expected = 19.0;
        Point ap = new Point(0, 4);
        Point bp = new Point(10, 2);
        Point cp = new Point(9, 6);
        TrgArea result = new TrgArea(ap, bp, cp);
        double out = result.area();
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenTriangleNotExistConditionThirdInAction() {
        double expected = -1.0;
        Point ap = new Point(0, 4);
        Point bp = new Point(0, 5);
        Point cp = new Point(0, 9);
        TrgArea result = new TrgArea(ap, bp, cp);
        double out = result.area();
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenTriangleNotExistConditionSecondInAction() {
        double expected = -1.0;
        Point ap = new Point(0, 9);
        Point bp = new Point(0, 4);
        Point cp = new Point(0, 5);
        TrgArea result = new TrgArea(ap, bp, cp);
        double out = result.area();
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenTriangleNotExistConditionThirdInAction1() {
        double expected = -1.0;
        Point ap = new Point(0, 5);
        Point bp = new Point(0, 4);
        Point cp = new Point(0, 9);
        TrgArea result = new TrgArea(ap, bp, cp);
        double out = result.area();
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        TrgArea.main(args);

        String expect = String.format(
                "19.000000000000007%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
