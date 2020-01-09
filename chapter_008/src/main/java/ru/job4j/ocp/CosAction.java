package ru.job4j.ocp;

import ru.job4j.calculator.Calculator;
import ru.job4j.srp.*;

/**
 * Class action cosine.
 */
public class CosAction implements CalcAction {
    /**
     * Method determines action name.
     *
     * @return name.
     */
    @Override
    public String name() {
        return "Cosine";
    }

    /**
     * Cosine calculation.
     *
     * @param input Input stream for calculation.
     * @param calculator object class calculator.
     * @param result previous result calculate.
     * @return result of cosine calculation.
     */
    @Override
    public double execute(Input input, Calculator calculator, double result) {
        double resultCalculate;
        EngineeringCalculator engCalc = (EngineeringCalculator) calculator;
        if (result != 0 && "y".equals(input.askStr("Reuse result?(y or any key): "))) {
            resultCalculate = engCalc.cosine(result);
        } else {
            double first = input.askDouble("Enter first number: ");
            resultCalculate = engCalc.cosine(first);
        }
        return resultCalculate;
    }
}
