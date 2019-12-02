package ru.job4j.condition;

public class TrgArea {
    public static double area(double a, double b, double c) {
        double halfPer = (a + b + c) / 2;
        double area = Math.sqrt(halfPer * (halfPer - a) * (halfPer - b) * (halfPer - c));
        return area;
    }
    public static void main(String[] args) {
        double result = TrgArea.area(2, 2, 2);
        System.out.println("area (2, 2, 2) = " + result);
    }
}
