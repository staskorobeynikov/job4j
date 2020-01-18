package ru.job4j.parser;

import java.sql.Timestamp;
import java.util.Set;

public interface Store {

    void addVacancies(Set<Vacancy> vacancies);

    Set<Timestamp> getSetDateCreate();
}
