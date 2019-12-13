package ru.job4j.tracker;

import java.util.function.Consumer;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "=== Exit ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output)  {
        return false;
    }
}
