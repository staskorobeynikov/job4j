package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrgAreaTest {
    @Test
    public void area () {
        double expected = 19.0;
        Point ap = new Point(0, 4);
        Point bp = new Point(10, 2);
        Point cp = new Point(9, 6);
        TrgArea result = new TrgArea(ap, bp, cp);
        double out = result.area();
        Assert.assertEquals(expected, out, 0.01);
    }
    @Test
    public void areaNot () {
        double expected = -1.0;
        Point ap = new Point(3, 3);
        Point bp = new Point(1, 9);
        Point cp = new Point(1, 9);
        TrgArea result = new TrgArea(ap, bp, cp);
        double out = result.area();
        Assert.assertEquals(expected, out, 0.01);
    }
    @Test
    public void areaNull () {
        double expected = -1.0;
        Point ap = new Point(2, 2);
        Point bp = new Point(5, 2);
        Point cp = new Point(8, 2);
        TrgArea result = new TrgArea(ap, bp, cp);
        double out = result.area();
        Assert.assertEquals(expected, out, 0.01);
    }
}
