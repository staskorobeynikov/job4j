package ru.job4j.pojo;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void whenGetFio() {
        Student student = new Student();
        student.setFio("Stas");

        String result = student.getFio();

        assertThat(result, is("Stas"));
    }

    @Test
    public void whenGetGroupNumber() {
        Student student = new Student();
        student.setGroupNumber("4");

        String result = student.getGroupNumber();

        assertThat(result, is("4"));
    }

    @Test
    public void whenGetEntered() {
        Student student = new Student();
        student.setEntered(new Date(1579543200000L));

        Date result = student.getEntered();

        assertThat(result, is(new Date(1579543200000L)));
    }
}