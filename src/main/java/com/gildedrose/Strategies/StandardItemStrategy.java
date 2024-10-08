package com.gildedrose.Strategies;

import com.gildedrose.Item;

public class StandardItemStrategy implements QualityUpdateRule {
    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }
}
