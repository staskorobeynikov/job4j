package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all Items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        tracker.findAll();
        for (Item item : tracker.findAll()) {
            System.out.print("ID: " + item.getId() + "; ");
            System.out.println("Name: " + item.getName());
        }
        return true;
    }
}
