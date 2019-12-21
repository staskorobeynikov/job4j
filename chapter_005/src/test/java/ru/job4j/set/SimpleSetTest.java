package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Objects;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    private SimpleSet<Integer> ss;

    static class Student {
        String name;
        String group;
        int course;

        Student(String name, String group, int course) {
            this.name = name;
            this.group = group;
            this.course = course;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Student student = (Student) o;
            return course == student.course
                    && Objects.equals(name, student.name)
                    && Objects.equals(group, student.group);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, group, course);
        }
    }

    @Before
    public void init() {
        ss = new SimpleSet<>();
    }

    @Test
    public void whenAddElementIsUniqueResult() {
        ss.add(5);
        ss.add(10);
        ss.add(10);
        ss.add(15);
        ss.add(15);
        ss.add(15);
        ss.add(20);
        ss.add(20);
        Iterator<Integer> it = ss.iterator();
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(15));
        assertThat(it.next(), is(20));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenAddSomeUsersWithEqualData() {
        SimpleSet<Student> students = new SimpleSet<>();
        Student student1 = new Student("Stas", "Junior", 2);
        Student student2 = new Student("Sergey", "Middle", 3);
        Student student3 = new Student("Sergey", "Middle", 3);
        Student student4 = new Student("Igor", "Trainee", 1);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        Iterator<Student> it = students.iterator();
        assertThat(it.next(), is(student1));
        assertThat(it.next(), is(student2));
        assertThat(it.next(), is(student4));
        assertThat(it.hasNext(), is(false));
    }
}