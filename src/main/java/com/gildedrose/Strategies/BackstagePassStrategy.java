package com.gildedrose.Strategies;

import com.gildedrose.Item;

class BackstagePassStrategy implements QualityUpdateRule {
    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        item.sellIn--;
    }
}