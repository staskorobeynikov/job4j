package ru.job4j.poly;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BusTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenDrive() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Bus bus = new Bus();
        bus.drive();

        String expect = String.format("Автобус может ехать%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenAmountPassengers() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Bus bus = new Bus();
        bus.amountPassengers(10);

        String expect = String.format("В автобусе есть: 10 пассажиров%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenFillCar() {
        Bus bus = new Bus();

        int result = bus.fillCar(10);

        assertThat(result, is(440));
    }

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Bus.main(new String[0]);

        String expect = String.format(
                "Автобус может ехать%s"
                        + "В автобусе есть: 10 пассажиров%s"
                        + "Для заправки автобуса необходимо 2200 рублей%s",
                LN,
                LN,
                LN
        );
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);

    }
}