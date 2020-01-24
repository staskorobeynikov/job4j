package ru.job4j.srp;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenStringIsInvalidData() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        ValidateInput validateInput = new ValidateInput(new StubInput(Arrays.asList("invalid", "0")));
        validateInput.askInt("ask", 5);

        assertThat(new String(out.toByteArray()), is(String.format("Please enter validate data again.%s", LN)));
        System.setOut(def);
    }

    @Test
    public void whenNumberIsGreatMaxValue() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        ValidateInput validateInput = new ValidateInput(new StubInput(Arrays.asList("7", "0")));
        validateInput.askInt("ask", 3);

        assertThat(new String(out.toByteArray()), is(String.format("Please enter number between 0 and 2%s", LN)));
        System.setOut(def);
    }

    @Test
    public void whenStringIsInvalidData2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        ValidateInput validateInput = new ValidateInput(new StubInput(Arrays.asList("invalid", "0")));
        validateInput.askDouble("ask");

        assertThat(new String(out.toByteArray()), is(String.format("Please enter validate data again.%s", LN)));
        System.setOut(def);
    }

}