package ru.job4j.calculator;

public class Fit {
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }

    public static void main(String[] args) {
        Fit fit = new Fit();
        double man = fit.manWeight(180);
        System.out.println("Man 180sm is " + man + " kilos");
        double woman = fit.womanWeight(170);
        System.out.println("Woman 170sm is " + woman + " kilos");
    }
}
