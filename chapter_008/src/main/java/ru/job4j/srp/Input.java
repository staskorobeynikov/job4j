package ru.job4j.srp;

/**
 * Interface for input stream.
 */
public interface Input {

    /**
     * Method determines data for calculator.
     *
     * @param question info for user.
     * @return String.
     */
    String askStr(String question);

    /**
     * Method determines data for calculation in calculator.
     *
     * @param question info for user.
     * @return Double for calculator operation.
     */
    double askDouble(String question);

    /**
     * Method determines the action.
     *
     * @param question info for user.
     * @param max Number of actions.
     * @return The sequence number of the action.
     */
    int askInt(String question, int max);
}
