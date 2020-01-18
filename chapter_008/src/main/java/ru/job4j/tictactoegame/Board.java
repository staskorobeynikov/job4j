package ru.job4j.tictactoegame;

public interface Board {
    /**
     * Initializes board.
     *
     * @param input input parameters.
     */
    void initBoard(Input input);

    /**
     * Print the board.
     */
    void printBoard();

    /**
     * Method return board size.
     *
     * @return size board.
     */
    int getSize();

    /**
     * Method adds figure on the board.
     *
     * @param x number line on board.
     * @param y number column on board.
     * @param symbol symbol to add.
     */
    void addFigure(int x, int y, String symbol);
}
