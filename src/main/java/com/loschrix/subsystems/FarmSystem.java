package com.loschrix.subsystems;

import com.loschrix.data.*;
import com.loschrix.observer.GameEventSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FarmSystem {
    private final List<PlantedCrop> grid = new ArrayList<>();
    private final GameEventSystem events;

    public FarmSystem(GameEventSystem events) {
        this.events = events;
    }

    public void manualPlant(CropType type) {
        grid.add(new PlantedCrop(type));
        events.notify("👨‍🌾 Gracz zasadził: " + type.icon + " " + type.name);
    }

    public void waterByJunimo() {
        long count = applyWatering();
        if (count > 0) {
            events.notify("💧 Junimo podlały " + count + " roślin.");
        }
    }

    public void waterByRain() {
        long count = applyWatering();
        if (count > 0) {
            events.notify("🌧️ (Gleba została nawodniona przez deszcz)");
        }
    }

    private long applyWatering() {
        return grid.stream()
                .filter(c -> !c.isDead())
                .mapToInt(c -> {
                    c.water();
                    return 1;
                })
                .sum();
    }

    public void simulateGrowth(Season season) {
        grid.forEach(c -> c.grow(season));

        long deadCount = grid.stream().filter(PlantedCrop::isDead).count();
        if (deadCount > 0) {
            events.notify("💀 " + deadCount + " roślin uschło (zła pora roku).");
        }
        grid.removeIf(PlantedCrop::isDead);
    }

    public List<PlantedCrop> harvestReady() {
        List<PlantedCrop> ready = grid.stream().filter(PlantedCrop::isReady).collect(Collectors.toList());
        grid.removeAll(ready);
        return ready;
    }
}
