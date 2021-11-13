package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRubles(int value) {
        return value * 70;
    }

    public static int dollarToRubles(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int inEur = 140;
        int expectedEur = 2;
        int outEur = rubleToEuro(inEur);
        boolean passedEur = expectedEur == outEur;
        System.out.println("140 rubles are 2 euro. Test result : " + passedEur);
        int inDol = 300;
        int expectedDol = 5;
        int outDol = rubleToDollar(300);
        boolean passedDol = expectedDol == outDol;
        System.out.println("300 rubles are 5 dollars. Test result : " + passedDol);
        int inEurRub = 10;
        int expectedEurRub = 700;
        int outEurRub = euroToRubles(inEurRub);
        boolean passedEurRub = expectedEurRub == outEurRub;
        System.out.println("10 euros are 700 rubles. Test result : " + passedEurRub);
        int inDolRub = 7;
        int expectedDolRub = 420;
        int outDolRub = dollarToRubles(inDolRub);
        boolean passedDolRub = expectedDolRub == outDolRub;
        System.out.println("7 dollars are 420 rubles. Test result : " + passedDolRub);
    }
}
