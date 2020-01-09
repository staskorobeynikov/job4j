package ru.job4j.srp;

import java.util.Scanner;

/**
 * Class for console input.
 */
public class ConsoleInput implements Input {
    /**
     * Input stream data from console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Console input for to get string.
     *
     * @param question info for user.
     * @return result user input.
     */
    @Override
    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Console input for to get double.
     *
     * @param question info for user.
     * @return User input for calculate operation.
     */
    @Override
    public double askDouble(String question) {
        return Double.parseDouble(askStr(question));
    }

    /**
     *
     * @param question info for user.
     * @param max Number of actions.
     * @return User input to select calculator operation.
     */
    @Override
    public int askInt(String question, int max) {
        int select = Integer.parseInt(askStr(question));
        if (select < 0 || select >= max) {
            throw new IllegalStateException(String.format("Out of about %s > [0, %s]",
                    select, max));
        }
        return select;
    }
}
