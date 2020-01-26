package ru.job4j.ocp;

import org.junit.Test;
import ru.job4j.srp.AddAction;
import ru.job4j.srp.Menu;
import ru.job4j.srp.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class InteractEngineerCalcTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestAddActionAndExitFromEngineerCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        AddAction add = new AddAction();
        Menu menu = new Menu();
        menu.addToMenu(add);
        EngineeringCalculator calculator = new EngineeringCalculator();
        List<String> answers = Arrays.asList("0", "10", "15", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractEngineerCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Addition%s25.0%s",
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestAddActionReuseResultAndExitFromEngineerCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        AddAction add = new AddAction();
        Menu menu = new Menu();
        menu.addToMenu(add);
        EngineeringCalculator calculator = new EngineeringCalculator();
        List<String> answers = Arrays.asList("0", "10", "15", "n", "0", "y", "10", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractEngineerCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Addition%s25.0%s0 . Addition%s35.0%s",
                LN,
                LN,
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestCosineActionAndExitFromEngineerCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        CosAction cos = new CosAction();
        Menu menu = new Menu();
        menu.addToMenu(cos);
        EngineeringCalculator calculator = new EngineeringCalculator();
        List<String> answers = Arrays.asList("0", "10", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractEngineerCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Cosine%s0.984807753012208%s",
                LN,
                LN)));
        System.setOut(def);
    }
}