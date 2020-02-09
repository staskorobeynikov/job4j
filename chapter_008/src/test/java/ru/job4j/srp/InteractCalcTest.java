package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.calculator.Calculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
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

    @Test
    public void whenTestAddActionWithReuseResultIsNullAndExitFromCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        AddAction add = new AddAction();
        Menu menu = new Menu();
        menu.addToMenu(add);
        Calculator calculator = new Calculator();
        List<String> answers = Arrays.asList("0", "0", "0", "n", "0", "10", "15", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Addition%s0.0%s" +
                        "0 . Addition%s25.0%s",
                LN,
                LN,
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestAddActionWithReuseResultIsNotNullAndExitFromCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        AddAction add = new AddAction();
        Menu menu = new Menu();
        menu.addToMenu(add);
        Calculator calculator = new Calculator();
        List<String> answers = Arrays.asList("0", "10", "15", "n", "0", "y", "20", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Addition%s25.0%s" +
                        "0 . Addition%s45.0%s",
                LN,
                LN,
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestSubtractActionAndExitFromCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        SubtractAction sub = new SubtractAction();
        Menu menu = new Menu();
        menu.addToMenu(sub);
        Calculator calculator = new Calculator();
        List<String> answers = Arrays.asList("0", "15", "10", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Subtract%s5.0%s",
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestSubtractActionWithReuseResultIsNullAndExitFromCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        SubtractAction sub = new SubtractAction();
        Menu menu = new Menu();
        menu.addToMenu(sub);
        Calculator calculator = new Calculator();
        List<String> answers = Arrays.asList("0", "0", "0", "n", "0", "15", "10", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Subtract%s0.0%s" +
                        "0 . Subtract%s5.0%s",
                LN,
                LN,
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestSubtractActionWithReuseResultIsNotNullAndExitFromCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        SubtractAction sub = new SubtractAction();
        Menu menu = new Menu();
        menu.addToMenu(sub);
        Calculator calculator = new Calculator();
        List<String> answers = Arrays.asList("0", "25", "10", "n", "0", "y", "10", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Subtract%s15.0%s" +
                        "0 . Subtract%s5.0%s",
                LN,
                LN,
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestMultiplyActionAndExitFromCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        MultiplyAction multi = new MultiplyAction();
        Menu menu = new Menu();
        menu.addToMenu(multi);
        Calculator calculator = new Calculator();
        List<String> answers = Arrays.asList("0", "3", "5", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Multiply%s15.0%s",
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestMultiplyActionWithReuseResultIsNullAndExitFromCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        MultiplyAction multi = new MultiplyAction();
        Menu menu = new Menu();
        menu.addToMenu(multi);
        Calculator calculator = new Calculator();
        List<String> answers = Arrays.asList("0", "0", "0", "n", "0", "3", "5", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Multiply%s0.0%s" +
                        "0 . Multiply%s15.0%s",
                LN,
                LN,
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestMultiplyActionWithReuseResultIsNotNullAndExitFromCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        MultiplyAction multi = new MultiplyAction();
        Menu menu = new Menu();
        menu.addToMenu(multi);
        Calculator calculator = new Calculator();
        List<String> answers = Arrays.asList("0", "3", "5", "n", "0", "y", "10", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Multiply%s15.0%s" +
                        "0 . Multiply%s150.0%s",
                LN,
                LN,
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestDivideActionAndExitFromCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        DivideAction div = new DivideAction();
        Menu menu = new Menu();
        menu.addToMenu(div);
        Calculator calculator = new Calculator();
        List<String> answers = Arrays.asList("0", "6", "3", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Divide%s2.0%s",
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestDivideActionWithReuseResultIsNullAndExitFromCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        DivideAction div = new DivideAction();
        Menu menu = new Menu();
        menu.addToMenu(div);
        Calculator calculator = new Calculator();
        List<String> answers = Arrays.asList("0", "0", "1", "n", "0", "6", "3", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Divide%s0.0%s" +
                        "0 . Divide%s2.0%s",
                LN,
                LN,
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestDivideActionWithReuseResultIsNotNullAndExitFromCalculator() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        DivideAction div = new DivideAction();
        Menu menu = new Menu();
        menu.addToMenu(div);
        Calculator calculator = new Calculator();
        List<String> answers = Arrays.asList("0", "15", "3", "n", "0", "y", "5", "y");
        StubInput stubInput = new StubInput(answers);
        new InteractCalc(stubInput, calculator, menu).init();

        assertThat(new String(out.toByteArray()), is(String.format(
                "0 . Divide%s5.0%s" +
                        "0 . Divide%s1.0%s",
                LN,
                LN,
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestMethodAskStr() {
        List<String> answers = Collections.singletonList("Please, enter text!");
        StubInput stubInput = new StubInput(answers);
        ValidateInput validateInput = new ValidateInput(stubInput);

        String result = validateInput.askStr("");

        assertThat(result, is("Please, enter text!"));
    }

    @Test(expected = IllegalStateException.class)
    public void whenTestMethodAskIntStubInput() {
        List<String> answers = Collections.singletonList("10");
        StubInput stubInput = new StubInput(answers);
        stubInput.askInt("Please, enter data!", 2);
    }
}