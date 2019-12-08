import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TrackerSingleTest {
    @Test
    public void whenTwoObjects() {
        TrackerSingle tracker = TrackerSingle.INSTANCE;
        TrackerSingle tracker1 = TrackerSingle.INSTANCE;
        assertThat(tracker, is(tracker1));
    }
}
