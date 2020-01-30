package ru.job4j.array;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenDataMonoByTrueThenTrue() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
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
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse1() {
        char[][] input = {
                {' ', ' ', ' ', ' ', ' '},
                {'X', 'X', 'X', 'X', 'X'},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenTestMethodMain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        MatrixCheck.main(args);

        String expect = String.format(
                "__X__%s"
                        + "__X__%s"
                        + "__X__%s"
                        + "__X__%s"
                        + "__X__%s"
                        + "A board has a winner : true%s%s"
                        + "_____%s"
                        + "XXXXX%s"
                        + "_____%s"
                        + "_____%s"
                        + "_____%s"
                        + "A board has a winner : true%s%s"
                        + "__X__%s"
                        + "__X__%s"
                        + "_X___%s"
                        + "__X__%s"
                        + "__X__%s%s"
                        + "A board has a winner : false%s",
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
