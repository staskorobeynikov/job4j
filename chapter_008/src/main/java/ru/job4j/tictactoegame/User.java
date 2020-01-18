package ru.job4j.tictactoegame;

public class User implements Gamer {
    /**
     * Method set name for User.
     *
     * @return String name User.
     */
    @Override
    public String getName() {
        return "User";
    }

    /**
     * Method set number line for User.
     *
     * @param input input parameters.
     * @param field playing field.
     * @return int number line for User.
     */
    @Override
    public int getNumberLine(Input input, Field field) {
        return input.askInt("Enter number line: ", field.getSize());
    }

    /**
     * Method set number column for User.
     *
     * @param input input parameters.
     * @param field playing field.
     * @return int number column for User.
     */
    @Override
    public int getNumberColumn(Input input, Field field) {
        return input.askInt("Enter number column: ", field.getSize());
    }

    /**
     * Method set symbol for User.
     *
     * @return String symbol for User.
     */
    @Override
    public String setUseSymbol() {
        return "X";
    }
}
