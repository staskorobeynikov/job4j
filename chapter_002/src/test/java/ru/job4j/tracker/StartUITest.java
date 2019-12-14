package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StartUITest {
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI(System.out::println).init(input, new Tracker(), new UserAction[] {action});
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenAddItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Fix PC"));
        Item created = tracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        tracker.replace(item.getId(), new Item("replaced item"));
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        Item item1 = new Item("new item1");
        tracker.add(item);
        tracker.add(item1);
        tracker.delete(item1.getId());
        Item deleted = tracker.findById(item1.getId());
        assertThat(deleted, is(nullValue()));
    }
}
