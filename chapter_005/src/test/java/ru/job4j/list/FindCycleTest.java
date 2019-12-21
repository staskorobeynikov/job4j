package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindCycleTest {
    FindCycle<Integer> fc;

    @Before
    public void init() {
        fc = new FindCycle<>();
    }

    @Test
    public void whenFindCycleIsTrue() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        assertThat(fc.hasCycle(first), is(true));
    }

    @Test
    public void whenFindCycleInTheMiddle() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        assertThat(fc.hasCycle(first), is(true));
    }

    @Test
    public void whenOneElementFindCycle() {
        Node first = new Node(1);
        first.next = first;
        assertThat(fc.hasCycle(first), is(true));
    }

    @Test
    public void whenOneElementFindCycleNextNullThenFalse() {
        Node first = new Node(1);
        first.next = null;
        assertThat(fc.hasCycle(first), is(false));
    }

    @Test
    public void whenOneElementIsNullFindCycleThenFalse() {
        Node first = new Node(null);
        assertThat(fc.hasCycle(first), is(false));
    }
}