/**
 * Package for calculate task.
 *
 * @author Stas Korobeynikov (stas.korobeinikov@mail.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.calculator;

public class Calculator {
    /**
     * Method add calculate Sum two numbers
     * @param first First number
     * @param second Second number
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * Method div calculate Divide two numbers
     * @param first First number
     * @param second Second number
     */
    public double div(double first, double second) {
        return first / second;
    }

    /**
     * Method multiply calculate Multiplication two numbers
     * @param first First number
     * @param second Second number
     */
    public double multiply(double first, double second) {
        return first * second;
    }

    /**
     * Method subtract calculate Substraction two numbers
     * @param first First number
     * @param second Second number
     */
    public double subtract(double first, double second) {
        return first - second;
    }
}
