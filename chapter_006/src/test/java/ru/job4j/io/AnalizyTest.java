package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    @Test
    public void whenReadFileThenFindTwoPeriod() {
        String source = "./data/server";
        String target = "./data/unavailable.csv";
        new Analizy().unavailable(source, target);
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            assertThat(read.readLine(), is("10:57:01;10:59:01;"));
            assertThat(read.readLine(), is("11:01:02;11:02:02;"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}