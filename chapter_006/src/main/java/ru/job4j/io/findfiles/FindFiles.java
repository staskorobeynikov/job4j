package ru.job4j.io.findfiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Класс осуществляет поиск файла(-ов) в соответствии с заданными условиями.
 *
 * @author STAS KOROBEYNIKOV
 * @since 01.01.2020
 */
public class FindFiles {
    /**
     * Метод предназначен для поиска файлов в соответствии с описанием, которые метод получает из
     * метода main в виде String[] args.
     */
    private List<File> seekBy(String[] info) {
        List<File> result = new ArrayList<>();
        Search search = new Search();
        Args argsFind = new Args(info);
        argsFind.init();
        if (argsFind.getInfo().containsKey("-m")) {
            result = search.searchByMask(argsFind.getDirectory(),
                    List.of(argsFind.getName()));
        }
        if (argsFind.getInfo().containsKey("-f")) {
            result = search.searchByName(argsFind.getDirectory(), argsFind.getName());
        }
        return result;
    }

    /**
     * Метод предназначен для валидации входных ключей.
     * @return true - информация введена корректно, произойдет запуск программы.
     */
    public boolean validate(String[] valid) {
        boolean result = true;
        Args argas = new Args(valid);
        argas.init();
        Map<String, String> validInfo = argas.getInfo();
        if (valid.length == 0) {
            System.out.println("Вы не ввели значения для поиска");
            System.out.println("Перезапустите в консоли с помощью команды следующего формата: "
                    + "java -jar find.jar -d |...| -n |...| -m -o |...|");
            System.out.println("-d - директория, в которой начинать поиск.\n"
                    + "-n - имя файла, маска, либо регулярное выражение.\n"
                    + "-m - искать по маске, либо -f - полное совпадение имени. "
                    + "-r регулярное выражение.\n"
                    + "-o - результат записать в файл.");
            System.out.println("Или укажите Program Arguments в формате: "
                    + "-d |...| -n |...| -m -o |...|");
            result = false;
        }
        if (valid.length != 0 && valid.length < 7) {
            if (validInfo.containsKey("-n") && validInfo.get("-n") == null) {
                System.out.println("Не указано имя, маска или регулярное значение");
            } else if (!validInfo.containsKey("-n")) {
                System.out.println("Не указан блок -n. "
                        + "Необходимо добавить в формате -n имя_файла");
            }
            if (!validInfo.containsKey("-m") && !validInfo.containsKey("-f")
                    && !validInfo.containsKey("-r")) {
                System.out.println("Не указан характер поиска."
                        + " Для поиска по маске - укажите -m."
                        + " Для поиска по имени с полным совпадением - укажите -f");
            }
            if (validInfo.containsKey("-d") && validInfo.get("-d") == null) {
                System.out.println("Не указана директория, в которой начать поиск");
            } else if (!validInfo.containsKey("-d")) {
                System.out.println("Не указан блок -d. "
                        + "Необходимо добавить в формате -d имя_директории");
            }
            if (validInfo.containsKey("-o") && validInfo.get("-o") == null) {
                System.out.println("Вы не указали имя файла, в который необходимо записать "
                        + "результат поиска");
            } else if (!validInfo.containsKey("-o")) {
                System.out.println("Не указан блок -o. "
                        + "Необходимо добавить в формате -o имя_файла.расширение");
            }
            result = false;
        }
        return result;
    }

    /**
     * Метод записывает результаты поиска в файл.
     */
    private void find(List<File> sources, File target) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(target))) {
            for (File source : sources) {
                bw.write(String.format("%s%s", source.getName(), System.lineSeparator()));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Запуск программы производился со следующими параметрами:
     * -d c:/projects/job4j -n *.txt -m -o log.txt
     */
    public static void main(String[] args) {
        FindFiles ff = new FindFiles();
        if (ff.validate(args)) {
            Args args1 = new Args(args);
            args1.init();
            ff.find(ff.seekBy(args), new File(args1.getOutput()));
            System.out.println("Выполнено успешно!");
        }
    }
}
