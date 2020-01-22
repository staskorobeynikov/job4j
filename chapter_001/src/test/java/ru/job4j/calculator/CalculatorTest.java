package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void add() {
        Calculator calculator = new Calculator();

        double result = calculator.add(10, 15);

        assertThat(result, is(25.0));
    }

    @Test
    public void div() {
        Calculator calculator = new Calculator();

        double result = calculator.div(15, 3);

        assertThat(result, is(5.0));
    }

    @Test
    public void multiply() {
        Calculator calculator = new Calculator();

        double result = calculator.multiply(15, 3);

        assertThat(result, is(45.0));
    }

    @Test
    public void subtract() {
        Calculator calculator = new Calculator();

        double result = calculator.subtract(15, 3);

        assertThat(result, is(12.0));
    }
}