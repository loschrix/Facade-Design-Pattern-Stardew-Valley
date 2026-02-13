# Stardew Valley - Facade Design Pattern Demo

A Java implementation demonstrating the **Facade Design Pattern** and **Observer Pattern** through a simplified Stardew Valley farm simulator. This project showcases how complex subsystems (farm management, weather, time, and shipping) can be elegantly simplified through a unified facade interface.

## Table of Contents

- [Why This Project Is Useful](#why-this-project-is-useful)
- [Design Patterns](#design-patterns)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [How It Works](#how-it-works)
- [Example Output](#example-output)
- [Requirements](#requirements)

## Why This Project Is Useful

### Educational Benefits

- **Learn Design Patterns**: Practical implementation of Facade and Observer patterns
- **Clean Architecture**: See how to structure complex systems with multiple subsystems
- **Java Best Practices**: Modern Java with enums, streams, and clean code principles
- **Game Development Concepts**: Time systems, resource management, and event handling


## Design Patterns

### Facade Pattern
The `JunimoHut` class serves as a facade, providing a simple `performDailyRoutine()` method that coordinates:
- `WorldClock` (time management)
- `WeatherMachine` (weather generation)
- `FarmSystem` (crop management)
- `ShippingBin` (harvest and sales)

### Observer Pattern
The `GameEventSystem` implements a publish-subscribe model where:
- **Subject**: `GameEventSystem` manages event notifications
- **Observer**: `ConsoleLogger` receives and displays all events
- **Benefit**: Decoupled logging system, easily extensible with new observers

## Getting Started

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/loschrix/Facade-Design-Pattern-Stardew-Valley.git
   cd Facade-Design-Pattern-Stardew-Valley
   ```

2. **Build the project**
   ```bash
   ./gradlew build
   ```
   
   On Windows:
   ```cmd
   gradlew.bat build
   ```

3. **Run the simulation**
   ```bash
   ./gradlew run
   ```

### Quick Start Example

```java
// 1. Create the event system (Observer Pattern)
GameEventSystem eventSystem = new GameEventSystem();
eventSystem.subscribe(new ConsoleLogger());

// 2. Create the farm
FarmSystem farm = new FarmSystem(eventSystem);

// 3. Create the facade
JunimoHut junimos = new JunimoHut(farm, eventSystem);

// 4. Plant some crops
farm.manualPlant(CropType.PARSNIP);
farm.manualPlant(CropType.STRAWBERRY);

// 5. Run daily simulation
for (int i = 0; i < 28; i++) {
    junimos.performDailyRoutine();
    Thread.sleep(800); // 800ms delay for readability
}
```

## Project Structure

```
src/main/java/com/loschrix/
├── Main.java                          # Entry point
├── JunimoHut.java                    # FACADE - Simplifies subsystem interactions
│
├── data/
│   ├── CropType.java                 # Enum of 16 seasonal crops
│   ├── PlantedCrop.java             # Individual crop state management
│   ├── Season.java                   # Spring, Summer, Fall, Winter
│   ├── Weather.java                  # Sunny, Rainy, Stormy
│   └── Quality.java                  # Normal, Silver, Gold, Iridium
│
├── subsystems/
│   ├── FarmSystem.java              # Crop planting, watering, growth
│   ├── WorldClock.java              # Day/season progression
│   ├── WeatherMachine.java          # Weather generation
│   └── ShippingBin.java             # Harvest sales and economy
│
└── observer/
    ├── GameEventSystem.java         # Event manager (Subject)
    ├── GameObserver.java            # Observer interface
    └── ConsoleLogger.java           # Concrete observer implementation
```

## How It Works

### Daily Routine Flow

The `JunimoHut.performDailyRoutine()` method orchestrates:

```
1. Advance Time → WorldClock.nextDay()
2. Generate Weather → WeatherMachine.generateForecast()
3. Water Crops → FarmSystem.waterByRain() OR waterByJunimo()
4. Grow Plants → FarmSystem.simulateGrowth()
5. Harvest Ready → FarmSystem.harvestReady()
6. Sell Crops → ShippingBin.ship()
```

### Crop Lifecycle

1. **Planting** - Crops start at day 0
2. **Watering** - Must be watered daily (or by rain)
3. **Growth** - Advances 1 day if watered and in correct season
4. **Harvest** - Ready when `daysGrown >= daysToMature`
5. **Sales** - Quality randomized, price calculated with multiplier

### Season System

- Each season lasts **28 days**
- Crops planted in wrong season will **die**
- After Fall, cycle returns to Spring

## Example Output

```
--- STARDEW VALLEY SIMULATOR ---
[LOG]: 👨‍🌾 Gracz zasadził: 🥕 Pasternak
[LOG]: 👨‍🌾 Gracz zasadził: 🍓 Truskawka

--- START SYMULACJI ---
[LOG]: [Dzień 2 | SPRING]
[LOG]: 🌤️ Pogoda: Słonecznie
[LOG]: 💧 Junimo podlały 2 roślin.
[LOG]: 💤 Brak zbiorów dzisiaj.
----------------------------------------
[LOG]: [Dzień 6 | SPRING]
[LOG]: 🌤️ Pogoda: Deszcz
[LOG]: 🌧️ Pada! Junimo tańczą w deszczu.
[LOG]: 📦 Junimo wrzucają 1 plonów do skrzyni...
[LOG]: 🧾 -> Sprzedano: 🥕 (🥈) za 37g
[LOG]: 💰 Stan konta: 537g
----------------------------------------
```

## Maintainer

**loschrix** - [GitHub Profile](https://github.com/loschrix)

## Additional Resources

- [Facade Pattern - Refactoring Guru](https://refactoring.guru/design-patterns/facade)
- [Observer Pattern - Refactoring Guru](https://refactoring.guru/design-patterns/observer)
- [Stardew Valley Wiki](https://stardewvalleywiki.com/)

---

**⭐ If you found this project helpful, please consider giving it a star!**
