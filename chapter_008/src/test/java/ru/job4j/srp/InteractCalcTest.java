package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.calculator.Calculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class InteractCalcTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestAddActionAndExitFromCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        AddAction add = new AddAction();
        Menu menu = new Menu();
        menu.addToMenu(add);
        Calculator calculator = new Calculator();
        List<String> answers = Arrays.asList("0", "10", "15", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Addition%s25.0%s",
                LN,
                LN)));
        System.setOut(def);
    }
}