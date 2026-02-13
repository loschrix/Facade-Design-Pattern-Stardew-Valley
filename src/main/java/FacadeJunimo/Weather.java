package FacadeJunimo;

public enum Weather {
    SUNNY("Słonecznie"),
    RAINY("Deszcz"),
    STORMY("Burza");

    public final String description;
    Weather(String description) { this.description = description; }
}
