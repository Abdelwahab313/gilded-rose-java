package com.gildedrose.Strategies;

import com.gildedrose.Item;

public class StandardItemStrategy extends AbstractItemUpdateStrategy {
    @Override
    protected void updateQualityBeforeSellInPassed(Item item) {
        decreaseQuality(item);
    }

    @Override
    protected void updateQualityAfterSellInPassed(Item item) {
        decreaseQuality(item);
    }
}
