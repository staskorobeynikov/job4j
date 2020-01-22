package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UniqueTextTest {

    @Test
    public void isEquals() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse";
        String text = "My cat eats a mouse";
        assertThat(uniqueText.isEquals(origin, text), is(true));
    }

    @Test
    public void isNotEquals() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        assertThat(uniqueText.isEquals(origin, text), is(false));
    }
}