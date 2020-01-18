package ru.job4j.tictactoegame;

public interface Gamer {
    /**
     * Method set name for gamer.
     *
     * @return String name gamer.
     */
    String getName();

    /**
     * Method set number line for gamer.
     *
     * @param input input parameters.
     * @param field playing field.
     * @return int number line for gamer.
     */
    int getNumberLine(Input input, Field field);

    /**
     * Method set number column for gamer.
     *
     * @param input input parameters.
     * @param field playing field.
     * @return int number column for gamer.
     */
    int getNumberColumn(Input input, Field field);

    /**
     * Method set symbol for gamer.
     *
     * @return String symbol for gamer.
     */
    String setUseSymbol();
}
