package ru.job4j.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {

    private final Bank bank = new Bank();

    private final Account stasAccount = new Account();

    private final User stas = new User("Stas", "2564759");

    @Before
    public void setUp() {
        bank.addUser(stas);
        stasAccount.setValue(100);
        stasAccount.setRequisites("00001");
    }

    @Test
    public void whenAddUserWithAccount() {
        bank.addAccountToUser("2564759", stasAccount);
        Account expected = bank.getUserAccounts("2564759").get(0);
        assertThat(expected, is(stasAccount));
    }

    @Test
    public void whenAddUserAndAccountNotAdd() {
        bank.addUser(stas);
        bank.addAccountToUser("1111111", stasAccount);
        List<Account> expected = bank.getUserAccounts("2564759");
        assertThat(expected.size(), is(0));
    }

    @Test
    public void whenDeleteUser() {
        bank.addAccountToUser("2564759", stasAccount);
        bank.deleteUser(stas);
        List<Account> expected = bank.getUserAccounts("2564759");
        assertThat(new ArrayList<>(), is(expected));
    }

    @Test
    public void whenDeleteAccount() {
        bank.addAccountToUser("2564759", stasAccount);
        Account stasAccount2 = new Account();
        stasAccount2.setValue(100);
        stasAccount2.setRequisites("00002");
        bank.addAccountToUser("2564759", stasAccount2);
        bank.deleteAccountToUser("2564759", stasAccount2);
        boolean expected = bank.getUserAccounts("2564759").contains(stasAccount2);
        assertThat(expected, is(false));
    }

    @Test
    public void whenDeleteAccountUserNotFoundInStore() {
        bank.addAccountToUser("2564759", stasAccount);
        Account stasAccount2 = new Account();
        stasAccount2.setValue(100);
        stasAccount2.setRequisites("00002");
        bank.addAccountToUser("2564759", stasAccount2);
        bank.deleteAccountToUser("1111111", stasAccount2);
        boolean expected = bank.getUserAccounts("2564759").contains(stasAccount2);
        assertThat(expected, is(true));
    }

    @Test
    public void whenDeleteAccountListAccountsNoContainsAccountThatDelete() {
        Account stasAccount2 = new Account();
        stasAccount2.setValue(100);
        stasAccount2.setRequisites("00002");
        bank.addAccountToUser("2564759", stasAccount2);
        bank.deleteAccountToUser("2564759", stasAccount);
        boolean expected = bank.getUserAccounts("2564759").contains(stasAccount2);
        assertThat(expected, is(true));
    }

    @Test
    public void whenTransfer100ThenTrue() {
        User igor = new User("Igor", "1894536");
        bank.addUser(igor);
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
        User igor = new User("Igor", "1894536");
        bank.addUser(igor);
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
        Account stasAccount2 = new Account();
        stasAccount2.setValue(100);
        stasAccount2.setRequisites("00002");
        bank.addAccountToUser("2564759", stasAccount);
        bank.addAccountToUser("2564759", stasAccount2);
        boolean expected = bank.transferMoney("2564759", "00001",
                "2564759", "00002", 100);
        assertThat(expected, is(true));
    }

    @Test
    public void whenTransfer100UserToAccountIsNullThenFalse() {
        bank.addAccountToUser("2564759", stasAccount);
        boolean expected = bank.transferMoney("2564759", "00001",
                "2564759", "00002", 100);
        assertThat(expected, is(false));
    }

    @Test
    public void whenTransfer100UserSourceAccountIsNullThenFalse() {
        boolean expected = bank.transferMoney("2564759", "00002",
                "2564759", "00001", 100);
        assertThat(expected, is(false));
    }
}
