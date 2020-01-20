package ru.job4j.parser;

public interface Config {

    void init();

    String getProperty(String key);
}
