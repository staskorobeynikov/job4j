package ru.job4j.tictactoegame;

public class ValidateInput implements Input {
    /**
     * Input arguments.
     */
    private final Input input;

    ValidateInput(Input input) {
        this.input = input;
    }

    /**
     *
     * @param question info for user.
     * @return String format for game.
     */
    @Override
    public String askString(String question) {
        return input.askString(question);
    }

    /**
     * @param question Coordinates figure.
     * @param max playing field size.
     * @return valid Integer format for game.
     */
    @Override
    public int askInt(String question, int max) {
        boolean invalid = true;
        int result = -1;
        do {
            try {
                result = input.askInt(question, max);
                invalid = false;
            } catch (IllegalStateException ise) {
                System.out.println(String.format("Please enter number between 1 and %s.", max));
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return result;
    }
}
