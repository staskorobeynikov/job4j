package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();
    public void add(Person person) {
        this.persons.add(person);
    }
    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска
     * @return Список подошедших пользователей
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if ((person.getName()).contains(key)) {
                result.add(person);
            }
            if ((person.getSurname()).contains(key)) {
                result.add(person);
            }
            if ((person.getAddress()).contains(key)) {
                result.add(person);
            }
            if ((person.getPhone()).contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
