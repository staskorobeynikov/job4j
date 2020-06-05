package ru.job4j.condition;

public class SqArea {
    public double square(int p, int k) {
        double height = p / (2 * (k + 1));
        double length = k * height;
        return height * length;
    }
    public static void main(String[] args) {
        SqArea sqArea = new SqArea();
        double result1 = sqArea.square(4, 1);
        System.out.println("p = 4, k = 1, S = 1, real = " + result1);
        double result2 = sqArea.square(6, 2);
        System.out.println("p = 6, k = 2, S = 2, real = " + result2);
    }
}
