package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(input.askStr(""));
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = input.askStr("");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all Items ===");
                tracker.findAll();
                for (Item item : tracker.findAll()) {
                    System.out.print("ID: " + item.getId() + "; ");
                    System.out.println("Name: " + item.getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit an Item ===");
                String id = input.askStr("Enter ID: ");
                Item edit = tracker.findById(id);
                if (edit != null) {
                    String name = input.askStr("Enter name: ");
                    edit.setName(name);
                } else {
                    System.out.println("Заявка по id " + id + " не найдена");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ===");
                String id = input.askStr("Enter ID: ");
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена");
                } else {
                    System.out.println("Заявка по id " + id + " не найдена");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by ID ===");
                String id = input.askStr("Enter ID: ");
                Item itemById = tracker.findById(id);
                if (itemById != null) {
                    System.out.print("ID: " + itemById.getId() + "; ");
                    System.out.println("Name: " + itemById.getName());
                } else {
                    System.out.println("Заявка по id " + id + " не найдена");
                }
                tracker.findById(id);
            } else if (select == 5) {
                System.out.println("=== Find Items by Name ===");
                String name = input.askStr("Enter name: ");
                Item[] itemsByName = tracker.findByName(name);
                if (itemsByName[0] != null) {
                    for (Item item : itemsByName) {
                        System.out.print("ID: " + item.getId() + "; ");
                        System.out.println("Name: " + item.getName());
                    }
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }
    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
