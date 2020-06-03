package ru.job4j.collection;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UsageMapTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void whenTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        UsageMap.main(args);

        String expect = String.format(
                "parsentev@yandex.ru = Petr Arsentev Sergeevich%s"
                        + "parsentev@yandex.ru = Petr Arsentev Sergeevich%s",
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}