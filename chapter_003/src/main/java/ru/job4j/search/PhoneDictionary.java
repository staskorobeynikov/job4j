package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneDictionary {

    private List<Person> persons = new ArrayList<>();

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
        Predicate<Person> byName = p -> p.getName().contains(key);
        Predicate<Person> bySurname = p -> p.getSurname().contains(key);
        Predicate<Person> byAddress = p -> p.getAddress().contains(key);
        Predicate<Person> byPhone = p -> p.getPhone().contains(key);
        Predicate<Person> combine = byName.or(bySurname.or(byAddress.or(byPhone)));
        /*
        for (var person : persons) {
            if ((person.getName()).contains(key)
            || (person.getSurname()).contains(key)
            || (person.getAddress()).contains(key)
            || (person.getPhone()).contains(key)) {
                result.add(person);
            }
        }
        */
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
