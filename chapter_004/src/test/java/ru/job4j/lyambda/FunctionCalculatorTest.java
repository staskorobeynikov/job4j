package ru.job4j.lyambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FunctionCalculatorTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticDataResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 5, x -> x * x + 5);
        List<Double> expected = Arrays.asList(6D, 9D, 14D, 21D, 30D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialDataResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 3, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2D, 4D, 8D);
        assertThat(result, is(expected));
    }
}
