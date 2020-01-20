package ru.job4j.oop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CatTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestThreeMethodsClassCat() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Cat cat = new Cat();
        cat.giveNick("gav");
        cat.eat("meat");
        cat.show();

        String expect = String.format(
                "Cat's name is gav%s" +
                        "He eats meat%s",
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);

    }
}