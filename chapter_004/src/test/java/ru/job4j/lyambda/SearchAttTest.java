package ru.job4j.lyambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchAttTest {
    private List<Attachment> attachments = new ArrayList<>();

    @Before
    public void setUp() {
        attachments.add(new Attachment("bug1", 50));
        attachments.add(new Attachment("name1", 120));
        attachments.add(new Attachment("bug2", 30));
        attachments.add(new Attachment("name2", 200));
        attachments.add(new Attachment("first", 100));
    }

    @Test
    public void filterSize() {
        List<Attachment> rsl = SearchAtt.filterSize(this.attachments);
        List<Attachment> expected = List.of(
                new Attachment("name1", 120),
                new Attachment("name2", 200)
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void filterName() {
        List<Attachment> rsl = SearchAtt.filterName(this.attachments);
        List<Attachment> expected = List.of(
                new Attachment("bug1", 50),
                new Attachment("bug2", 30)
        );
        assertThat(rsl, is(expected));
    }
}