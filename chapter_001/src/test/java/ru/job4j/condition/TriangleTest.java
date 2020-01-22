package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenExist() {
        Triangle triangle = new Triangle();
        assertThat(triangle.exist(2, 2, 2), is(true));
    }

    @Test
    public void whenNotExist() {
        Triangle triangle = new Triangle();
        assertThat(triangle.exist(5, 5, 12), is(false));
    }
}
