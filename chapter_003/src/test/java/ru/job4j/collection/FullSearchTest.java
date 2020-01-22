package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        FullSearch fullSearch = new FullSearch();
        List<Task> tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(fullSearch.extractNumber(tasks), is(expected));
    }

    @Test
    public void whenGetNumber() {
        Task task = new Task("1", "First desc");

        String result = task.getNumber();

        assertThat(result, is("1"));
    }

    @Test
    public void whenGetDescription() {
        Task task = new Task("1", "First desc");

        String result = task.getDescription();

        assertThat(result, is("First desc"));
    }
}