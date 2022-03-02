package ru.job4j.ex;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactRecTest {
    @Test
    public void whenTestMethodCalc() {
        FactRec factRec = new FactRec();

        int result = factRec.calc(4);

        assertThat(result, is(24));
    }
}