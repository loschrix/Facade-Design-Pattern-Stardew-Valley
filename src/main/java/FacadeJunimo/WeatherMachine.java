package FacadeJunimo;

import java.util.Random;

public class WeatherMachine {
    private final Random rng = new Random();
    private Weather current = Weather.SUNNY;
    private final GameEventSystem events;

    public WeatherMachine(GameEventSystem events) {
        this.events = events;
    }

    public void generateForecast() {
        int chance = rng.nextInt(100);
        if (chance < 5) current = Weather.STORMY;
        else if (chance < 20) current = Weather.RAINY;
        else current = Weather.SUNNY;

        events.notify("🌤️ Pogoda: " + current.description);
    }

    public boolean isRaining() {
        return current == Weather.RAINY || current == Weather.STORMY;
    }
}
