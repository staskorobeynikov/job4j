package ru.job4j.jmm;

public class Transaction implements Runnable {
    private Account account;

    public Transaction(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        int countTransaction = 0;
        while (account.getBalance() > 0) {
            try {
                Thread.sleep(250);
                account.reduceBalance(1);
                countTransaction++;
                System.out.println(String.format("Account balance is: %s", account.getBalance()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format(
                "%s count transaction = %s",
                Thread.currentThread().getName(),
                countTransaction)
        );
    }
}
