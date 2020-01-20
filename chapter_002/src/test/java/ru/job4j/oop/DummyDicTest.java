package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DummyDicTest {

    @Test
    public void whenTestMethodEngToRus() {
        DummyDic dummyDic = new DummyDic();
        String translate = "Inheritance";

        String result = dummyDic.engToRus(translate);

        assertThat(result, is("Неизвестное слово. Inheritance"));
    }
}