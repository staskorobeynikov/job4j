package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;

public class SchoolTest {

    private School school = new School();

    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(30));
        students.add(new Student(40));
        students.add(new Student(50));
        students.add(new Student(60));
        students.add(new Student(65));
        students.add(new Student(75));
        students.add(new Student(85));
        students.add(new Student(90));
        students.add(new Student(95));
    }

    @Test
    public void when10AStudents() {
        Predicate<Student> result10A = x -> (x.getScore() >= 70)
                && (x.getScore() <= 100);
        List<Student> actual = school.collect(students, result10A);
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
        Predicate<Student> result10B = x -> (x.getScore() >= 50)
                && (x.getScore() < 70);
        List<Student> actual = school.collect(students, result10B);
        List<Student> expected = List.of(
                new Student(50),
                new Student(60),
                new Student(65)
        );
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void when10CStudents() {
        Predicate<Student> result10B = x -> (x.getScore() > 0)
                && (x.getScore() < 50);
        List<Student> actual = school.collect(students, result10B);
        List<Student> expected = List.of(
                new Student(30),
                new Student(40)
        );
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void whenTestMethodToString() {
        Student student = new Student(85);

        String result = student.toString();

        Assert.assertThat(result, is("Student: score = 85"));
    }

    @Test
    public void whenTestMethodHashCode() {
        Student student = new Student(85);

        int result = student.hashCode();

        Assert.assertThat(result, is(116));
    }

    @Test
    public void whenTestMethodEqualsIsTrue() {
        Student student = new Student(85);

        boolean result = student.equals(student);

        Assert.assertThat(result, is(true));
    }

    @Test
    public void whenTestMethodEqualsIsTrue1() {
        Student student = new Student(85);
        Student student1 = new Student(85);

        boolean result = student.equals(student1);

        Assert.assertThat(result, is(true));
    }

    @Test
    public void whenTestMethodEqualsIsFalse() {
        Student student = new Student(85);
        Student student1 = new Student(55);

        boolean result = student.equals(student1);

        Assert.assertThat(result, is(false));
    }

    @Test
    public void whenTestMethodEqualsIsFalse1() {
        Student student = new Student(85);
        Student student1 = null;

        boolean result = student.equals(student1);

        Assert.assertThat(result, is(false));
    }

    @Test
    public void whenTestMethodEqualsIsFalse2() {
        Student student = new Student(85);

        boolean result = student.equals(new Address("", "", 10, 20));

        Assert.assertThat(result, is(false));
    }
}
