package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EndsWithTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] post = {'l', 'o'};
        EndsWith endsWith = new EndsWith();
        boolean result = endsWith.endsWith(word, post);
        assertThat(result, is(true));
    }
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] post = {'l', 'a'};
        EndsWith endsWith = new EndsWith();
        boolean result = endsWith.endsWith(word, post);
        assertThat(result, is(false));
    }
    @Test
    public void whenStartWithAllWord() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] post = {'H', 'e', 'l', 'l', 'o'};
        EndsWith endsWith = new EndsWith();
        boolean result = endsWith.endsWith(word, post);
        assertThat(result, is(true));
    }
    @Test
    public void whenStartWithAllWordLGreet() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] post = {'H', 'e', 'L', 'l', 'o'};
        EndsWith endsWith = new EndsWith();
        boolean result = endsWith.endsWith(word, post);
        assertThat(result, is(false));
    }
}
