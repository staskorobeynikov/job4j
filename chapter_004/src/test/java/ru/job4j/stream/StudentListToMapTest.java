package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StudentListToMapTest {
    @Test
    public void whenConvertListToMap() {
        StudentListToMap convertToMap = new StudentListToMap();
        StudentMap stud1 = new StudentMap(new Student(40), "Arbuzov");
        StudentMap stud2 = new StudentMap(new Student(60), "Ogurtsov");
        StudentMap stud3 = new StudentMap(new Student(40), "Pomidorov");
        Map<String, StudentMap> actual = convertToMap
                .convert(List.of(stud1, stud2, stud3));
        Map<String, StudentMap> expected = Map.of(
                "Arbuzov", stud1,
                "Ogurtsov", stud2,
                "Pomidorov", stud3
        );
        assertThat(actual, is(expected));
    }
}