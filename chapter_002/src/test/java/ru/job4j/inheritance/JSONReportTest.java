package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JSONReportTest {

    @Test
    public void whenGenerate() {
        JSONReport jsonReport = new JSONReport();

        String result = jsonReport.generate("name", "body");

        assertThat(result, is("{\n\nname : name,\nbody : body\n\n}"));
    }
}