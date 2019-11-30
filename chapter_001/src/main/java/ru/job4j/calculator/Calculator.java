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
     * Method div calculate Divide two numbers
     * Method multiply calculate Multiplication two numbers
     * Method subtract calculate Substraction two numbers
     * @param first First number
     * @param second Second number
     */
    public static void add(double first, double second){
        double result = first + second;
        System.out.println(first + " + " + second + " = " + result);
    }
    public static void div(double first, double second){
        double result = first/second;
        System.out.println(first + " / " + second + " = " + result);
    }
    public static void multiply(double first, double second){
        double result = first*second;
        System.out.println(first + " * " + second + " = " + result);
    }
    public static void subtract(double first, double second){
        double result = first - second;
        System.out.println(first + " - " + second + " = " + result);
    }

    /**
     * Main. Method with parameters.
     * @param args
     */
    public static void main (String[] args){
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtract(10, 5);
    }
}
