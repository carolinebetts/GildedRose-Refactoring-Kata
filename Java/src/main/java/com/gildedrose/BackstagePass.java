package com.gildedrose;

public class BackstagePass extends Item {
    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        if (this.sellIn <= 0 ) {
            this.setQuality(0);
        }

        else if (this.sellIn < 6 && this.getQuality() < 50) {
            this.setQuality(this.getQuality() + 3);
        }
        else if (this.sellIn < 11 && this.getQuality() < 50) {
            this.setQuality(this.getQuality() + 2);
        }
    }
}
