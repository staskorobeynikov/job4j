package ru.job4j.parser;

import java.sql.Timestamp;
import java.util.Set;

public interface Parser {

    Set<Vacancy> parse(String url, Set<Timestamp> setDate);
}
