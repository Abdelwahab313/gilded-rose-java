package com.gildedrose.Strategies;

import com.gildedrose.Item;

public class BackstagePassStrategy extends AbstractItemUpdateStrategy {
    @Override
    protected void updateQualityBeforeSellInPassed(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }

    @Override
    protected void updateQualityAfterSellInPassed(Item item) {
        item.quality = 0;
    }
}