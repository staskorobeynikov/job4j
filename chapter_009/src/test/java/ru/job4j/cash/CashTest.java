package ru.job4j.cash;

import org.junit.Test;

import java.lang.ref.SoftReference;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CashTest {

    @Test
    public void when() {
        Cash cash = new Cash();
        cash.add("name", "test");

        SoftReference result = cash.get("name");

        assertThat(result.get(), is("test"));
    }

}