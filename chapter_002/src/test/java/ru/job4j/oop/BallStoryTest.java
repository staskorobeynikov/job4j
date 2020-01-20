package ru.job4j.oop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BallStoryTest {

    private static final String LN = System.lineSeparator();
    @Test
    public void whenTestMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        BallStory.main();

        String expect = String.format(
                "Заяц не съедает колобка%s"
                        + "Волк не съедает колобка%s"
                        + "Лиса съедает колобка%s"
                        + "Колобок съеден лисой%s",
                LN,
                LN,
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

}