package ru.job4j.sort;

import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(@NotNull User o) {
        int result = 0;
        if (this.name == o.getName()) {
            result = age - o.getAge();
        } else {
            result = name.compareTo(o.getName());
        }
        return result;
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
        return age == user.age
                &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "name = '" + name + '\''
                + ", age = " + age;
    }
}
