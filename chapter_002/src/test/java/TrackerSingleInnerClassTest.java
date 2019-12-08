import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleInnerClassTest {
    @Test
    public void whenTwoObjects() {
        TrackerSingleInnerClass tracker = TrackerSingleInnerClass.getInstance();
        TrackerSingleInnerClass tracker1 = TrackerSingleInnerClass.getInstance();
        assertThat(tracker, is(tracker1));
    }
}
