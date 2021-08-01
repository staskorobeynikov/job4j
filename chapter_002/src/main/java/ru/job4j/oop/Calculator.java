package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int number) {
        return sum(number) + multiply(number) + minus(number) + divide(number);
    }

    public static void main(String[] args) {
        int number = 30;
        int result = sum(number);
        System.out.println("Результат: " + result);
        System.out.println();

        Calculator calculator = new Calculator();
        result = calculator.multiply(number);
        System.out.println("Результат: " + result);
        System.out.println();

        result = minus(number);
        System.out.println("Результат: " + result);
        System.out.println();

        result = calculator.divide(number);
        System.out.println("Результат: " + result);
        System.out.println();

        result = calculator.sumAllOperation(number);
        System.out.println("Результат: " + result);
        System.out.println();
    }
}
