package com.gildedrose.Strategies;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassStrategyTest {
    @Test
    void qualityIncreasesByOneIfSellInGreaterThan10() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20, new BackstagePassStrategy());
        item.updateQuality();
        assertEquals(21, item.quality);
        assertEquals(14, item.sellIn);
    }

}