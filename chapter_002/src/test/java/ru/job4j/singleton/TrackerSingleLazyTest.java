package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingleLazyTest {
    @Test
    public void whenTwoObjects() {
        TrackerSingleLazy tracker = TrackerSingleLazy.getInstance();
        TrackerSingleLazy tracker1 = TrackerSingleLazy.getInstance();
        assertThat(tracker, is(tracker1));
    }
}
