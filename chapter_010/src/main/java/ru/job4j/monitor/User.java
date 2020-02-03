package ru.job4j.monitor;

import java.util.Objects;

public class User {
    private int id;
    private int amount;

    User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    int getId() {
        return id;
    }

    int getAmount() {
        return amount;
    }

    void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                && amount == user.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }

    @Override
    public String toString() {
        return String.format("User: id=%s, amount=%s.", id, amount);
    }
}
