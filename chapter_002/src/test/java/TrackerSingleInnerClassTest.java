import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleInnerClassTest {
    @Test
    public void whenTwoObjects() {
        TrackerSingleInnerClass tracker = TrackerSingleInnerClass.getInstance();
        TrackerSingleInnerClass tracker1 = TrackerSingleInnerClass.getInstance();
        TrackerSingleInnerClass actual = tracker;
        TrackerSingleInnerClass expected = tracker1;
        assertThat(actual, is(expected));
    }
}
