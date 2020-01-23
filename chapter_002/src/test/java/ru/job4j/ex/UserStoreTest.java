package ru.job4j.ex;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestFindUser() throws UserNotFoundException {
        UserStore userStore = new UserStore();
        User[] users = {
                new User("Petr Arsentev", true)
        };

        String result = userStore.findUser(users, "Petr Arsentev").getUsername();

        assertThat(result, is("Petr Arsentev"));
    }

    @Test(expected = UserNotFoundException.class)
    public void whenTestFindUserIsException() throws UserNotFoundException {
        UserStore userStore = new UserStore();
        User[] users = {
                new User("Petr Arsentev", true)
        };

        String result = userStore.findUser(users, " ").getUsername();

        assertThat(result, is("Petr Arsentev"));
    }

    @Test
    public void whenTestMethodValidateIsTrue() throws UserInvalidException {
        UserStore userStore = new UserStore();
        User user = new User("Petr Arsentev", true);

        boolean result = userStore.validate(user);

        assertThat(result, is(true));
    }

    @Test(expected = UserInvalidException.class)
    public void whenTestMethodValidateIsExceptionUserNotValid() throws UserInvalidException {
        UserStore userStore = new UserStore();
        User user = new User("Petr Arsentev", false);

        boolean result = userStore.validate(user);

        assertThat(result, is(true));
    }

    @Test(expected = UserInvalidException.class)
    public void whenTestMethodValidateIsExceptionUsernameLessThreeSymbol() throws UserInvalidException {
        UserStore userStore = new UserStore();
        User user = new User("PE", true);

        boolean result = userStore.validate(user);

        assertThat(result, is(true));
    }

    @Test
    public void testMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        UserStore.main(args);

        String expect = String.format(
                "This user has an access%s",
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}