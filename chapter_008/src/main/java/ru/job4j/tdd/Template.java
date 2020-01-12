package ru.job4j.tdd;

import java.util.Map;

public interface Template {
    /**
     * Method generates String with template by keys-value.
     *
     * @param template if template contains key, then key replaced by value from data map.
     * @param data map with template keys and values for replace in template.
     * @return generated String.
     */
    String generate(String template, Map<String, String> data) throws Exception;
}
