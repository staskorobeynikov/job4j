import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingleLazyTest {
    @Test
    public void whenTwoObjects() {
        TrackerSingleLazy tracker = TrackerSingleLazy.getInstance();
        TrackerSingleLazy tracker1 = TrackerSingleLazy.getInstance();
        TrackerSingleLazy actual = tracker;
        TrackerSingleLazy expected = tracker1;
        assertThat(actual, is(expected));
    }
}
