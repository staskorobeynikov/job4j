package ru.job4j.jmm;

public class VisibilityOfSharedObjects {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(50);
        int order = 100;
        Thread clientOne = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.increaseBalance(order);
            System.out.println(String.format("Client One made a money transfer: %s$.", order));
            System.out.println(String.format("Account balance is: %s$", account.getBalance()));
        });
        Thread clientTwo = new Thread(() -> {
            int i = 0;
            while (account.getBalance() == 50) {
                i++;
            }
            System.out.println(String.format("Client Two balance is: %s.", account.getBalance()));
        });
        clientOne.start();
        clientTwo.start();
        clientOne.join();
        clientTwo.join();
        System.out.println(String.format("Account balance is: %s$", account.getBalance()));
    }
}
