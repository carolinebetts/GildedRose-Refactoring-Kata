package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
        }
    }
}
