package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

/**
 * Class action addition.
 */
public class AddAction implements CalcAction {
    /**
     * Method determines action name.
     *
     * @return name.
     */
    @Override
    public String name() {
        return "Addition";
    }

    /**
     * Addition operation.
     *
     * @param input Input stream for calculation.
     * @param calculator object class calculator.
     * @param result previous result calculate.
     * @return result of addition.
     */
    @Override
    public double execute(Input input, Calculator calculator, double result) {
        double resultCalculate;
        if (result != 0 && "y".equals(input.askStr("Reuse result?(y or any key): "))) {
            double second = input.askDouble("Enter second number: ");
            resultCalculate = calculator.add(result, second);
        } else {
            double first = input.askDouble("Enter first number: ");
            double second = input.askDouble("Enter second number: ");
            resultCalculate = calculator.add(first, second);
        }
        return resultCalculate;
    }
}
