package ru.job4j.garbagecollector;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("User: %s.", name);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }
}
