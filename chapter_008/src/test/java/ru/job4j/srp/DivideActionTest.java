package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.calculator.Calculator;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DivideActionTest {

    @Test
    public void whenInputTwoNumbersResultPreviousOperationIsNull() {
        DivideAction div = new DivideAction();
        Calculator calculator = new Calculator();
        double result;
        List<String> answers = Arrays.asList("10", "15");
        Input input = new StubInput(answers);
        double resultDiv = 0;
        result = div.execute(input, calculator, resultDiv);
        assertEquals(result, 0.66, 0.01);
    }

    @Test
    public void whenInputOneNumberResultPreviousOperationNotNull() {
        DivideAction div = new DivideAction();
        Calculator calculator = new Calculator();
        double result;
        List<String> answers = Arrays.asList("y", "10");
        Input input = new StubInput(answers);
        double resultAdd = 25;
        result = div.execute(input, calculator, resultAdd);
        assertEquals(result, 2.5, 0.01);
    }
}