package ru.job4j.srp;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MenuTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestMenuShow() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Menu menu = new Menu();
        menu.addToMenu(new AddAction());
        menu.addToMenu(new DivideAction());
        menu.addToMenu(new MultiplyAction());
        menu.addToMenu(new SubtractAction());
        menu.showMenu();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Addition%s1 . Divide%s2 . Multiply%s3 . Subtract%s",
                LN,
                LN,
                LN,
                LN)));
        System.setOut(def);
    }

}