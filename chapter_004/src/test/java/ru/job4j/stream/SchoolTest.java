package ru.job4j.stream;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;

public class SchoolTest {
    School tests = new School();
    List<Student> students = new ArrayList<>();

    @Test
    public void when10AStudents() {
        students.add(new Student(30));
        students.add(new Student(40));
        students.add(new Student(50));
        students.add(new Student(60));
        students.add(new Student(65));
        students.add(new Student(75));
        students.add(new Student(85));
        students.add(new Student(90));
        students.add(new Student(95));
        Predicate<Student> result10A = x -> (x.getScore() >= 70)
                && (x.getScore() <= 100);
        List<Student> actual = tests.collect(students, result10A);
        List<Student> expected = List.of(
                new Student(75),
                new Student(85),
                new Student(90),
                new Student(95)
        );
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void when10BStudents() {
        students.add(new Student(30));
        students.add(new Student(40));
        students.add(new Student(50));
        students.add(new Student(60));
        students.add(new Student(65));
        students.add(new Student(75));
        students.add(new Student(85));
        students.add(new Student(90));
        students.add(new Student(95));
        Predicate<Student> result10B = x -> (x.getScore() >= 50)
                && (x.getScore() < 70);
        List<Student> actual = tests.collect(students, result10B);
        List<Student> expected = List.of(
                new Student(50),
                new Student(60),
                new Student(65)
        );
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void when10CStudents() {
        students.add(new Student(30));
        students.add(new Student(40));
        students.add(new Student(50));
        students.add(new Student(60));
        students.add(new Student(65));
        students.add(new Student(75));
        students.add(new Student(85));
        students.add(new Student(90));
        students.add(new Student(95));
        Predicate<Student> result10B = x -> (x.getScore() > 0)
                && (x.getScore() < 50);
        List<Student> actual = tests.collect(students, result10B);
        List<Student> expected = List.of(
                new Student(30),
                new Student(40)
        );
        Assert.assertThat(actual, is(expected));
    }
}
