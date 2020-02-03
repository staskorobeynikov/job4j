package ru.job4j.monitor;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
class UserStore {
    @GuardedBy("this")
    private Map<Integer, User> store = new HashMap<>();

    synchronized boolean add(User user) {
        store.putIfAbsent(user.getId(), user);
        return store.containsValue(user);
    }

    synchronized boolean update(User user) {
        User result = store.put(user.getId(), user);
        return result != null;
    }

    synchronized boolean delete(User user) {
        return store.remove(user.getId(), user);
    }

    synchronized void transfer(int fromId, int toId, int amount) {
        User fromUser = store.get(fromId);
        User toUser = store.get(toId);
        if ((fromUser != null && toUser != null) && fromUser.getAmount() >= amount) {
            fromUser.setAmount(fromUser.getAmount() - amount);
            toUser.setAmount(toUser.getAmount() + amount);
        }
    }
}
