package ru.job4j.jmm;

public class RaceConditions {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(50);
        System.out.println(String.format("Account balance is: %s", account.getBalance()));
        Thread clientOne = new Thread(new Transaction(account), "ClientOne");
        Thread clientTwo = new Thread(new Transaction(account), "ClientTwo");
        clientOne.start();
        clientTwo.start();
        clientOne.join();
        clientTwo.join();
        System.out.println(String.format("Account balance is: %s", account.getBalance()));
    }
}
