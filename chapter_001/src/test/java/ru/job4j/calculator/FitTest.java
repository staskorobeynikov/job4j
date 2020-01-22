package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void manWeight() {
        Fit fit = new Fit();
        double in = 180;
        double expected = 92;
        double out = fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void womanWeight() {
        Fit fit = new Fit();
        double in = 170;
        double expected = 69;
        double out = fit.womanWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }
}
