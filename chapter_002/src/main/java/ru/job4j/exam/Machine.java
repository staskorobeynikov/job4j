package ru.job4j.exam;

import java.util.Arrays;

class Machine {
    private static final int[] COINS = {10, 5, 2, 1};

    int[] change(int money, int price) {
        int[] result = new int[100];
        int size = 0;
        if (money > price) {
            int balance = money - price;
            for (Integer integer : COINS) {
                while (balance - integer >= 0) {
                    result[size] = integer;
                    balance -= integer;
                    size++;
                }
            }
        }
        return Arrays.copyOf(result, size);
    }
}
