package FacadeJunimo;

public enum Season {
    SPRING("🌸 Wiosna"),
    SUMMER("☀️ Lato"),
    FALL("🍂 Jesień"),
    WINTER("❄️ Zima");

    public final String icon;
    Season(String icon) { this.icon = icon; }
}
