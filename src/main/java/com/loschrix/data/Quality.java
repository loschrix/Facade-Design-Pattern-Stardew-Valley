package com.loschrix.data;

public enum Quality {
    NORMAL(1.0, ""),
    SILVER(1.25, "🥈"),
    GOLD(1.50, "🥇"),
    IRIDIUM(2.00, "💎");

    public final double multiplier;
    public final String icon;

    Quality(double multiplier, String icon) {
        this.multiplier = multiplier;
        this.icon = icon;
    }
}
