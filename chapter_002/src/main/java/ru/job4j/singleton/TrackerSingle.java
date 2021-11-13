package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public enum TrackerSingle {
    INSTANCE;
    public Item add(Item model) {
        return model;
    }

    public static void main(String[]args) {
        TrackerSingle tracker = TrackerSingle.INSTANCE;
    }
}
