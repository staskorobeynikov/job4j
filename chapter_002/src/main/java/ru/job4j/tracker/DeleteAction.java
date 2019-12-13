package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String id = input.askStr("Enter ID: ");
        if (tracker.delete(id)) {
            output.accept(String.format("Заявка по id %s удалена", id));
        } else {
            output.accept(String.format("Заявка по id %s не найдена", id));
        }
        return true;
    }
}
