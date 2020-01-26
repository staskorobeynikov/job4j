package ru.job4j.isp;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartMenuTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        StartMenu.main(args);

        assertThat(new String(out.toByteArray()), is(String.format(
                "Task 1%s----Task 1.1%s--------Task 1.1.1%s--------Task 1.1.2%s----Task 1.2%s",
                LN,
                LN,
                LN,
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestMethodExecute() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Menu menu = new SimpleMenu();
        Item item2 = new SimpleItem("Task 1.1.1");
        Item item3 = new SimpleItem("Task 1.1.2");
        List<Item> list = Arrays.asList(item2, item3);
        menu.addItems(list);
        menu.execute(new StubInput());

        assertThat(new String(out.toByteArray()), is(String.format(
                "Execute some action!!!%sExecute some action!!!%s",
                LN,
                LN)));
        System.setOut(def);
    }
}