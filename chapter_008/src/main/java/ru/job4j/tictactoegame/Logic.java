package ru.job4j.tictactoegame;

public interface Logic {
    /**
     * Method checks if the cell is empty.
     *
     * @param x number line on board.
     * @param y number column on board.
     * @return true - cell can be filled with player symbol.
     */
    boolean isValidCell(int x, int y);

    /**
     * Method checks for empty cells in the board.
     *
     *  @return true - board has empty cell.
     */
    boolean isFreeCell();

    /**
     * Method checks winning combination on board.
     *
     * @param symbol symbol of gamer.
     * @return true - on the board is winning combination.
     */
    boolean checkCombination(String symbol);
}
