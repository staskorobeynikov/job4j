package ru.job4j.io.findfiles;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс интерпретирует информацию, которую программа получает из раздела Program
 * arguments
 *
 * @author STAS KOROBEYNIKOV
 * @since 01.01.2020
 */
public class Args {
    private Map<String, String> info = new HashMap<>();
    private final String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public void init() {
        for (int i = 0; i < args.length; i++) {
            String key;
            String value = null;
            int index;
            if (args[i].startsWith("-")) {
                key = args[i];
                index = i;
                if (index + 1 < args.length && !(args[index + 1].startsWith("-"))) {
                    value = args[i + 1];
                }
                info.put(key, value);
            }
        }
    }

    /**
     * Получение пути к папке, в которой необходимо осуществить поиск.
     */
    public String getDirectory() {
        return info.get("-d");
    }

    /**
     * Получение имени файла, в который необходимо записать информацию о
     * найденном(-ых) файле(-ах).
     */
    public String getOutput() {
        return info.get("-o");
    }

    /**
     * Получение критерия поиска.
     */
    public String getName() {
        String result = "";
        if (info.containsKey("-m")) {
            result = info.get("-n").replaceFirst("\\*.", "");
        }
        if (info.containsKey("-f")) {
            result = info.get("-n");
        }
        return result;
    }

    public Map<String, String> getInfo() {
        return this.info;
    }
}
