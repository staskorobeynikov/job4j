package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingleInnerClass {
    private TrackerSingleInnerClass() {
    }

    public static TrackerSingleInnerClass getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingleInnerClass INSTANCE = new TrackerSingleInnerClass();
    }

    public static void main(String[] args) {
        TrackerSingleInnerClass tracker = TrackerSingleInnerClass.getInstance();
    }
}
