package com.gildedrose.Strategies;

import com.gildedrose.Item;

public class BackstagePassStrategy implements QualityUpdateRule {
    @Override
    public void updateQuality(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else {
            if (item.quality < 50) {
                item.quality++;
                if (item.sellIn <= 10) {
                    if (item.quality < 50) item.quality++;
                }
                if (item.sellIn <= 5) {
                    if (item.quality < 50) item.quality++;
                }
            }
        }
        item.sellIn--;
    }
}