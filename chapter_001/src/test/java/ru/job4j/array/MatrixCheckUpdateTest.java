package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixCheckUpdateTest {
    @Test
    public void whenHasMonoHorizontal() {
        char[][] input = {
                {' ', ' ', ' '},
                {'X', 'X', 'X'},
                {' ', ' ', ' '},
        };
        MatrixCheckUpdate matrixCheckUpdate = new MatrixCheckUpdate();
        boolean result = matrixCheckUpdate.monoHorizontal(input, 1);
        assertThat(result, is(true));
    }

    @Test
    public void whenHasNotMonoHorizontal() {
        char[][] input = {
                {' ', ' ', ' '},
                {'X', 'X', ' '},
                {' ', ' ', ' '},
        };
        MatrixCheckUpdate matrixCheckUpdate = new MatrixCheckUpdate();
        boolean result = matrixCheckUpdate.monoHorizontal(input, 1);
        assertThat(result, is(false));
    }

    @Test
    public void whenHasMonoVertical() {
        char[][] input = {
                {' ', ' ', 'X'},
                {' ', ' ', 'X'},
                {' ', ' ', 'X'},
        };
        MatrixCheckUpdate matrixCheckUpdate = new MatrixCheckUpdate();
        boolean result = matrixCheckUpdate.monoVertical(input, 2);
        assertThat(result, is(true));
    }

    @Test
    public void whenHasNotMonoVertical() {
        char[][] input = {
                {' ', ' ', 'X'},
                {' ', ' ', ' '},
                {' ', ' ', 'X'},
        };
        MatrixCheckUpdate matrixCheckUpdate = new MatrixCheckUpdate();
        boolean result = matrixCheckUpdate.monoVertical(input, 2);
        assertThat(result, is(false));
    }

    @Test
    public void whenDiagonal() {
        char[][] input = {
                {'X', ' ', ' '},
                {' ', 'X', ' '},
                {' ', ' ', 'X'},
        };
        MatrixCheckUpdate matrixCheckUpdate = new MatrixCheckUpdate();
        char[] result = matrixCheckUpdate.extractDiagonal(input);
        char[] expect = {'X', 'X', 'X'};
        assertThat(result, is(expect));
    }

    @Test
    public void whenNotDiagonal() {
        char[][] input = {
                {'X', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', 'X'},
        };
        MatrixCheckUpdate matrixCheckUpdate = new MatrixCheckUpdate();
        char[] result = matrixCheckUpdate.extractDiagonal(input);
        char[] expect = {'X', ' ', 'X'};
        assertThat(result, is(expect));
    }

    @Test
    public void whenDataMonoByTrueThenTrue() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        MatrixCheckUpdate matrixCheckUpdate = new MatrixCheckUpdate();
        boolean result = matrixCheckUpdate.isWin(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        MatrixCheckUpdate matrixCheckUpdate = new MatrixCheckUpdate();
        boolean result = matrixCheckUpdate.isWin(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataHMonoByTrueThenTrue() {
        char[][] input = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {'X', 'X', 'X', 'X', 'X'},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        MatrixCheckUpdate matrixCheckUpdate = new MatrixCheckUpdate();
        boolean result = matrixCheckUpdate.isWin(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataVMonoByTrueThenTrue() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', 'X', 'X'},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        MatrixCheckUpdate matrixCheckUpdate = new MatrixCheckUpdate();
        boolean result = matrixCheckUpdate.isWin(input);
        assertThat(result, is(true));
    }

}
