package ru.job4j.exam;

import java.util.*;

/**
 * @author STAS KOROBEYNIKOV (stas.korobeynikov@mail.ru).
 * @since 19.02.2020.
 */
public class Post {

    private Map<String, Set<String>> store = new TreeMap<>();

    /**
     * Метод для парсинга строки списка email и внесения в хранилище store.
     *
     * @param list Map - каждому юзеру соответствует строка, содержащая emails, которые ему принадлежат.
     */
    void parseMap(HashMap<String, String> list) {
        for (String key : list.keySet()) {
            String value = list.get(key);
            String[] valueSplit = value.split(",");
            Set<String> emails = new HashSet<>(Arrays.asList(valueSplit));
            store.put(key, emails);
        }
    }

    /**
     * Метод позволяет исключить дубликаты email у разных пользователей.
     *
     * @return Map - пара User - Множество email, которые принадлежат этому пользователю.
     */
    Map<String, Set<String>> combine() {
        Map<String, Set<String>> result = new HashMap<>();
        Map<String, String> storeUniqueUser = new HashMap<>();
        for (String userName : store.keySet()) {
            String value = userName;
            for (String email : store.get(userName)) {
                if (storeUniqueUser.isEmpty()) {
                    break;
                }
                if (storeUniqueUser.containsKey(email)) {
                    value = storeUniqueUser.get(email);
                    break;
                }
            }
            for (String email : store.get(userName)) {
                storeUniqueUser.put(email, value);
            }
        }

        for (String email : storeUniqueUser.keySet()) {
            String value = storeUniqueUser.get(email);
            if (!result.containsKey(value)) {
                result.put(value, new HashSet<>());
            }
            if (result.containsKey(value)) {
                result.get(value).add(email);
            }
        }
        return result;
    }
}
