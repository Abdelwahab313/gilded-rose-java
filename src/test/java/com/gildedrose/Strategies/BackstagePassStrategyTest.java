package com.gildedrose.Strategies;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassStrategyTest {
    @Test
    void qualityIncreasesByOneIfSellInGreaterThan10() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        QualityUpdateRule rule = new BackstagePassStrategy();
        rule.updateQuality(item);
        assertEquals(21, item.quality);
        assertEquals(14, item.sellIn);
    }

    @Test
    void qualityIncreasesByTwoIfSellInLessThanOrEqualTo10() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        QualityUpdateRule rule = new BackstagePassStrategy();
        rule.updateQuality(item);
        assertEquals(22, item.quality);
        assertEquals(9, item.sellIn);
    }

    @Test
    void qualityIncreasesByThreeIfSellInLessThanOrEqualTo5() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        QualityUpdateRule rule = new BackstagePassStrategy();
        rule.updateQuality(item);
        assertEquals(23, item.quality);
        assertEquals(4, item.sellIn);
    }

    @Test
    void qualityDropsToZeroAfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        QualityUpdateRule rule = new BackstagePassStrategy();
        rule.updateQuality(item);
        assertEquals(0, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    void qualityNeverExceeds50() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        QualityUpdateRule rule = new BackstagePassStrategy();
        rule.updateQuality(item);
        assertEquals(50, item.quality);
        assertEquals(4, item.sellIn);
    }
}