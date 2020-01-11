package ru.job4j.isp;

import java.util.Arrays;
import java.util.List;

public class StartMenu {
    public static void main(String[] args) {
        Item item = new SimpleItem("Task 1");
        Item item1 = new SimpleItem("Task 1.1");
        Item item2 = new SimpleItem("Task 1.1.1");
        Item item3 = new SimpleItem("Task 1.1.2");
        Item item4 = new SimpleItem("Task 1.2");
        List<Item> list = Arrays.asList(item2, item3);
        item.add(item1);
        item.add(item4);
        item1.addItems(list);
        Menu menu = new SimpleMenu();
        menu.add(item);
        menu.show();

    }
}
