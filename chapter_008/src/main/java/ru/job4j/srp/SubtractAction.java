package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

/**
 * Class action subtraction.
 */
public class SubtractAction implements CalcAction {
    /**
     * Method determines action name.
     *
     * @return name
     */
    @Override
    public String name() {
        return "Subtract";
    }

    /**
     * Subtraction operation.
     *
     * @param input Input stream for calculation.
     * @param calculator object class calculator.
     * @param result previous result calculate.
     * @return result of Subtraction.
     */
    @Override
    public double execute(Input input, Calculator calculator, double result) {
        double resultCalculate;
        if (result != 0 && "y".equals(input.askStr("Reuse result?(y or any key): "))) {
            double second = input.askDouble("Enter second number: ");
            resultCalculate = calculator.subtract(result, second);
        } else {
            double first = input.askDouble("Enter first number: ");
            double second = input.askDouble("Enter second number: ");
            resultCalculate = calculator.subtract(first, second);
        }
        return resultCalculate;
    }
}
