package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {
    @Test
    public void square() {
        SqArea sqArea = new SqArea();
        double expected = 2;
        double out = sqArea.square(6, 2);
        Assert.assertEquals(expected, out, 0.01);
    }
}
