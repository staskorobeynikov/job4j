package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FreezeStrTest {

    @Test
    public void whenEq() {
        assertThat(FreezeStr.equal("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.equal("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.equal("heloo", "hello"), is(false));
    }

    @Test
    public void whenEq1() {
        assertThat(FreezeStr.equalWithSetValues("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq1() {
        assertThat(FreezeStr.equalWithSetValues("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq1() {
        assertThat(FreezeStr.equalWithSetValues("heloo", "hello"), is(false));
    }
}