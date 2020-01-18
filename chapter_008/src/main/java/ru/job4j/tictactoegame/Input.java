package ru.job4j.tictactoegame;

public interface Input {
    /**
     * Method for receiving info from player in format String.
     *
     * @param question info for user.
     * @return String.
     */
    String askString(String question);

    /**
     * Method for receiving info from player in format Integer.
     *
     * @param question Coordinates figure.
     * @param max playing field size.
     * @return coordinate x or y.
     */
    int askInt(String question, int max);
}
