package ru.job4j.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public static HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<Integer, User>();
        for (User users : list) {
            int setId = users.getId();
            map.put(setId, users);
        }
        return map;
    }
    public static void main(String[] args) {
        List<User> listUsers = new ArrayList<>();
        listUsers.add(new User(1, "Stas", "Minsk"));
        listUsers.add(new User(2, "Petr", "Bryansk"));
        listUsers.add(new User(3, "Igor", "Brest"));
        HashMap<Integer, User> result = UserConvert.process(listUsers);
        System.out.println(result);
    }
}
