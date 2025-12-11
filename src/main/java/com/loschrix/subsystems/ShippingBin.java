package com.loschrix.subsystems;

import com.loschrix.data.*;
import com.loschrix.observer.GameEventSystem;
import java.util.List;
import java.util.Random;

public class ShippingBin {
    private int gold = 500;
    private final Random rng = new Random();
    private final GameEventSystem events;

    public ShippingBin(GameEventSystem events) {
        this.events = events;
    }

    public void ship(List<PlantedCrop> crops) {
        if (crops.isEmpty()) return;

        events.notify("📦 Junimo wrzucają " + crops.size() + " plonów do skrzyni...");
        for (PlantedCrop c : crops) {
            Quality q = rollQuality();
            int price = (int) (c.getType().seedCost * 1.5 * q.multiplier);
            gold += price;
            String qualitySuffix = (q == Quality.NORMAL) ? "" : " (" + q.icon + ")";
            events.notify("🧾 -> Sprzedano: " + qualitySuffix + " za " + price + "g");
        }
        events.notify("💰 Stan konta: " + gold + "g");
    }

    private Quality rollQuality() {
        double r = rng.nextDouble();
        if (r > 0.9) return Quality.IRIDIUM;
        if (r > 0.7) return Quality.GOLD;
        if (r > 0.4) return Quality.SILVER;
        return Quality.NORMAL;
    }
}
