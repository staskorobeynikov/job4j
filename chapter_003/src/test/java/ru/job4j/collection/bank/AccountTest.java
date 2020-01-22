package ru.job4j.collection.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void whenTestSetRequisite() {
        Account account = new Account("1111", 100);
        account.setRequisite("2222");

        String result = account.getRequisite();

        assertThat(result, is("2222"));
    }

    @Test
    public void whenTestHashCode() {
        Account account = new Account("1111", 100);

        int result = account.hashCode();

        assertThat(result, is(1508447));
    }

    @Test
    public void whenTestToString() {
        Account account = new Account("1111", 100);

        String result = account.toString();

        assertThat(result, is("Account: requisite=1111, balance=100.0"));
    }

    @Test
    public void whenTestEqualsMethod() {
        Account account = new Account("1111", 100);

        boolean result = account.equals(account);

        assertThat(result, is(true));
    }

    @Test
    public void whenTestEqualsMethodUIsFalse() {
        Account account = new Account("1111", 100);

        boolean result = account.equals(new User("", ""));

        assertThat(result, is(false));
    }
}