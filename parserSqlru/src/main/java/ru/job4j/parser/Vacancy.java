package ru.job4j.parser;

import java.sql.Timestamp;
import java.util.Objects;

public class Vacancy {
    private final String name;
    private final String text;
    private final String link;
    private final Timestamp createDate;

    Vacancy(String name, String text, String link, Timestamp createDate) {
        this.name = name;
        this.text = text;
        this.link = link;
        this.createDate = createDate;
    }

    String getName() {
        return name;
    }

    String getText() {
        return text;
    }

    String getLink() {
        return link;
    }

    Timestamp getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return String.format("Vacancy{name: %s, text: %s, link: %s, createDate: %s}", name, text, link, createDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(name, vacancy.name)
                && Objects.equals(text, vacancy.text)
                && Objects.equals(link, vacancy.link)
                && Objects.equals(createDate, vacancy.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, text, link, createDate);
    }
}
