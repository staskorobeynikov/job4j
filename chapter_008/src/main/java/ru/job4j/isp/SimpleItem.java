package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class SimpleItem implements Item {
    private String name;

    private String prefix = "----";

    private List<Item> list = new ArrayList<>();

    public SimpleItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add(Item item) {
        list.add(item);
    }

    @Override
    public void addItems(List<Item> items) {
        for (Item item : items) {
            SimpleItem simpleItem = (SimpleItem) item;
            list.add(new SimpleItem(String.format("%s%s", prefix, simpleItem.getName())));
        }
    }

    @Override
    public void show() {
        System.out.println(name);
        if (!list.isEmpty()) {
            for (Item item : list) {
                SimpleItem simpleItem = (SimpleItem) item;
                simpleItem.setName(String.format("%s%s", prefix, simpleItem.getName()));
                item.show();
            }
        }
    }

    @Override
    public void execute(Input input) {
        System.out.println("Execute some action!!!");
    }
}
