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

    @Test
    public void whenTestToString() {
        User user = new User("1111", "name");

        String result = user.toString();

        assertThat(result, is("User: passport=1111, username=name"));
    }

    @Test
    public void whenTestEqualsMethod() {
        User user = new User("1111", "name");
        User user1 = new User("1111", "name666");

        boolean result = user.equals(user1);

        assertThat(result, is(true));
    }

    @Test
    public void whenTestEqualsMethodIsFalse() {
        User user = new User("1111", "name");

        boolean result = user.equals(new Account(" ", 100));

        assertThat(result, is(false));
    }

    @Test
    public void whenTestEqualsMethodIsFalse1() {
        User user = new User("1111", "name");
        User user1 = null;

        boolean result = user.equals(user1);

        assertFalse(result);
    }
}