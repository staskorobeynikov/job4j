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
    public void whenNotExistFirstConditionInAction() {
        Triangle triangle = new Triangle();
        assertThat(triangle.exist(4, 5, 9), is(false));
    }

    @Test
    public void whenNotExistSecondConditionInAction() {
        Triangle triangle = new Triangle();
        assertThat(triangle.exist(9, 4, 5), is(false));
    }

    @Test
    public void whenNotExistThirdConditionInAction() {
        Triangle triangle = new Triangle();
        assertThat(triangle.exist(4, 9, 5), is(false));
    }
}
