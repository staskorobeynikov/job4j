package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentListToMap {

    public Map<String, StudentMap> convert(List<StudentMap> students) {
        return students.stream()
                .collect(
                        Collectors.toMap(
                                StudentMap::getSurname,
                                student -> student,
                                (first, second) -> first
                        )
                );
    }
}
