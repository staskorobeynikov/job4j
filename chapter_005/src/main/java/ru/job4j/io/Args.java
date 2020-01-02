package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Метод позволяет интерпретировать информацию, которую получает программа при запуске из
 * раздела Program arguments
 * В данном случае использована следующая строка:
 * -d c:/projects/job4j/chapter_006/src/main/java/tmpdir -e *.html -o project.zip
 */
public class Args {
    private Map<String, String> info = new HashMap<>();

    public Args(String[] args) {
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
     * Метод позволяет получить путь к папке, с которой необходимо осуществить поиск
     */
    public String directory() {
        return info.get("-d");
    }

    /**
     * Метод позволяет получить расширение файлов, которые необходимо исключить при создании
     * архива.
     */
    public String exclude() {
        return info.get("-e").replaceFirst("\\*.", "");
    }

    /**
     * Метод позволяет получить имя конечного файла после создания архива.
     */
    public String output() {
        return info.get("-o");
    }

    public Map<String, String> getInfo() {
        return this.info;
    }
}
