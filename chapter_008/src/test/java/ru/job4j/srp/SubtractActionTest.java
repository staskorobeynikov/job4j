package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.calculator.Calculator;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SubtractActionTest {
    @Test
    public void whenInputTwoNumbersResultPreviousOperationIsNull() {
        SubtractAction subs = new SubtractAction();
        Calculator calculator = new Calculator();
        double result;
        List<String> answers = Arrays.asList("10", "15");
        Input input = new StubInput(answers);
        double resultAdd = 0;
        result = subs.execute(input, calculator, resultAdd);
        assertEquals(result, -5, 0.01);
    }

    @Test
    public void whenInputOneNumberResultPreviousOperationNotNull() {
        SubtractAction subs = new SubtractAction();
        Calculator calculator = new Calculator();
        double result;
        List<String> answers = Arrays.asList("y", "10");
        Input input = new StubInput(answers);
        double resultAdd = 25;
        result = subs.execute(input, calculator, resultAdd);
        assertEquals(result, 15, 0.01);
    }
}