package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        Fact fact = new Fact();
        System.out.println("Factorial 3 equal: " + fact.calc(3));
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be great or equal 0");
        }
        int result = 1;
        for (int index = 2; index <= n; index++) {
            result *= index;
        }
        return result;
    }
}
