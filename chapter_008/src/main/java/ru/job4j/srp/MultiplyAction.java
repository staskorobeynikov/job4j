package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

/**
 * Class action multiplication.
 */
public class MultiplyAction implements CalcAction {
    /**
     * Method determines action name.
     *
     * @return name
     */
    @Override
    public String name() {
        return "Multiply";
    }

    /**
     * Multiplication operation.
     *
     * @param input Input stream for calculation.
     * @param calculator object class calculator.
     * @param result previous result calculate.
     * @return result of multiplication.
     */
    @Override
    public double execute(Input input, Calculator calculator, double result) {
        double resultCalculate;
        if (result != 0 && "y".equals(input.askStr("Reuse result?(y or any key): "))) {
            double second = input.askDouble("Enter second number: ");
            resultCalculate = calculator.multiply(result, second);
        } else {
            double first = input.askDouble("Enter first number: ");
            double second = input.askDouble("Enter second number: ");
            resultCalculate = calculator.multiply(first, second);
        }
        return resultCalculate;
    }
}
