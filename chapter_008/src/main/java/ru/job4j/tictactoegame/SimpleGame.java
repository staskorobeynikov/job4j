package ru.job4j.tictactoegame;

/**
 * Class for working with the game TicTacToe.
 *
 * @author STAS KOROBEYNIKOV
 * @since 17.01.2020
 */
public class SimpleGame implements Game {
    /**
     * Initializes game TicTacToe.
     *
     * @param input input parameters.
     * @param field playing field.
     */
    @Override
    public void initGame(Input input, Field field) {
        field.initBoard(input);
        field.printBoard();
    }

    /**
     * Method complete move for gamer on the playing field game TicTacToe with gamer's symbol.
     *
     * @param input input parameters.
     * @param field playing field.
     * @param gamer Gamer.
     * @param symbol symbol of gamer.
     */
    @Override
    public void completeMove(Input input, Field field, Gamer gamer, String symbol) {
        int x, y;
        do {
            x = gamer.getNumberLine(input, field);
            y = gamer.getNumberColumn(input, field);
        } while (!field.isValidCell(x, y));
        field.addFigure(x, y, symbol);
        field.printBoard();
    }
}
