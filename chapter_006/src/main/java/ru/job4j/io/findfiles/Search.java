package ru.job4j.io.findfiles;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

/**
 * Класс позволяет получить список файлов в каталоге
 *
 * @author STAS KOROBEYNIKOV
 * @since 01.01.2020
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
            if (e.isDirectory()) {
                for (File el : Objects.requireNonNull(e.listFiles())) {
                    data.offer(el);
                }
            } else if (e.isFile() && e.getName().contains(".") && predicate.test(e)) {
                list.add(e);
            }
        }
        return list;
    }

    /**
     * Метод производит поиск по маске.
     * @param parent Путь к каталогу, с которого осуществляется поиск
     * @param extension расширение файла, который необходимо найти
     * @return Список файлов
     */
    public List<File> searchByMask(String parent, List<String> extension) {
        return files(parent, (file) -> extension.contains(file.getName().split("\\.")[1]));
    }

    /**
     * Метод производит поиск файда(-ов) по полному совпадению названия.
     * @param parent Путь к каталогу, с которого осуществляется поиск.
     * @param name Имя файла.
     * @return Список файлов.
     */
    public List<File> searchByName(String parent, String name) {
        return files(parent, (file) -> name.equals(file.getName().split("\\.")[0]));
    }
}
