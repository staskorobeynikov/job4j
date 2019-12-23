package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void when2ElementsAddWithoutParents() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(3, 4);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTestWorkiterator() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        Iterator it = tree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(((Node) it.next()).getValue(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(((Node) it.next()).getValue(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(((Node) it.next()).getValue(), is(3));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenTreeIsBinary() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(4, 5);
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenTreeIsNotBinary() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertFalse(tree.isBinary());
    }
}