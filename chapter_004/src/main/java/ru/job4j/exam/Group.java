package ru.job4j.exam;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Group {

    Map<String, Set<String>> sections(List<Student> students) {
        return students.stream().flatMap(
                student -> student.getUnits().stream().map(unit -> new Holder(unit, student.getName()))
        ).collect(
                Collectors.groupingBy(t -> t.key,
                        Collector.of(
                                HashSet::new,
                                (set, element) -> set.add(element.value),
                                (left, right) -> {
                                    left.addAll(right);
                                    return left;
                                }
                        )
                )
        );
    }

    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
