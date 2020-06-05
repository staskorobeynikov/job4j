package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter check = new Counter();
        int result = check.add(1, 10);
        assertThat(result, is(30));
    }
    @Test
    public void whenSumEvenNumbersFrom10To100Then2550() {
        Counter check = new Counter();
        int result = check.add(10, 100);
        assertThat(result, is(2530));
    }
}
