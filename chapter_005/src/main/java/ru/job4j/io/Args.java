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
        for (int i = 0; i < args.length; i += 2) {
            info.put(args[i], args[i + 1]);
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
}
