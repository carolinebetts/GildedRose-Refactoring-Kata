package com.gildedrose;

public class Item {

    private String name;

    int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.sellIn = sellIn;
        this.setQuality(quality);
    }

    public void updateItem() {
        if (getQuality() > 0 && sellIn > 0) {
            setQuality(getQuality() - 1);
        } else if (getQuality() > 0 && sellIn <= 0) {
            setQuality(getQuality() - 2);
        }

    };

    public void updateSellIn() {
        sellIn -= 1;
    }

   @Override
   public String toString() {
        return this.getName() + ", " + this.sellIn + ", " + this.getQuality();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
