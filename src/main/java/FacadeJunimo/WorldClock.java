package FacadeJunimo;

public class WorldClock {
    private int day = 1;
    private Season currentSeason = Season.SPRING;
    private final GameEventSystem events;

    public WorldClock(GameEventSystem events) {
        this.events = events;
    }

    public void nextDay() {
        day++;
        if (day > 28) {
            day = 1;
            int nextIdx = (currentSeason.ordinal() + 1) % Season.values().length;
            currentSeason = Season.values()[nextIdx];
            events.notify("🔔 ZMIANA PORY ROKU: " + currentSeason.icon + " " + currentSeason);
        }
        events.notify("[Dzień " + day + " | " + currentSeason + "]");
    }

    public Season getSeason() { return currentSeason; }
}
