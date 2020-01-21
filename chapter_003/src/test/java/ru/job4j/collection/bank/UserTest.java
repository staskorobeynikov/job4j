package ru.job4j.collection.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenSetPassport() {
        User user = new User("1111", "name");
        user.setPassport("2222");

        String result = user.getPassport();

        assertThat(result, is("2222"));
    }

    @Test
    public void whenSetUserName() {
        User user = new User("1111", "name");
        user.setUsername("name666");

        String result = user.getUsername();

        assertThat(result, is("name666"));
    }
}