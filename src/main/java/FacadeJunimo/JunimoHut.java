package FacadeJunimo;

import java.util.List;

public class JunimoHut {
    private final WorldClock clock;
    private final WeatherMachine weather;
    private final ShippingBin bin;
    private final FarmSystem farm;
    private final GameEventSystem events;

    // Konstruktor przyjmuje system zdarzeń i farmę
    public JunimoHut(FarmSystem farm, GameEventSystem events) {
        this.farm = farm;
        this.events = events;
        // Inicjalizujemy podsystemy przekazując im "Radio" (events)
        this.clock = new WorldClock(events);
        this.weather = new WeatherMachine(events);
        this.bin = new ShippingBin(events);
    }

    public void performDailyRoutine() {
        clock.nextDay();
        Season currentSeason = clock.getSeason();
        weather.generateForecast();

        if (weather.isRaining()) {
            events.notify("🌧️ Pada! Junimo tańczą w deszczu.");
            farm.waterByRain();
        } else {
            farm.waterByJunimo();
        }

        farm.simulateGrowth(currentSeason);

        List<PlantedCrop> harvest = farm.harvestReady();
        if (!harvest.isEmpty()) {
            bin.ship(harvest);
        } else {
            events.notify("💤 Brak zbiorów dzisiaj.");
        }
        events.notify("----------------------------------------");
    }
}
