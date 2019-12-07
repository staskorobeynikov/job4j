package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by ID ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID: ");
        Item itemById = tracker.findById(id);
        if (itemById != null) {
            System.out.print("ID: " + itemById.getId() + "; ");
            System.out.println("Name: " + itemById.getName());
        } else {
            System.out.println("Заявка по id " + id + " не найдена");
        }
        return true;
    }
}
