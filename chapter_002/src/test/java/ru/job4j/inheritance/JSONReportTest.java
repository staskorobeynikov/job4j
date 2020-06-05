package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JSONReportTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void whenGenerate() {
        JSONReport jsonReport = new JSONReport();

        String result = jsonReport.generate("name", "body");

        String expected = String.format("{%s%sname : name,%sbody : body%s%s}", LN, LN, LN, LN, LN);

        assertThat(result, is(expected));
    }
}