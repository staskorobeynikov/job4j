package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * @param task задача
     */
    public void put(Task task) {
        if (task.getPriority() > 1) {
            tasks.addLast(task);
        }
        if (task.getPriority() <= 1) {
            tasks.add(0, task);
        }
    }
    public Task take() {
        return this.tasks.poll();
    }
}
