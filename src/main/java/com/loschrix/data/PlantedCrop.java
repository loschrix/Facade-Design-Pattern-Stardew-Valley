package com.loschrix.data;

public class PlantedCrop {
    private final CropType type;
    private int daysGrown = 0;
    private boolean isWatered = false;
    private boolean isDead = false;

    public PlantedCrop(CropType type) {
        this.type = type;
    }

    public void water() { isWatered = true; }

    public void grow(Season currentSeason) {
        if (type.season != currentSeason) {
            isDead = true; // Zła pora roku zabija roślinę
        } else if (isWatered && !isDead) {
            daysGrown++;
            isWatered = false; // Wysycha po dniu
        }
    }

    public boolean isReady() {
        return !isDead && daysGrown >= type.daysToMature;
    }

    public boolean isDead() { return isDead; }
    public CropType getType() { return type; }
}
