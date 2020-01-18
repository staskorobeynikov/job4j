package ru.job4j.tictactoegame;

import java.util.Random;

public class Computer implements Gamer {
    /**
     * Random for generate random numbers for use gamer Computer.
     */
    private final Random random = new Random();

    /**
     * Method set name for Computer.
     *
     * @return String name Computer.
     */
    @Override
    public String getName() {
        return "Computer";
    }

    /**
     * Method set number line for Computer.
     *
     * @param input input parameters.
     * @param field playing field.
     * @return int number line for Computer.
     */
    @Override
    public int getNumberLine(Input input, Field field) {
        return random.nextInt(field.getSize()) + 1;
    }

    /**
     * Method set number column for Computer.
     *
     * @param input input parameters.
     * @param field playing field.
     * @return int number column for Computer.
     */
    @Override
    public int getNumberColumn(Input input, Field field) {
        return random.nextInt(field.getSize()) + 1;
    }

    /**
     * Method set symbol for Computer.
     *
     * @return String symbol for Computer.
     */
    @Override
    public String setUseSymbol() {
        return "O";
    }
}
