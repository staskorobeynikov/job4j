package ru.job4j.oop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BatteryTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenGetLoadBattery() {
        Battery first = new Battery(30);

        int result = first.getLoad();

        assertThat(result, is(30));
    }

    @Test
    public void whenExchangeFirstBattery() {
        Battery first = new Battery(30);
        Battery second = new Battery(20);
        first.exchange(second);

        int result = first.getLoad();

        assertThat(result, is(50));
    }

    @Test
    public void whenExchangeFirstBatteryGetLoadSecondBattery() {
        Battery first = new Battery(30);
        Battery second = new Battery(20);
        first.exchange(second);

        int result = second.getLoad();

        assertThat(result, is(0));
    }

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Battery.main();

        String expect = String.format(
                "first : 30. second : 20%s" +
                        "first : 0. second : 50%s",
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}