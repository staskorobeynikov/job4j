package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void rubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void rubleToDollar() {
        int in = 180;
        int expected = 3;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void euroToRubles() {
        int in = 10;
        int expected = 700;
        int out = Converter.euroToRubles(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void dollarToRubles() {
        int in = 7;
        int expected = 420;
        int out = Converter.dollarToRubles(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        Converter.main(args);

        String expect = String.format(
                "140 rubles are 2 euro. Test result : true%s"
                        + "300 rubles are 5 dollars. Test result : true%s"
                        + "10 euros are 700 rubles. Test result : true%s"
                        + "7 dollars are 420 rubles. Test result : true%s",
                LN,
                LN,
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
