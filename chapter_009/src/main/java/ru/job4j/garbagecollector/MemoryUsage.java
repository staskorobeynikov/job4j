package ru.job4j.garbagecollector;

import java.util.ArrayList;

public class MemoryUsage {

    public static void info() {
        int mb = 1024 * 1024;

        //Getting the runtime reference from system.
        Runtime runtime = Runtime.getRuntime();

        System.out.println("##### Heap utilization statistics [MB] ######");

        //Print used memory.
        System.out.println("Used Memory: "
                + (runtime.totalMemory() - runtime.freeMemory()) / mb);

        //Print free memory.
        System.out.println("Free memory: " + runtime.freeMemory() / mb);

        //Print total available memory.
        System.out.println("Total memory: " + runtime.totalMemory() / mb);

        //Print maximum available memory.
        System.out.println("Max memory: " + runtime.maxMemory() / mb);
    }

    public static void main(String[] args) {
        info();
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i < 100000000; i++) {
            users.add(new User("test" + i));
            System.out.println(i);
            //System.out.println(users.get(i - 1));
        }
        info();
    }
}
