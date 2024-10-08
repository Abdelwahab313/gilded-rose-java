package com.gildedrose.Strategies;

import com.gildedrose.Item;

abstract class AbstractItemUpdateStrategy implements QualityUpdateRule {
    @Override
    public final void updateQuality(Item item) {
        updateQualityBeforeSellInPassed(item);
        updateSellIn(item);
        if (item.sellIn < 0) {
            updateQualityAfterSellInPassed(item);
        }
    }

    protected abstract void updateQualityBeforeSellInPassed(Item item);
    protected abstract void updateQualityAfterSellInPassed(Item item);

    protected void updateSellIn(Item item) {
        item.sellIn--;
    }

    protected void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}