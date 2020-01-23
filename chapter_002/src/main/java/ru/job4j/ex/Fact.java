package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        Fact fact = new Fact();
        System.out.println("Factorial 3 equal: " + fact.calc(3));
    }

    public int calc(int n) {
        int result = 1;
        if (n < 1) {
            throw new IllegalArgumentException("n should be great or equal 1");
        }
        for (int index = 1; index != n; index++) {
            result += index;
        }
        return result;
    }
}
