package ru.job4j.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ZipTest {
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
    public void whenValidateIsTrue() {
        String[] valid = new String[]{"-d", "c:/projects", "-e", "*.html", "-o", "project.zip"};
        Zip zip = new Zip();
        zip.validate(valid);
        String expected = "";
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenDontSetDirectoryName() {
        String[] valid = new String[]{"-d", "-e", "*.html", "-o", "project.zip"};
        Zip zip = new Zip();
        zip.validate(valid);
        String expected = String.format("Не указана директория, которую необходимо архивировать.%s", LN);
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenDontSetDirectoryField() {
        String[] valid = new String[]{"-e", "*.html", "-o", "project.zip"};
        Zip zip = new Zip();
        zip.validate(valid);
        String expected = String.format("Не указан блок -d.Необходимо указать в "
                + "формате -d путь_к_директории%s", LN);
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenDontSetExtensionFile() {
        String[] valid = new String[]{"-d", "c:/projects", "-e", "-o", "project.zip"};
        Zip zip = new Zip();
        zip.validate(valid);
        String expected = String.format("Не указано расширение файлов, которые необходимо исключить.%s", LN);
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenDontSetExtensionFileField() {
        String[] valid = new String[]{"-d", "c:/projects", "-o", "project.zip"};
        Zip zip = new Zip();
        zip.validate(valid);
        String expected = String.format("Не указан блок -e.Необходимо указать "
                + "в формате -e *.расширение_файла%s", LN);
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenDontSetNameFileArchive() {
        String[] valid = new String[]{"-d", "c:/projects", "-e", "*.html", "-o"};
        Zip zip = new Zip();
        zip.validate(valid);
        String expected = String.format("Не указано имя архив-файла.%s", LN);
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenDontSetNameFileArchiveField() {
        String[] valid = new String[]{"-d", "c:/projects", "-e", "*.html"};
        Zip zip = new Zip();
        zip.validate(valid);
        String expected = String.format("Не указан блок -o.Необходимо указать в формате -o имя_файла.zip%s", LN);
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenDontSetNameFileArchiveField1() {
        String[] valid = new String[]{};
        Zip zip = new Zip();
        zip.validate(valid);
        String expected = String.format("Вы не ввели значения дял поиска.Укажите в "
                + "следующем формате: -d |...| -e |...| -o |...|, где-d - директория, "
                + "которую необходимо архивировать, -e - расширение файлов которые "
                + "необходимоисключить, -o - имя файла-архива с расширением zip%s", LN);
        assertThat(new String(out.toByteArray()), is(expected));
    }
}