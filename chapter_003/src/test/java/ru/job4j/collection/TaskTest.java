package ru.job4j.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void whenTestMethodModelTask() {
        Set<? super Task> store = new HashSet<>();
        Task task = new Task("1", "first");
        Task task1 = new Task("1", "second");
        store.add(task);
        store.add(task1);

        assertThat(store.size(), is(1));
    }
}