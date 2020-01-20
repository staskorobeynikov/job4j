package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TextReportTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenGenerate() {
        TextReport textReport = new TextReport();

        String result = textReport.generate("name", "body");

        assertThat(result, is(String.format("name%sbody", LN)));
    }
}