package ru.job4j.statistic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        int amountKey = 0;
        Map<Integer, String> list = new HashMap<>();
        for (User user : previous) {
            list.put(user.getId(), user.getName());
        }
        if (!list.isEmpty() && current.size() == 0) {
            info.deleted = previous.size();
        }
        for (User user : current) {
            String temp = list.get(user.getId());
            if (temp == null) {
                info.added++;
            }
            if (temp != null && !temp.equals(user.getName())) {
                info.changed++;
            }
            if (list.containsKey(user.getId())) {
                amountKey++;
            }
        }
        info.deleted = list.size() - amountKey;
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
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
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}
