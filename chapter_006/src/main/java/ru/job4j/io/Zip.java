package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.Map;
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

    /**
     * Метод предназначен для валидации входных параметров.
     * @return true - входные параметры введены правильно, программа запустится.
     */
    public boolean validate(String[] valid) {
        boolean result = true;
        Args argsValid = new Args(valid);
        Map<String, String> validInfo = argsValid.getInfo();
        if (valid.length == 0) {
            System.out.println("Вы не ввели значения дял поиска."
                    + "Укажите в следующем формате: -d |...| -e |...| -o |...|, где"
                    + "-d - директория, которую необходимо архивировать, -e - расширение файлов которые необходимо"
                    + "исключить, -o - имя файла-архива с расширением zip");
            result = false;
        }
        if (valid.length != 0 && valid.length < 6) {
            if (validInfo.containsKey("-d") && validInfo.get("-d") == null) {
                System.out.println("Не указана директория, которую необходимо архивировать.");
            } else if (!validInfo.containsKey("-d")) {
                System.out.println("Не указан блок -d."
                        + "Необходимо указать в формате -d путь_к_директории");
            }
            if (validInfo.containsKey("-e") && validInfo.get("-e") == null) {
                System.out.println("Не указано расширение файлов, которые необходимо исключить.");
            } else if (!validInfo.containsKey("-e")) {
                System.out.println("Не указан блок -e."
                        + "Необходимо указать в формате -e *.расширение_файла");
            }
            if (validInfo.containsKey("-o") && validInfo.get("-o") == null) {
                System.out.println("Не указано имя архив-файла.");
            } else if (!validInfo.containsKey("-o")) {
                System.out.println("Не указан блок -o."
                        + "Необходимо указать в формате -o имя_файла.zip");
            }
            result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        Zip zip = new Zip();
        if (zip.validate(args)) {
            Args args1 = new Args(args);
            zip.pack(zip.seekBy(args1.directory(), List.of(args1.exclude())),
                    new File(args1.output()));
            System.out.println("Выполнено успешно.");
        }
    }
}
