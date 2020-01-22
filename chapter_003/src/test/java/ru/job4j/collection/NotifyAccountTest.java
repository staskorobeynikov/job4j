package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void whenTwoAccountsAddSent() {
        NotifyAccount notifyAccount = new NotifyAccount();
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(notifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenFourAccountsAddSent() {
        NotifyAccount notifyAccount = new NotifyAccount();
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001"),
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(notifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenTestToString() {
        Account account = new Account("123", "Petr Arsentev", "eDer3432f");

        String result = account.toString();

        assertThat(result, is("Account: passport=123, username=Petr Arsentev, deposit=eDer3432f"));
    }

    @Test
    public void whenTestMethodEquals() {
        Account account = new Account("123", "Petr Arsentev", "eDer3432f");

        boolean result = account.equals(account);

        assertThat(result, is(true));
    }

    @Test
    public void whenTestMethodEqualsIsFalse() {
        Account account = new Account("123", "Petr Arsentev", "eDer3432f");

        boolean result = account.equals(new Task("", ""));

        assertThat(result, is(false));
    }
}