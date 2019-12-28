package ru.job4j.io;

import java.io.File;
import java.util.*;

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
     * @param exts Расширение файлов, которые необходимо получить
     * @return Список содержимого папки в виде массива
     */
    public List<File> files(String parent, List<String> exts) {
        File fileParent = new File(parent);
        data.offer(fileParent);
        while (!data.isEmpty()) {
            File e = data.poll();
            for (File file : Objects.requireNonNull(e.listFiles())) {
                if (file.isDirectory()) {
                    data.offer(file);
                } else {
                    if (defineExtension(file, exts)) {
                        System.out.println(file.getName());
                        list.add(file);
                    }
                }
            }
        }
        return list;
    }

    private boolean defineExtension(File file, List<String> exts) {
        boolean result = false;
        String validate = file.getName().split("\\.")[1];
        if (exts.contains(validate)) {
            result = true;
        }
        return result;
    }
}
