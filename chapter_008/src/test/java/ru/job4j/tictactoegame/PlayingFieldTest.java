package ru.job4j.tictactoegame;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PlayingFieldTest {
    private static final String LN = System.lineSeparator();
    private static final String TAB = "\t";

    @Test
    public void whenUseDefaultSizeBoard() {
        PlayingField playingField = new PlayingField();
        List<String> answers = Collections.singletonList("y");
        StubInput stubInput = new StubInput(answers);
        playingField.initBoard(stubInput);

        int result = playingField.getSize();

        assertThat(result, is(3));
    }

    @Test
    public void whenSizeBoardIsTen() {
        PlayingField playingField = new PlayingField();
        List<String> answers = Arrays.asList("0", "10");
        StubInput stubInput = new StubInput(answers);
        playingField.initBoard(stubInput);

        int result = playingField.getSize();

        assertThat(result, is(10));
    }

    @Test
    public void whenUseDefaultSizeBoardAndTestMethodPrintBoard() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        PlayingField playingField = new PlayingField();
        List<String> answers = Collections.singletonList("y");
        StubInput stubInput = new StubInput(answers);
        playingField.initBoard(stubInput);
        playingField.printBoard();

        assertThat(new String(out.toByteArray()), is(String.format(
                "*%s*%s*%s%s*%s*%s*%s%s*%s*%s*%s%s",
                TAB,
                TAB,
                TAB,
                LN,
                TAB,
                TAB,
                TAB,
                LN,
                TAB,
                TAB,
                TAB,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenPlayingFieldDontHaveFreeCell() {
        PlayingField playingField = new PlayingField();
        List<String> answers = Collections.singletonList("y");
        StubInput stubInput = new StubInput(answers);
        playingField.initBoard(stubInput);
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                playingField.addFigure(i, j, "X");
            }
        }

        boolean result = playingField.isFreeCell();

        assertThat(result, is(false));
    }

    @Test
    public void whenPlayingFieldHasFreeCell() {
        PlayingField playingField = new PlayingField();
        List<String> answers = Collections.singletonList("y");
        StubInput stubInput = new StubInput(answers);
        playingField.initBoard(stubInput);
        for (int i = 1; i < 4; i++) {
            playingField.addFigure(i, 1, "X");
        }

        boolean result = playingField.isFreeCell();

        assertThat(result, is(true));
    }

    @Test
    public void whenAddFigureIsValidCell() {
        PlayingField playingField = new PlayingField();
        List<String> answers = Collections.singletonList("y");
        StubInput stubInput = new StubInput(answers);
        playingField.initBoard(stubInput);
        for (int i = 1; i < 4; i++) {
            playingField.addFigure(i, 2, "X");
        }

        boolean result = playingField.isValidCell(2, 3);

        assertThat(result, is(true));
    }

    @Test
    public void whenAddFigureIsNotValidCell() {
        PlayingField playingField = new PlayingField();
        List<String> answers = Collections.singletonList("y");
        StubInput stubInput = new StubInput(answers);
        playingField.initBoard(stubInput);
        for (int i = 1; i < 4; i++) {
            playingField.addFigure(i, 2, "X");
        }

        boolean result = playingField.isValidCell(2, 2);

        assertThat(result, is(false));
    }

    @Test
    public void whenCheckCombinationLine() {
        PlayingField playingField = new PlayingField();
        List<String> answers = Collections.singletonList("y");
        StubInput stubInput = new StubInput(answers);
        playingField.initBoard(stubInput);
        for (int i = 1; i < 4; i++) {
            playingField.addFigure(i, 2, "X");
        }

        boolean result = playingField.checkCombination("X");

        assertThat(result, is(true));
    }

    @Test
    public void whenCheckCombinationColumn() {
        PlayingField playingField = new PlayingField();
        List<String> answers = Collections.singletonList("y");
        StubInput stubInput = new StubInput(answers);
        playingField.initBoard(stubInput);
        for (int i = 1; i < 4; i++) {
            playingField.addFigure(2, i, "X");
        }

        boolean result = playingField.checkCombination("X");

        assertThat(result, is(true));
    }

    @Test
    public void whenCheckCombinationLeftDiagonal() {
        PlayingField playingField = new PlayingField();
        List<String> answers = Collections.singletonList("y");
        StubInput stubInput = new StubInput(answers);
        playingField.initBoard(stubInput);
        playingField.addFigure(1, 1, "X");
        playingField.addFigure(2, 2, "X");
        playingField.addFigure(3, 3, "X");

        boolean result = playingField.checkCombination("X");

        assertThat(result, is(true));
    }

    @Test
    public void whenCheckCombinationRightDiagonal() {
        PlayingField playingField = new PlayingField();
        List<String> answers = Collections.singletonList("y");
        StubInput stubInput = new StubInput(answers);
        playingField.initBoard(stubInput);
        playingField.addFigure(3, 1, "X");
        playingField.addFigure(2, 2, "X");
        playingField.addFigure(1, 3, "X");

        boolean result = playingField.checkCombination("X");

        assertThat(result, is(true));
    }

    @Test
    public void whenCheckCombinationIsFalse() {
        PlayingField playingField = new PlayingField();
        List<String> answers = Collections.singletonList("y");
        StubInput stubInput = new StubInput(answers);
        playingField.initBoard(stubInput);
        playingField.addFigure(1, 1, "X");
        playingField.addFigure(1, 3, "X");
        playingField.addFigure(3, 1, "X");
        playingField.addFigure(3, 3, "X");

        boolean result = playingField.checkCombination("X");

        assertThat(result, is(false));
    }
}