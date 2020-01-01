package ru.job4j.io.findfiles;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindFilesTest {
    private static final String LN = System.lineSeparator();
    private final PrintStream def = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }
    @After
    public void backOutput() {
        System.setOut(def);
    }

    @Test
    public void whenArgsCorrectInfo() {
        String[] info = new String[]{"-d", "c:/", "-n", "*.txt", "-m", "-o", "log.txt"};
        FindFiles ff = new FindFiles();
        ff.validate(info);
        String expect = "";
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenEmptyArgsArray() {
        String[] info = new String[]{};
        FindFiles ff = new FindFiles();
        ff.validate(info);
        String expect = String.format("Вы не ввели значения для поиска%s"
                + "Перезапустите в консоли с помощью команды следующего формата: "
                + "java -jar find.jar -d |...| -n |...| -m -o |...|%s"
                + "-d - директория, в которой начинать поиск.\n"
                + "-n - имя файла, маска, либо регулярное выражение.\n"
                + "-m - искать по маске, либо -f - полное совпадение имени. -r регулярное выражение.\n"
                + "-o - результат записать в файл.%s"
                + "Или укажите Program Arguments в формате: -d |...| -n |...| -m -o |...|%s", LN, LN, LN, LN);
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenArgsDontHaveNameFile() {
        String[] info = new String[]{"-d", "c:/", "-n", "-m", "-o", "log.txt"};
        FindFiles ff = new FindFiles();
        ff.validate(info);
        String expect = String.format("Не указано имя, маска или регулярное значение%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenArgsDontHaveBlockForName() {
        String[] info = new String[]{"-d", "c:/", "-m", "-o", "log.txt"};
        FindFiles ff = new FindFiles();
        ff.validate(info);
        String expect = String.format("Не указан блок -n. Необходимо добавить в формате -n имя_файла%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenCheckArgsThenDontHaveNameDirectory() {
        String[] info = new String[]{"-d", "-n", "*.txt", "-m", "-o", "log.txt"};
        FindFiles ff = new FindFiles();
        ff.validate(info);
        String expect = String.format("Не указана директория, в которой начать поиск%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenCheckArgsThenDontHaveNameDirectoryField() {
        String[] info = new String[]{"-n", "*.txt", "-m", "-o", "log.txt"};
        FindFiles ff = new FindFiles();
        ff.validate(info);
        String expect = String.format("Не указан блок -d. Необходимо добавить в формате -d имя_директории%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenCheckArgsThenDontHaveNameFileOutput() {
        String[] info = new String[]{"-d", "c:/", "-n", "*.txt", "-m", "-o"};
        FindFiles ff = new FindFiles();
        ff.validate(info);
        String expect = String.format("Вы не указали имя файла, в который необходимо записать "
                + "результат поиска%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenCheckArgsThenDontHaveFileOutputField() {
        String[] info = new String[]{"-d", "c:/", "-n", "*.txt", "-m"};
        FindFiles ff = new FindFiles();
        ff.validate(info);
        String expect = String.format("Не указан блок -o. Необходимо добавить в "
                + "формате -o имя_файла.расширение%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenCheckArgsThenDontHaveCharacterSearchField() {
        String[] info = new String[]{"-d", "c:/", "-n", "*.txt", "-o", "log.txt"};
        FindFiles ff = new FindFiles();
        ff.validate(info);
        String expect = String.format("Не указан характер поиска. Для поиска по маске - укажите -m. "
                + "Для поиска по имени с полным совпадением - укажите -f%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
    }
}