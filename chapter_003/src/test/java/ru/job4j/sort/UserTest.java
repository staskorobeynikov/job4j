package ru.job4j.sort;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Set<User> expected = Set.of(
                new User("Ivan", 31),
                new User("Petr", 32)
        );
        assertThat(users, is(expected));
    }
    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }
    @Test
    public void whenCompareIvanVSPetr() {
        int rsl = new User("Ivan", 32)
                .compareTo(
                        new User("Petr", 31)
                );
        assertThat(rsl, greaterThan(-100));
    }
    @Test
    public void whenComparePertVSPetr() {
        int rsl = new User("Petr", 31)
                .compareTo(
                        new User("Petr", 35)
                );
        assertThat(rsl, greaterThan(-100));
    }
    @Test
    public void whenComparePertVSPetr2() {
        int rsl = new User("Petr", 35)
                .compareTo(
                        new User("Petr", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void testHashCode() {
        User user = new User("Petr", 35);

        int result = user.hashCode();

        assertThat(result, is(77006577));
    }

    @Test
    public void testToString() {
        User user = new User("Petr", 35);

        String result = user.toString();

        assertThat(result, is("name = 'Petr', age = 35"));
    }

    @Test
    public void whenTestEqualsIsTrue() {
        User user = new User("Petr", 35);

        boolean result = user.equals(user);

        assertThat(result, is(true));
    }

    @Test
    public void whenTestEqualsIsFalse() {
        User user = new User("Petr", 35);
        SortUser sortUser = new SortUser();

        boolean result = user.equals(sortUser);

        assertThat(result, is(false));
    }
}
