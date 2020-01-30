package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FitTest {
    private static final String LN = System.lineSeparator();

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

    @Test
    public void whenTestMethodMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        Fit.main(args);

        String expect = String.format(
                "Man 180sm is 92.0 kilos%s"
                        + "Woman 170sm is 69.0 kilos%s",
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
