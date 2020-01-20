package ru.job4j.inheritance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HtmlReportTest {

    @Test
    public void whenGenerate() {
        HtmlReport htmlReport = new HtmlReport();

        String result = htmlReport.generate("name", "body");

        assertThat(result, is("<h1>name</h1><br/><span>body</span>"));
    }
}