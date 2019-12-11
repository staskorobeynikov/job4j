package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Items by Name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> itemsByName = tracker.findByName(name);
        for (Item item : itemsByName) {
            System.out.print("ID: " + item.getId() + "; ");
            System.out.println("Name: " + item.getName());
        }
        return true;
    }
}
