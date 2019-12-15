package ru.job4j.innovation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StudentTest {
    @Test
    public void whenFilteredList() {
        StudentCollect collect = new StudentCollect();
        Student st1 = new Student("Name1", 10);
        Student st2 = new Student("Name2", 20);
        Student st3 = new Student("Name3", 30);
        Student st4 = new Student("Name4", 40);
        Student st5 = new Student("Name5", 50);
        List<Student> students = new ArrayList<>(List.of(st1, st2, st3, st4, st5));
        students.add(3, null);
        students.add(5, null);
        List<Student> actual = collect.levelOf(students, 20);
        List<Student> expected = List.of(st5, st4, st3);
        assertThat(actual, is(expected));
    }
    @Test
    public void whenEmptyListAfterFilter() {
        StudentCollect collect = new StudentCollect();
        Student st1 = new Student("Name1", 10);
        Student st2 = new Student("Name2", 20);
        Student st3 = new Student("Name3", 30);
        Student st4 = new Student("Name4", 40);
        List<Student> students = new ArrayList<>(List.of(st1, st2, st3, st4));
        students.add(1, null);
        students.add(3, null);
        List<Student> actual = collect.levelOf(students, 40);
        List<Student> expected = new ArrayList<>();
        assertThat(actual, is(expected));
    }
    @Test
    public void whenEmptyList() {
        StudentCollect collect = new StudentCollect();
        List<Student> students = new ArrayList<>();
        students.add(null);
        students.add(null);
        students.add(null);
        students.add(null);
        students.add(null);
        students.add(null);
        List<Student> actual = collect.levelOf(students, 10);
        List<Student> expected = new ArrayList<>();
        assertThat(actual, is(expected));
    }
}
