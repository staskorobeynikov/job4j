package ru.job4j.tictactoegame;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void whenAskIntIsExceptionNumberFormat() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        ValidateInput validateInput = new ValidateInput(new StubInput(Arrays.asList("invalid", "1")));
        validateInput.askInt("ask", 5);

        assertThat(new String(out.toByteArray()), is(String.format("Please enter validate data again.%s", LN)));
        System.setOut(def);
    }

    @Test
    public void whenNumberIsGreatMaxValue() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        ValidateInput validateInput = new ValidateInput(new StubInput(Arrays.asList("7", "1")));
        validateInput.askInt("ask", 3);

        assertThat(new String(out.toByteArray()), is(String.format("Please enter number between 1 and 3.%s", LN)));
        System.setOut(def);
    }
}