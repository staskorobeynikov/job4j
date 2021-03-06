package ru.job4j.inheritance;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportUsageTest {

    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestConsoleOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        ReportUsage.main(new String[0]);

        String expect = String.format(
                "<h1>Report's name</h1><br/><span>Report's body</span>%s%s"
                        + "Report's name%s"
                        + "Report's body%s%s"
                        + "{%s%s"
                        + "name : Report's name,%s"
                        + "body : Report's body%s%s"
                        + "}%s",
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN,
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}