package ru.job4j.exam;

import org.junit.Test;

import static org.junit.Assert.*;

public class FreezeStrTest {

    @Test
    public void whenEq() {
        assertTrue(FreezeStr.equal("Hello", "Hlloe"));
    }

    @Test
    public void whenNotEqualWithDifferentLength() {
        assertFalse(FreezeStr.equal("Hello", "Hlloeе"));
    }

    @Test
    public void whenNotEq() {
        assertFalse(FreezeStr.equal("Hello", "Halle"));
    }

    @Test
    public void whenNotMultiEq() {
        assertFalse(FreezeStr.equal("heloo", "hello"));
    }

    @Test
    public void whenEq1() {
        assertTrue(FreezeStr.equalWithSetValues("Hello", "Hlloe"));
    }

    @Test
    public void whenNotEqualWithDifferentLength1() {
        assertFalse(FreezeStr.equalWithSetValues("Hello", "Hlloeе"));
    }

    @Test
    public void whenNotEq1() {
        assertFalse(FreezeStr.equalWithSetValues("Hello", "Halle"));
    }

    @Test
    public void whenNotMultiEq1() {
        assertFalse(FreezeStr.equalWithSetValues("heloo", "hello"));
    }
}