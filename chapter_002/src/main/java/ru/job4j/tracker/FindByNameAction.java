package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Items by Name ===";
    }

    @Override
    public boolean execute(Input input, ITracker tracker, Consumer<String> output) {
        String name = input.askStr("Enter name: ");
        List<Item> itemsByName = tracker.findByName(name);
        for (Item item : itemsByName) {
            output.accept(String.format("Name: %s| Id: %s", name, item.getId()));
        }
        return true;
    }
}
