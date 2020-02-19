package ru.job4j.exam;

import java.util.*;

/**
 * @author STAS KOROBEYNIKOV (stas.korobeynikov@mail.ru).
 * @since 19.02.2020.
 */
public class Post {

    /**
     * Метод позволяет исключить дубликаты email у разных пользователей.
     *
     * @param list Map - каждому юзеру соответствует строка, содержащая emails, которые относятся к нему.
     * @return Map - пара User - Множество email, которые принадлежат этому пользователю.
     */
    Map<String, Set<String>> combine(HashMap<String, String> list) {
        Map<String, Set<String>> store = new TreeMap<>();
        for (String key : list.keySet()) {
            String value = list.get(key);
            String[] valueSplit = value.split(",");
            Set<String> emails = new HashSet<>(Arrays.asList(valueSplit));
            store.put(key, emails);
        }

        Map<String, String> stringUserHashMap = new HashMap<>();
        for (String string : store.keySet()) {
            String value = string;
            for (String email : store.get(string)) {
                if (stringUserHashMap.isEmpty()) {
                    break;
                }
                if (stringUserHashMap.containsKey(email)) {
                    value = stringUserHashMap.get(email);
                    break;
                }
            }
            for (String email : store.get(string)) {
                stringUserHashMap.put(email, value);
            }
        }

        Map<String, Set<String>> stringSetHashMap = new HashMap<>();
        for (String email : stringUserHashMap.keySet()) {
            String value = stringUserHashMap.get(email);
            if (!stringSetHashMap.containsKey(value)) {
                stringSetHashMap.put(value, new HashSet<>());
            }
            if (stringSetHashMap.containsKey(value)) {
                stringSetHashMap.get(value).add(email);
            }
        }
        return stringSetHashMap;
    }
}
