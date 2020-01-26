package ru.job4j.tictactoegame;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TicTacToeGameTest {
    private static final String LN = System.lineSeparator();
    private static final String TAB = "\t";

    @Test
    public void whenTestTicTacToeStartGame() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        List<Gamer> gamers = List.of(new User(), new Computer("Comp", "1"));
        List<String> answers = Arrays.asList("0", "1", "1", "1");
        Input input = new StubInput(answers);
        Field field = new PlayingField();
        Game game = new SimpleGame();
        new TicTacToeGame(input, field, game, gamers).startGame();

        assertThat(new String(out.toByteArray()), is(String.format(
                "*%s%sX%s%sWinner is: User.%s",
                TAB,
                LN,
                TAB,
                LN,
                LN)));
        System.setOut(def);
    }

    @Test
    public void whenTestTicTacToeStartGameComputerWithComputer() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        List<Gamer> gamers = List.of(new Computer("Comp1", "X"), new Computer("Comp2", "O"));
        List<String> answers = Arrays.asList("0", "1", "1", "1");
        Input input = new StubInput(answers);
        Field field = new PlayingField();
        Game game = new SimpleGame();
        new TicTacToeGame(input, field, game, gamers).startGame();

        assertThat(new String(out.toByteArray()), is(String.format(
                "*%s%sX%s%sWinner is: Comp1.%s",
                TAB,
                LN,
                TAB,
                LN,
                LN)));
        System.setOut(def);
    }
}