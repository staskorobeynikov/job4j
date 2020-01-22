package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getName() {
        User user = new User("name", "11111");

        String result = user.getName();

        assertThat(result, is("name"));
    }

    @Test
    public void setName() {
        User user = new User("name", "11111");
        user.setName("name666");

        String result = user.getName();

        assertThat(result, is("name666"));
    }

    @Test
    public void getPassport() {
        User user = new User("name", "11111");

        String result = user.getPassport();

        assertThat(result, is("11111"));
    }

    @Test
    public void setPassport() {
        User user = new User("name", "11111");
        user.setPassport("22222");

        String result = user.getPassport();

        assertThat(result, is("22222"));
    }

    @Test
    public void testEqualsIsTrue() {
        User user = new User("name", "11111");
        User user1 = new User("name", "11111");

        boolean result = user.equals(user1);

        assertThat(result, is(true));

    }

    @Test
    public void testEqualsIsTrue1() {
        User user = new User("name", "11111");

        boolean result = user.equals(user);

        assertThat(result, is(true));

    }

    @Test
    public void testEqualsIsFalse() {
        User user = new User("name", "11111");
        Account account = new Account();

        boolean result = user.equals(account);

        assertThat(result, is(false));
    }
}