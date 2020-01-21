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
}