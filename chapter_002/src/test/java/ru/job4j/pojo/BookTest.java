package ru.job4j.pojo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void whenGetName() {
        Book book = new Book("book", 3);

        String result = book.getName();

        assertThat(result, is("book"));
    }

    @Test
    public void whenGetCount() {
        Book book = new Book("book", 3);

        int result = book.getCount();

        assertThat(result, is(3));
    }

    @Test
    public void whenSetNameAndGetName() {
        Book book = new Book(" ", 3);
        book.setName("book1");

        String result = book.getName();

        assertThat(result, is("book1"));
    }

    @Test
    public void whenSetCountAndGetCount() {
        Book book = new Book("book1", 0);
        book.setCount(5);

        int result = book.getCount();

        assertThat(result, is(5));
    }
}