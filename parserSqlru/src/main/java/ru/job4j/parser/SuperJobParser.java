package ru.job4j.parser;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class SuperJobParser implements Parser {

    @Override
    public Set<Vacancy> parse(String url, Set<Timestamp> setDate) {
        Set<Vacancy> result = new HashSet<>();
        if (url != null && setDate.isEmpty()) {
            result.add(new Vacancy(
                    getName(url),
                    getText(url),
                    url,
                    getCreateDate())
            );
        }
        return result;
    }

    private String getName(String url) {
        return String.format("Разработчик Java. %s", url);
    }

    private String getText(String url) {
        return String.format("Опыт промышленной разработки на Java от 3-х лет. %s", url);
    }

    protected Timestamp getCreateDate() {
        return Timestamp.valueOf(
                String.format(
                        "%s-%s-%s %s:%s:%s",
                        2020,
                        1,
                        23,
                        19,
                        20,
                        "00.0"
                )
        );
    }
}
