package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getId() {
        User user = new User(1, "name", "city");

        int result = user.getId();

        assertThat(result, is(1));
    }

    @Test
    public void getName() {
        User user = new User(1, "name", "city");

        String result = user.getName();

        assertThat(result, is("name"));
    }

    @Test
    public void getCity() {
        User user = new User(1, "name", "city");

        String result = user.getCity();

        assertThat(result, is("city"));
    }

    @Test
    public void testToString() {
        User user = new User(1, "name", "city");

        String result = user.toString();

        assertThat(result, is("User: id = 1, name = name, city = city"));
    }

    @Test
    public void whenTestEqualsIsTrue() {
        User user = new User(1, "name", "city");

        boolean result = user.equals(user);

        assertThat(result, is(true));
    }

    @Test
    public void whenTestEqualsIsFalse() {
        User user = new User(1, "name", "city");
        ConvertList convertList = new ConvertList();

        boolean result = user.equals(convertList);

        assertThat(result, is(false));
    }

    @Test
    public void testHashCode() {
        User user = new User(1, "name", "city");

        int result = user.hashCode();

        assertThat(result, is(107669600));
    }
}