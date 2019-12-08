import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleEagerTest {
    @Test
    public void whenTwoObjects() {
        TrackerSingleEager tracker = TrackerSingleEager.getInstance();
        TrackerSingleEager tracker1 = TrackerSingleEager.getInstance();
        TrackerSingleEager actual = tracker;
        TrackerSingleEager expected = tracker1;
        assertThat(actual, is(expected));
    }
}
