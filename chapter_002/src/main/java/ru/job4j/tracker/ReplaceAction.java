package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit an Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID: ");
        String name = input.askStr("Enter name: ");
        Item itemReplace = new Item(name);
        if (tracker.replace(id, itemReplace)) {
            System.out.println("Заявка изменена");
        } else {
            System.out.println("Заявка по id " + id + " не найдена");
        }
        return true;
    }
}
