package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * @param task задача
     */
    public void put(Task task) {
        int i = 0;
        for (Task current : tasks) {
            if (task.getPriority() < current.getPriority()) {
                break;
            } else {
                i++;
            }
        }
        tasks.add(i, task);
    }
    public Task take() {
        return this.tasks.poll();
    }
}
