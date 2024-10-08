package com.gildedrose.Strategies;

import com.gildedrose.Item;

public class AgedBrieStrategy extends AbstractItemUpdateStrategy {
    @Override
    protected void updateQualityBeforeSellInPassed(Item item) {
        increaseQuality(item);
    }

    @Override
    protected void updateQualityAfterSellInPassed(Item item) {
        increaseQuality(item);
    }

}