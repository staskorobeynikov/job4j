package ru.job4j.sort;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;

public class SortUserTest {

    @Test
    public void whenSortDataName() {
        List<User> expected = List.of(
                new User("Stas", 25),
                new User("Sergey", 35),
                new User("Vladislav", 30)
        );
        List<User> result = new ArrayList<>();
        result.add(new User("Stas", 25));
        result.add(new User("Vladislav", 30));
        result.add(new User("Sergey", 35));
        SortUser.sortNameLength(result);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortDataAllFields() {
        List<User> expected = List.of(
                new User("Stas", 25),
                new User("Stas", 30),
                new User("Stas", 35)
        );
        List<User> result = new ArrayList<>();
        result.add(new User("Stas", 35));
        result.add(new User("Stas", 30));
        result.add(new User("Stas", 25));
        SortUser.sortByAllFields(result);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortDataAllFieldsFourUsers() {
        List<User> expected = List.of(
                new User("Ivan", 25),
                new User("Ivan", 30),
                new User("Sergey", 20),
                new User("Sergey", 25)
        );
        List<User> result = new ArrayList<>();
        result.add(new User("Ivan", 30));
        result.add(new User("Sergey", 20));
        result.add(new User("Sergey", 25));
        result.add(new User("Ivan", 25));
        SortUser.sortByAllFields(result);
        assertThat(result, is(expected));
    }
}
