package ru.job4j.exam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GroupTest {

    @Test
    public void whenTestMethodSections() {
        Student student1 = new Student("Vadim", Set.of(
                "Programming",
                "Swimming",
                "Photography"
        ));
        Student student2 = new Student("Nikolai", Set.of(
                "Swimming",
                "Books",
                "TV"
        ));
        Student student3 = new Student("Sergei", Set.of(
                "Books",
                "Photography",
                "Programming"
        ));
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        Group group = new Group();

        Map<String, Set<String>> result = group.sections(studentList);

        assertThat(result.get("Programming"), is(Set.of("Vadim", "Sergei")));
        assertThat(result.get("Swimming"), is(Set.of("Vadim", "Nikolai")));
        assertThat(result.get("Photography"), is(Set.of("Vadim", "Sergei")));
        assertThat(result.get("Books"), is(Set.of("Nikolai", "Sergei")));
        assertThat(result.get("TV"), is(Set.of("Nikolai")));
    }

    @Test
    public void whenTestMethodToString() {
        Student student1 = new Student("Vadim", Set.of(
                "Photography"
        ));

        String result = student1.toString();

        assertThat(result, is("Student: name=Vadim, units=[Photography]"));
    }
}