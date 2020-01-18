package ru.job4j.tictactoegame;

import java.util.List;

/**
 * Class launches game TicTacToeGame.
 *
 * @author STAS KOROBEYNIKOV
 * @since 18.01.2020.
 */
public class TicTacToeGame {
    /**
     * Input arguments.
     */
    protected final Input input;
    /**
     * Playing field.
     */
    protected final Field field;
    /**
     * Game game.
     */
    final Game game;
    /**
     * List player.
     */
    final List<Gamer> gamers;

    TicTacToeGame(Input input, Field field, Game game, List<Gamer> gamers) {
        this.input = input;
        this.field = field;
        this.game = game;
        this.gamers = gamers;
    }

    /**
     * Method for launch game.
     */
    public void startGame() {
        game.initGame(input, field);
        boolean result = field.isFreeCell();
        while (result) {
            for (Gamer gamer : gamers) {
                game.completeMove(input, field, gamer, gamer.setUseSymbol());
                if (field.checkCombination(gamer.setUseSymbol())) {
                    System.out.println(String.format("Winner is: %s.", gamer.getName()));
                    result = false;
                    break;
                }
                if (!field.isFreeCell()) {
                    System.out.println("Draw.");
                    result = false;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToeGame(
                new ValidateInput(new ConsoleInput()),
                new PlayingField(),
                new SimpleGame(),
                List.of(new User(), new Computer())).startGame();
    }
}
