package ru.job4j.tictactoegame;

import java.util.Scanner;

public class ConsoleInput implements Input {
    /**
     * Scanner for answers player from the console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * @param question info for user.
     * @return String format for game.
     */
    @Override
    public String askString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * @param question Coordinates figure.
     * @param max playing field size.
     * @return Integer format for game.
     */
    @Override
    public int askInt(String question, int max) {
        int result = Integer.parseInt(askString(question));
        if (result < 1 || result > max) {
            throw new IllegalStateException(
                    String.format("Out of about %s > [1, %s]", result, max)
            );
        }
        return result;
    }
}
