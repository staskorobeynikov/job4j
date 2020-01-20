package ru.job4j.oop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestMusicMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Student student = new Student();
        student.music("I believe I can fly");

        String expect = String.format("I can sign a song : I believe I can fly%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenTestSongMethod() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Student student = new Student();
        student.song();

        String expect = String.format("I believe I can fly%s", LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}