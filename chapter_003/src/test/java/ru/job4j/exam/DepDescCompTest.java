package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class DepDescCompTest {

    @Test
    public void whenCompareFirstAndSecondEqualLengthIsSecondGreater() {
        int result = new DepDescComp().compare(
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenCompareFirstAndSecondEqualLengthIsEqual0() {
        int result = new DepDescComp().compare(
                "K2/SK1/SSK1",
                "K2/SK1/SSK1"
        );
        assertThat(result, equalTo(0));
    }

    @Test
    public void whenCompareFirstAndSecondDifferentLengthIsSecondLess() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1/SSK2"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareFirstAndSecondDifferentLengthCharOnSecondPositionIsLessIsSecondLess() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K1/SK1/SSK2"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareFirstAndSecondDifferentLengthCharOnSecondPositionIsLessIsSecondGreater() {
        int rsl = new DepDescComp().compare(
                "K1/SK1/SSK2",
                "K2"
        );
        assertThat(rsl, greaterThan(0));
    }
}