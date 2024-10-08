package com.gildedrose;

import com.gildedrose.Strategies.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityUpdateRule rule = getUpdateRule(item);
            rule.updateQuality(item);
        }
    }

    private QualityUpdateRule getUpdateRule(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieStrategy();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassStrategy();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasStrategy();
            default:
                return new StandardItemStrategy();
        }
    }
}