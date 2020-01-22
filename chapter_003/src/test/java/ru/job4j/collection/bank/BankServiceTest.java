package ru.job4j.collection.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(user));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150.0));
    }

    @Test
    public void whenAddAccountUserIsNull() {
        User user = new User("3434", "Petr Arsentev");
        User user1 = new User("5656", "Arsentev Petr");
        BankService bank = new BankService();

        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user1.getPassport(), new Account("4655", 150));

        assertNull(bank.findByRequisite("5656", "4655"));
    }

    @Test
    public void whenAddAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();

        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user.getPassport(), new Account("4655", 250));
        bank.addAccount(user.getPassport(), new Account("5546", 350));

        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150.0));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user.getPassport(), new Account("113", 50));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150);
        assertThat(bank.findByRequisite("3434", "113").getBalance(), is(200.0));
    }

    @Test
    public void transferMoneyIsTrue() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user.getPassport(), new Account("113", 50));

        boolean result = bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150);

        assertThat(result, is(true));
    }

    @Test
    public void transferMoneyIsFalseBalanceLessAmount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user.getPassport(), new Account("113", 50));

        boolean result = bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 200);

        assertThat(result, is(false));
    }

    @Test
    public void transferMoneyIsFalseDestAccountIsNull() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user.getPassport(), new Account("113", 50));

        boolean result = bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "1111", 200);

        assertThat(result, is(false));
    }

    @Test
    public void transferMoneyIsFalseSrcAccountIsNull() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user.getPassport(), new Account("113", 50));

        boolean result = bank.transferMoney(user.getPassport(), "1111", user.getPassport(), "113", 200);

        assertThat(result, is(false));
    }
}