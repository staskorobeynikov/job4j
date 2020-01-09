package ru.job4j.ocp;

import ru.job4j.calculator.Calculator;

/**
 * Engineering calculator.
 */
public class EngineeringCalculator extends Calculator {
    /**
     * Cosine calculation.
     *
     * @param first double number.
     * @return result cosine angle in radians.
     */
    public double cosine(double first) {
        return Math.cos(Math.toRadians(first));
    }

    /**
     * Sinus calculation.
     *
     * @param first double number.
     * @return result sinus angle in radians.
     */
    public double sinus(double first) {
        return Math.sin(Math.toRadians(first));
    }

    /**
     * Tangent calculation.
     *
     * @param first double number.
     * @return result tangent angle in radians.
     */
    public double tangent(double first) {
        return Math.tan(Math.toRadians(first));
    }
}
