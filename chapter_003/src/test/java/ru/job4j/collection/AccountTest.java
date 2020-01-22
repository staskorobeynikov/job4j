package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AccountTest {
    @Test
    public void whenTestMethodEquals() {
        Account account = new Account("123", "Petr Arsentev", "eDer3432f");

        boolean result = account.equals(account);

        assertThat(result, is(true));
    }

    @Test
    public void whenTestMethodEqualsIsFalse() {
        Account account = new Account("123", "Petr Arsentev", "eDer3432f");

        boolean result = account.equals(new Task(" ", " "));

        assertThat(result, is(false));
    }
}