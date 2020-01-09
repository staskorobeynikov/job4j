package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

/**
 * Interface describes the action.
 */
public interface CalcAction {

    /**
     * Name line in menu.
     *
     * @return String name action for menu.
     */
    String name();

    /**
     * Executing action.
     *
     * @param input Input stream for calculation.
     * @param calculator object class calculator.
     * @param result previous result calculate.
     * @return result action.
     */
    double execute(Input input, Calculator calculator, double result);
}
