package ru.job4j.io;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

/**
 * Класс позволяет получить список файлов в каталоге
 *
 * @author STAS KOROBEYNIKOV
 * @since 27.12.2019
 */
public class Search {
    private List<File> list = new ArrayList<>();
    private Queue<File> data = new LinkedList<>();

    /**
     * Метод позволяет получить содержимое папок
     * @param parent Путь до каталога, с которого нужно осуществить поиск
     * @param predicate Условие для проверки
     * @return Список содержимого папки в виде массива
     */
    public List<File> files(String parent, Predicate<File> predicate) {
        File fileParent = new File(parent);
        data.offer(fileParent);
        while (!data.isEmpty()) {
            File e = data.poll();
            for (File file : Objects.requireNonNull(e.listFiles())) {
                if (file.isDirectory()) {
                    data.offer(file);
                } else {
                    if (predicate.test(file)) {
                        System.out.println(file.getName());
                        list.add(file);
                    }
                }
            }
        }
        return list;
    }

    public List<File> defineExtension(String parent, List<String> exts) {
        return files(parent, (file) -> exts.contains(file.getName().split("\\.")[1]));
    }
}
