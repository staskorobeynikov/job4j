package ru.job4j.jmm;

public class Account {
    /**
     * volatile
     */
    private int balance;

    Account(int balance) {
        this.balance = balance;
    }

    /**
     * synchronized
     */
    void reduceBalance(int amount) {
        this.balance -= amount;
    }

    void increaseBalance(int amount) {
        this.balance += amount;
    }

    int getBalance() {
        return balance;
    }
}
