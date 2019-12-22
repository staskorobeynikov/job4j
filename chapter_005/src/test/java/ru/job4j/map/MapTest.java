package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    @Test
    public void hashMapTest() {
        Map<User, Object> map = new HashMap<>();
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, 1988);
        calendar.set(Calendar.MONTH, 10);
        calendar.set(Calendar.DATE, 17);
        User user1 = new User("Stas", 0, calendar);
        User user2 = new User("Stas", 0, calendar);
        map.put(user1, user1);
        map.put(user2, user2);
        System.out.println(map);
    }
}
