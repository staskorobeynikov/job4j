package ru.job4j.collection.bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    private final BankService bank = new BankService();

    private final User user = new User("3434", "Petr Arsentev");

    @Before
    public void setUp() {
        bank.addUser(user);
    }

    @Test
    public void addUser() {
        assertThat(bank.findByPassport("3434"), is(user));
    }

    @Test
    public void addAccount() {
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150.0));
    }

    @Test
    public void whenAddAccountUserIsNull() {
        User user1 = new User("5656", "Arsentev Petr");

        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user1.getPassport(), new Account("4655", 150));

        assertNull(bank.findByRequisite("5656", "4655"));
    }

    @Test
    public void whenAddAccount() {
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user.getPassport(), new Account("4655", 250));
        bank.addAccount(user.getPassport(), new Account("5546", 350));

        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150.0));
    }

    @Test
    public void transferMoney() {
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user.getPassport(), new Account("113", 50));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150);
        assertThat(bank.findByRequisite("3434", "113").getBalance(), is(200.0));
    }

    @Test
    public void transferMoneyIsTrue() {
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user.getPassport(), new Account("113", 50));

        boolean result = bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150);

        assertThat(result, is(true));
    }

    @Test
    public void transferMoneyIsFalseBalanceLessAmount() {
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user.getPassport(), new Account("113", 50));

        boolean result = bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 200);

        assertThat(result, is(false));
    }

    @Test
    public void transferMoneyIsFalseDestAccountIsNull() {
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user.getPassport(), new Account("113", 50));

        boolean result = bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "1111", 200);

        assertThat(result, is(false));
    }

    @Test
    public void transferMoneyIsFalseSrcAccountIsNull() {
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        bank.addAccount(user.getPassport(), new Account("113", 50));

        boolean result = bank.transferMoney(user.getPassport(), "1111", user.getPassport(), "113", 200);

        assertThat(result, is(false));
    }
}