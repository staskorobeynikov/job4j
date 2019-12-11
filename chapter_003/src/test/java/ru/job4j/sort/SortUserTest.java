package ru.job4j.sort;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;

public class SortUserTest {
    @Test
    public void whenSortDataName() {
        List<User> expected = new ArrayList<>();
        User user1 = new User("Stas", 25);
        User user2 = new User("Sergey", 35);
        User user3 = new User("Vladislav", 30);
        expected.add(user1);
        expected.add(user2);
        expected.add(user3);
        List<User> result = new ArrayList<>();
        result.add(user1);
        result.add(user3);
        result.add(user2);
        SortUser.sortNameLength(result);
        assertThat(result, is(expected));
    }
    @Test
    public void whenSortDataAllFields() {
        List<User> expected = new ArrayList<>();
        User user1 = new User("Stas", 25);
        User user2 = new User("Stas", 35);
        User user3 = new User("Stas", 30);
        expected.add(user1);
        expected.add(user3);
        expected.add(user2);
        List<User> result = new ArrayList<>();
        result.add(user2);
        result.add(user3);
        result.add(user1);
        SortUser.sortByAllFields(result);
        assertThat(result, is(expected));
    }
    @Test
    public void whenSortDataAllFieldsFourUsers() {
        List<User> expected = new ArrayList<>();
        User user1 = new User("Sergey", 25);
        User user2 = new User("Ivan", 30);
        User user3 = new User("Sergey", 20);
        User user4 = new User("Ivan", 25);
        expected.add(user4);
        expected.add(user2);
        expected.add(user3);
        expected.add(user1);
        List<User> result = new ArrayList<>();
        result.add(user2);
        result.add(user3);
        result.add(user1);
        result.add(user4);
        SortUser.sortByAllFields(result);
        assertThat(result, is(expected));
    }
}
