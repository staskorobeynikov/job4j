import ru.job4j.tracker.Item;

public class TrackerSingleEager {
    private static final TrackerSingleEager INSTANCE = new TrackerSingleEager();

    private TrackerSingleEager() {
    }

    public static TrackerSingleEager getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingleEager tracker = TrackerSingleEager.getInstance();
    }
}
