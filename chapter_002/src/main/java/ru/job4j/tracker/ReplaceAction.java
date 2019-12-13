package ru.job4j.tracker;

import java.util.function.Consumer;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit an Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String id = input.askStr("Enter ID: ");
        String name = input.askStr("Enter name: ");
        Item itemReplace = new Item(name);
        if (tracker.replace(id, itemReplace)) {
            output.accept(String.format("Заявка по id %s изменена, присвоено имя %s",
                    id, name));
        } else {
            output.accept(String.format("Заявка по id %s не найдена", id));
        }
        return true;
    }
}
