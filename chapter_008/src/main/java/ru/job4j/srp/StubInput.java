package ru.job4j.srp;

import java.util.List;

/**
 * Class is stub input for tests.
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
    public String askStr(String question) {
        return answers.get(index++);
    }

    @Override
    public double askDouble(String question) {
        return Double.parseDouble(answers.get(index++));
    }

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
