package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.calculator.Calculator;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MultiplyActionTest {
    @Test
    public void whenInputTwoNumbersResultPreviousOperationIsNull() {
        MultiplyAction mult = new MultiplyAction();
        Calculator calculator = new Calculator();
        double result;
        List<String> answers = Arrays.asList("10", "15");
        Input input = new StubInput(answers);
        double resultAdd = 0;
        result = mult.execute(input, calculator, resultAdd);
        assertEquals(result, 150, 0.01);
    }

    @Test
    public void whenInputOneNumberResultPreviousOperationNotNull() {
        MultiplyAction mult = new MultiplyAction();
        Calculator calculator = new Calculator();
        double result;
        List<String> answers = Arrays.asList("y", "10");
        Input input = new StubInput(answers);
        double resultAdd = 25;
        result = mult.execute(input, calculator, resultAdd);
        assertEquals(result, 250, 0.01);
    }
}