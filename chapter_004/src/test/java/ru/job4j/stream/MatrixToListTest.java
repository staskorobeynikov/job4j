package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MatrixToListTest {

    @Test
    public void whenMatrixToList() {
        MatrixToList test = new MatrixToList();
        List<Integer> actual = test.convert(new Integer[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenMatrixNonQuadraticToList() {
        MatrixToList test = new MatrixToList();
        List<Integer> actual = test.convert(new Integer[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8},
                {9}
        });
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(actual, is(expected));
    }
}
