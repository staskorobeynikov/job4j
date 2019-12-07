package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }
    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all Items ===");
        tracker.findAll();
        for (Item item : tracker.findAll()) {
            System.out.print("ID: " + item.getId() + "; ");
            System.out.println("Name: " + item.getName());
        }
    }
    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit an Item ===");
        String id = input.askStr("Enter ID: ");
        String name = input.askStr("Enter name: ");
        Item itemReplace = new Item(name);
        if (tracker.replace(id, itemReplace)) {
            System.out.println("Заявка изменена");
        } else {
            System.out.println("Заявка по id " + id + " не найдена");
        }
    }
    public static void deteleItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ===");
        String id = input.askStr("Enter ID: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Заявка по id " + id + " не найдена");
        }
    }
    public static void findItemId (Input input, Tracker tracker) {
        System.out.println("=== Find Item by ID ===");
        String id = input.askStr("Enter ID: ");
        Item itemById = tracker.findById(id);
        if (itemById != null) {
            System.out.print("ID: " + itemById.getId() + "; ");
            System.out.println("Name: " + itemById.getName());
        } else {
            System.out.println("Заявка по id " + id + " не найдена");
        }
    }
    public static void findItemsName (Input input, Tracker tracker) {
        System.out.println("=== Find Items by Name ===");
        String name = input.askStr("Enter name: ");
        Item[] itemsByName = tracker.findByName(name);
        for (Item item : itemsByName) {
            System.out.print("ID: " + item.getId() + "; ");
            System.out.println("Name: " + item.getName());
        }
    }
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deteleItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemId(input, tracker);
            } else if (select == 5) {
                StartUI.findItemsName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }
    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all Items");
        System.out.println("2. Edit Item");
        System.out.println("3. Delete Item");
        System.out.println("4. Find Item by Id");
        System.out.println("5. Find Items by Name");
        System.out.println("6. Exit Program");
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
