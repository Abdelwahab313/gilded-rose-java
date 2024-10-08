package com.gildedrose;

import com.gildedrose.Strategies.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityUpdateRule rule = ItemFactory.createUpdateRule(item);
            rule.updateQuality(item);
        }
    }
}