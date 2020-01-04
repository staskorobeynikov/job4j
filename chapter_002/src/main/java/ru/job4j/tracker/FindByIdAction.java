package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by ID ===";
    }

    @Override
    public boolean execute(Input input, ITracker tracker, Consumer<String> output) {
        String id = input.askStr("Enter ID: ");
        Item itemById = tracker.findById(id);
        if (itemById != null) {
            output.accept(String.format("Name: %s| Id: %s",
                    itemById.getName(), itemById.getId()));
        } else {
            output.accept(String.format("Заявка по id %s не найдена", id));
        }
        return true;
    }
}
