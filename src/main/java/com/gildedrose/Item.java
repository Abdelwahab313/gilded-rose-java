package com.gildedrose;

import com.gildedrose.Strategies.QualityUpdateRule;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    QualityUpdateRule updateRule;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public Item(String name, int sellIn, int quality, QualityUpdateRule updateRule) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.updateRule = updateRule;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality() {
        updateRule.updateQuality(this);
    }
}
