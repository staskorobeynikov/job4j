package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void whenFindSixElementsOnComputer() {
        Search search = new Search();
        List list = List.of("txt");
        String str = "c:/projects/job4j/chapter_006/src/main/java/tmpdir";
        List<File> result = search.defineExtension(str, list);
        assertThat(result.size(), is(6));
        List<String> findFiles = List.of("1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt");
        for (int i = 0; i < result.size(); i++) {
            assertEquals(findFiles.get(i), result.get(i).getName());
        }
    }
}