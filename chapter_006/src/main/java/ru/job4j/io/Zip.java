package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Класс позволяет получить архив файлов с сохранением структуры папок.
 * При запуске в качестве Program arguments использована следующая строка:
 * -d c:/projects/job4j/chapter_006/src/main/java/tmpdir -e *.html -o project.zip
 */
public class Zip {
    /**
     * Метод осуществляет поиск файлов
     * @param root путь с которого необходимо начать поиск
     * @param ext файлы которые необходимо исключить
     * @return Список файлов
     */
    public List<File> seekBy(String root, List<String> ext) {
        Search search = new Search();
        return search.defineExtension(root, ext);
    }

    /**
     * Метод позволяет получить архив в формате Zip
     * @param sources Список исходных файлов
     * @param target Файл после упаковки в формате zip
     */
    public void pack(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Args args1 = new Args(args);
        Zip zip = new Zip();
        zip.pack(zip.seekBy(args1.directory(), List.of(args1.exclude())),
                new File(args1.output()));
    }
}
