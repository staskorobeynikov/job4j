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
        List<Double> result = function.diapason(5, 8, (x) -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadratDataResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 5, (x) -> x * x + 5);
        List<Double> expected = Arrays.asList(6D, 9D, 14D, 21D, 30D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLogarithmDataResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 3, (x) -> 5 * Math.log(x) + 5);
        assertEquals(result.get(0), 5D, 0.01);
        assertEquals(result.get(1), 8.46D, 0.01);
        assertEquals(result.get(2), 10.49D, 0.01);
    }
}
