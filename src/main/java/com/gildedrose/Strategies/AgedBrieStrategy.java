package com.gildedrose.Strategies;

import com.gildedrose.Item;

public class AgedBrieStrategy implements QualityUpdateRule {
    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn <= 0 && item.quality < 50) {
                item.quality++;
            }
        }
        item.sellIn--;
    }
}