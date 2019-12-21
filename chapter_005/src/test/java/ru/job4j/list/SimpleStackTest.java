package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    SimpleStack<Integer> st;

    @Before
    public void init() {
        st = new SimpleStack<>();
    }

    @Test
    public void whenPushElementAndRemoveElement() {
        st.push(5);
        st.push(10);
        assertThat(st.poll(), is(10));
        assertThat(st.poll(), is(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenRemoveElementEmptyStack() {
        st.push(5);
        st.push(10);
        st.poll();
        st.poll();
        st.poll();
    }

    @Test
    public void whenAddElementFourAndRemoveElement() {
        st.push(5);
        st.push(10);
        st.push(15);
        st.push(20);
        assertThat(st.poll(), is(20));
        assertThat(st.poll(), is(15));
        assertThat(st.poll(), is(10));
        assertThat(st.poll(), is(5));
    }

    @Test
    public void whenReplaceElementWithPushAndRemove() {
        st.push(5);
        st.poll();
        st.push(10);
        assertThat(st.poll(), is(10));
    }
}