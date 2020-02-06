package ru.job4j.nba;

import java.util.Objects;

public class Base {

    private final int id;

    private String name;

    private int version;

    Base(int id, String name, int version) {
        this.id = id;
        this.name = name;
        this.version = version;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getVersion() {
        return version;
    }

    void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return id == base.id
                && version == base.version
                && Objects.equals(name, base.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, version);
    }

    @Override
    public String toString() {
        return String.format("Base: id=%s, name=%s, version=%s", id, name, version);
    }
}
