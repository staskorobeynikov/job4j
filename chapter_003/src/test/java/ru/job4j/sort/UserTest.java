package ru.job4j.sort;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = Set.of(
                new User("Petr", 32),
                new User("Ivan", 31)
        );
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Petr", 32)));
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
}
