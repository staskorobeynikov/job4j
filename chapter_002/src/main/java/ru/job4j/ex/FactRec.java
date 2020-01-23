package ru.job4j.ex;

public class FactRec {
    public int calc(int n) {
        int result;
        if (n == 1) {
            result = 1;
        } else {
            result = calc(n - 1) * n;
        }
        return result;
    }

    public static void main(String[] args) {
        FactRec factRec = new FactRec();
        int n = 4;
        int rsl = factRec.calc(n);
        System.out.println(String.format("Factorial number %s is %s.", n, rsl));
    }
}
