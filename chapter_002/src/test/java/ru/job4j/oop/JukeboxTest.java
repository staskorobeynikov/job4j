package ru.job4j.oop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JukeboxTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenMusicPositionFirst() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Jukebox jukebox = new Jukebox();
        jukebox.music(1);

        String expect = String.format("Пусть бегут неуклюже пешеходы по лужам\n"
                + "А вода по асфальту рекой\n"
                + "И не ясно прохожим в этот день непогожий\n"
                + "Почему я веселый такой%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenMusicPositionSecond() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Jukebox jukebox = new Jukebox();
        jukebox.music(2);

        String expect = String.format(
                "Спят усталые игрушки, книжки спят.\n"
                        + "Одеяла и подушки ждут ребят.\n"
                        + "Даже сказка спать ложится,\n"
                        + "Чтобы ночью нам присниться.\n"
                        + "Ты ей пожелай:\n"
                        + "Баю-бай.%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenMusicPositionAnyNumber() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Jukebox jukebox = new Jukebox();
        jukebox.music(100);

        String expect = String.format("Песня не найдена%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}