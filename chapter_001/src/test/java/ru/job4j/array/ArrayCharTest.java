package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCharTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'e'};
        ArrayChar arrayChar = new ArrayChar();
        boolean result = arrayChar.startsWith(word, pref);
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'i'};
        ArrayChar arrayChar = new ArrayChar();
        boolean result = arrayChar.startsWith(word, pref);
        assertThat(result, is(false));
    }

    @Test
    public void whenStartWithLastGreatThenTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'e', 'l', 'l', 'O'};
        ArrayChar arrayChar = new ArrayChar();
        boolean result = arrayChar.startsWith(word, pref);
        assertThat(result, is(false));
    }
}
