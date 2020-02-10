package ru.job4j.exam;

import java.util.Set;

public class Student {

    private String name;
    private Set<String> units;

    public Student(String name, Set<String> units) {
        this.name = name;
        this.units = units;
    }

    String getName() {
        return name;
    }

    Set<String> getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return String.format("Student: name=%s, units=%s", name, units);
    }
}
