package ru.job4j.ex;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactRecTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenTestMethodCalc() {
        FactRec factRec = new FactRec();

        int result = factRec.calc(4);

        assertThat(result, is(24));
    }

    @Test
    public void main() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        String[] args = new String[0];
        FactRec.main(args);

        String expect = String.format(
                "Factorial number 4 is 24.%s",
                LN);
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}