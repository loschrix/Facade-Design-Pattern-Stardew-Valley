package com.loschrix;

import com.loschrix.data.CropType;
import com.loschrix.observer.ConsoleLogger;
import com.loschrix.observer.GameEventSystem;
import com.loschrix.subsystems.FarmSystem;

public class Main {
    static void main() throws InterruptedException {
        System.out.println("--- STARDEW VALLEY SIMULATOR ---");

        // 1. Tworzymy System Zdarzeń (OBSERVER PATTERN - SUBJECT)
        GameEventSystem eventSystem = new GameEventSystem();

        // 2. Dodajemy Konkretnego Obserwatora (Logger konsolowy)
        eventSystem.subscribe(new ConsoleLogger());

        // 3. Tworzymy Farmę (dając jej system powiadomień)
        FarmSystem farm = new FarmSystem(eventSystem);

        // 4. Tworzymy Fasadę
        JunimoHut junimos = new JunimoHut(farm, eventSystem);

        // 5. Gracz działa
        farm.manualPlant(CropType.PARSNIP);
        farm.manualPlant(CropType.BLUE_JAZZ);
        farm.manualPlant(CropType.STRAWBERRY);

        System.out.println("\n--- START SYMULACJI ---");

        for (int i = 0; i < 28; i++) {
            junimos.performDailyRoutine();
            Thread.sleep(800);
        }
    }
}

