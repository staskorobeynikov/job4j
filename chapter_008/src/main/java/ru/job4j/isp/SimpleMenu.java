package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class SimpleMenu implements Menu {

    private List<Item> list = new ArrayList<>();

    @Override
    public void show() {
        for (Item item : list) {
            item.show();
        }
    }

    @Override
    public void addItems(List<Item> items) {
        list.addAll(items);
    }

    @Override
    public void add(Item item) {
        list.add(item);
    }

    @Override
    public void execute(Input input) {
        for (Item item : list) {
            item.execute(input);
        }
    }
}
