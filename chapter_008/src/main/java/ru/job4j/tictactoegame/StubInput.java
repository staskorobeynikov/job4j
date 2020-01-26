package ru.job4j.tictactoegame;

import java.util.List;

/**
 * Class is stub for test.
 */
public class StubInput implements Input {
    /**
     * List contains user answers;
     */
    private final List<String> answers;
    /**
     * List index.
     */
    private int index = 0;

    public StubInput(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String askString(String question) {
        return answers.get(index++);
    }

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
