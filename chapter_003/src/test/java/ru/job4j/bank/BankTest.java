package ru.job4j.bank;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenAddUserWithAccount() {
        Bank bank = new Bank();
        User stas = new User("Stas", "2564759");
        bank.addUser(stas);
        Account stasAccount = new Account();
        stasAccount.setValue(100);
        stasAccount.setRequisites("00001");
        bank.addAccountToUser("2564759", stasAccount);
        Account expected = bank.getUserAccounts("2564759").get(0);
        assertThat(expected, is(stasAccount));
    }
    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User stas = new User("Stas", "2564759");
        bank.addUser(stas);
        Account stasAccount = new Account();
        stasAccount.setValue(100);
        stasAccount.setRequisites("00001");
        bank.addAccountToUser("2564759", stasAccount);
        bank.deleteUser(stas);
        List<Account> expected = bank.getUserAccounts("2564759");
        assertNull(expected);
    }
    @Test
    public void whenDeleteAccount() {
        Bank bank = new Bank();
        User stas = new User("Stas", "2564759");
        bank.addUser(stas);
        Account stasAccount1 = new Account();
        stasAccount1.setValue(100);
        stasAccount1.setRequisites("00001");
        bank.addAccountToUser("2564759", stasAccount1);
        Account stasAccount2 = new Account();
        stasAccount1.setValue(100);
        stasAccount1.setRequisites("00002");
        bank.addAccountToUser("2564759", stasAccount2);
        bank.deleteAccountToUser("2564759", stasAccount2);
        boolean expected = bank.getUserAccounts("2564759").contains(stasAccount2);
        assertThat(expected, is(false));
    }
    @Test
    public void whenTransfer100ThenTrue() {
        Bank bank = new Bank();
        User stas = new User("Stas", "2564759");
        User igor = new User("Igor", "1894536");
        bank.addUser(stas);
        bank.addUser(igor);
        Account stasAccount = new Account();
        stasAccount.setValue(100);
        stasAccount.setRequisites("00001");
        Account igorAccount = new Account();
        igorAccount.setValue(100);
        igorAccount.setRequisites("00002");
        bank.addAccountToUser("2564759", stasAccount);
        bank.addAccountToUser("1894536", igorAccount);
        boolean expected = bank.transferMoney("2564759", "00001",
                "1894536", "00002", 100);
        assertThat(expected, is(true));
    }
    @Test
    public void whenTransfer100ThenFalse() {
        Bank bank = new Bank();
        User stas = new User("Stas", "2564759");
        User igor = new User("Igor", "1894536");
        bank.addUser(stas);
        bank.addUser(igor);
        Account stasAccount = new Account();
        stasAccount.setValue(100);
        stasAccount.setRequisites("00001");
        Account igorAccount = new Account();
        igorAccount.setValue(100);
        igorAccount.setRequisites("00002");
        bank.addAccountToUser("2564759", stasAccount);
        bank.addAccountToUser("1894536", igorAccount);
        boolean expected = bank.transferMoney("2564759", "00001",
                "1894536", "00002", 200);
        assertThat(expected, is(false));
    }
    @Test
    public void whenTransfer100OneUserTwoAccountsThenTrue() {
        Bank bank = new Bank();
        User stas = new User("Stas", "2564759");
        bank.addUser(stas);
        Account stasAccount1 = new Account();
        stasAccount1.setValue(100);
        stasAccount1.setRequisites("00001");
        Account stasAccount2 = new Account();
        stasAccount2.setValue(100);
        stasAccount2.setRequisites("00002");
        bank.addAccountToUser("2564759", stasAccount1);
        bank.addAccountToUser("2564759", stasAccount2);
        boolean expected = bank.transferMoney("2564759", "00001",
                "2564759", "00002", 100);
        assertThat(expected, is(true));
    }
}
