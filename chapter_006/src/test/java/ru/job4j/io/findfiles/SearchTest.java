package ru.job4j.io.findfiles;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchTest {
    @Ignore
    @Test
    public void whenSearchFilesByMask() {
        Search search = new Search();
        List list = List.of("txt");
        String str = "c:/projects/job4j/chapter_006";
        List<File> result = search.searchByMask(str, list);
        assertThat(result.size(), is(8));
        List<String> findFiles = List.of("botphrase.txt",
                "conversation.txt",
                "1.txt",
                "2.txt",
                "3.txt",
                "4.txt",
                "5.txt",
                "6.txt");
        for (int i = 0; i < result.size(); i++) {
            assertEquals(findFiles.get(i), result.get(i).getName());
        }
    }

    @Ignore
    @Test
    public void whenSearchFileByName() {
        Search search = new Search();
        String str = "c:/projects/job4j/chapter_006";
        List<File> result = search.searchByName(str, "botphrase");
        assertThat(result.size(), is(1));
        List<String> findFiles = List.of("botphrase.txt");
        for (int i = 0; i < result.size(); i++) {
            assertEquals(findFiles.get(i), result.get(i).getName());
        }
    }
}