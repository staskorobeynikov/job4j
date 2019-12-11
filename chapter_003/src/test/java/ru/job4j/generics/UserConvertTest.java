package ru.job4j.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenTestUserConvert() {
        List<User> listUsers = new ArrayList<>();
        User user = new User(1, "Stas", "Minsk");
        listUsers.add(user);
        HashMap<Integer, User> result = UserConvert.process(listUsers);
        HashMap<Integer, User> map = new HashMap<Integer, User>();
        map.put(user.getId(), user);
        HashMap<Integer, User> expect = map;
        assertThat(result, is(expect));
    }
}
