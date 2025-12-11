package com.loschrix.data;

public enum CropType {
    // --- WIOSNA (SPRING) ---
    PARSNIP("Pasternak", 20, 4, Season.SPRING, "🥕"),
    STRAWBERRY("Truskawka", 100, 8, Season.SPRING, "🍓"),
    BLUE_JAZZ("Niebieski Jazz", 30, 7, Season.SPRING, "🔵"),
    CAULIFLOWER("Kalafior", 80, 12, Season.SPRING, "🥦"),

    // --- LATO (SUMMER) ---
    MELON("Melon", 80, 12, Season.SUMMER, "🍈"),
    STARFRUIT("Gwiezdny Owoc", 400, 13, Season.SUMMER, "⭐"),
    BLUEBERRY("Borówka", 80, 13, Season.SUMMER, "🫐"),
    HOT_PEPPER("Papryczka", 40, 5, Season.SUMMER, "🌶️"),

    // --- JESIEŃ (FALL) ---
    PUMPKIN("Dynia", 100, 13, Season.FALL, "🎃"),
    EGGPLANT("Bakłażan", 20, 5, Season.FALL, "🍆"),
    YAM("Batat", 60, 10, Season.FALL, "🍠"),
    CORN("Kukurydza", 150, 14, Season.FALL, "🌽");

    public final String name;
    public final int seedCost;
    public final int daysToMature;
    public final Season season;
    public final String icon;

    CropType(String name, int cost, int days, Season season, String icon) {
        this.name = name;
        this.seedCost = cost;
        this.daysToMature = days;
        this.season = season;
        this.icon = icon;
    }
}
