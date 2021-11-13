package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemComparatorTest {
    @Test
    public void whenSortingAscende() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("summer");
        Item item2 = new Item("autumn");
        Item item3 = new Item("winter");
        Item item4 = new Item("spring");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        Collections.sort(items, new ItemComparatorAscend());
        List<Item> expect = new ArrayList<>();
        expect.add(item2);
        expect.add(item4);
        expect.add(item1);
        expect.add(item3);
        assertThat(items, is(expect));
    }

    @Test
    public void whenSortingDescende() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("summer");
        Item item2 = new Item("autumn");
        Item item3 = new Item("winter");
        Item item4 = new Item("spring");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        Collections.sort(items, new ItemComparatorDescend());
        List<Item> expect = new ArrayList<>();
        expect.add(item3);
        expect.add(item1);
        expect.add(item4);
        expect.add(item2);
        assertThat(items, is(expect));
    }
}
