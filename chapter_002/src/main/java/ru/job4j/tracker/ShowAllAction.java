package ru.job4j.tracker;

import java.util.function.Consumer;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all Items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        tracker.findAll();
        for (Item item : tracker.findAll()) {
            output.accept(String.format("Name: %s| Id: %s",
                    item.getName(), item.getId()));
        }
        return true;
    }
}
