package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int salary, double percent) {
        int year = 0;
        while (amount > 0) {
            amount = (int) (amount * (1 + percent / 100) - salary);
            year++;
        }
        return year;
    }
}
