package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenExist() {
        // при указании другого ожидаемого результата кидает ошибку
        boolean result = Triangle.exist(2, 2, 2);
        assertThat(result, is(true));
    }
    @Test
    public void whenNotExist() {
        boolean result = Triangle.exist(5, 5, 12);
        assertThat(result, is(false));
    }
}
