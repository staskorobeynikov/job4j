package ru.job4j.tictactoegame;

public interface Game {
    /**
     * Initializes game.
     *
     * @param input input parameters.
     * @param field playing field.
     */
    void initGame(Input input, Field field);

    /**
     * Method complete move for gamer on the playing field with gamer's symbol.
     *
     * @param input input parameters.
     * @param field playing field.
     * @param gamer Gamer.
     * @param symbol symbol of gamer.
     */
    void completeMove(Input input, Field field, Gamer gamer, String symbol);
}
