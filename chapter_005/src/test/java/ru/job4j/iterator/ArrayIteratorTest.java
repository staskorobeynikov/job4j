package ru.job4j.iterator;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayIteratorTest {
    private ArrayIterator<Integer> it;
    @Before
    public void setUp() {
        it = new ArrayIterator(new Integer[][]{{1}, {3, 4}, {7}});
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        MatcherAssert.assertThat(it.next(), Matchers.is(1));
        MatcherAssert.assertThat(it.next(), Matchers.is(3));
        MatcherAssert.assertThat(it.next(), Matchers.is(4));
        MatcherAssert.assertThat(it.next(), Matchers.is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(1));
        MatcherAssert.assertThat(it.next(), Matchers.is(3));
        MatcherAssert.assertThat(it.next(), Matchers.is(4));
        MatcherAssert.assertThat(it.next(), Matchers.is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(1));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(3));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(4));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(true));
        MatcherAssert.assertThat(it.next(), Matchers.is(7));
        MatcherAssert.assertThat(it.hasNext(), Matchers.is(false));
    }
    @Test
    public void whenThreeArrayWithoutNull() {
        ArrayIterator<Integer> it = new ArrayIterator<Integer>(new Integer[][]
                {{1}, {2}, {3, 5}});
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
    }
    @Test
    public void whenThreeArrayWithNull() {
        ArrayIterator<Integer> it = new ArrayIterator<Integer>(new Integer[][]
                {{1}, {2}, {}, {3, 5}});
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
    }
    @Test
    public void whenThreeArrayHasNextMethod() {
        ArrayIterator<Integer> it = new ArrayIterator<Integer>(new Integer[][]
                {{1}, {2}, {3, 5}});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
    }
    @Test
    public void whenArray135And7911Is1357911() {
        ArrayIterator<Integer> it = new ArrayIterator<Integer>(new Integer[][]
                {{1, 3, 5}, {7, 9, 11}});
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(11));
        assertThat(it.hasNext(), is(false));
    }
    @Test(expected = NoSuchElementException.class)
    public void whenArrayGetException() {
        ArrayIterator<Integer> it = new ArrayIterator<Integer>(new Integer[][]
                {{1}, {2}, {3, 5}});
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
    }
}
