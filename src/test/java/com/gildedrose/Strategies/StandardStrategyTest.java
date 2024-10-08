package com.gildedrose.Strategies;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StandardStrategyTest {
    @Test
    void standardItemDecreasesInQuality() {
        Item item = new Item("Standard Item", 10, 20);
        QualityUpdateRule rule = new StandardItemStrategy();
        rule.updateQuality(item);
        assertEquals(19, item.quality);
        assertEquals(9, item.sellIn);
    }

    @Test
    void qualityDegradesTwiceFastAfterSellIn() {
        Item item = new Item("Standard Item", 0, 20);
        QualityUpdateRule rule = new StandardItemStrategy();
        rule.updateQuality(item);
        assertEquals(18, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    void qualityIsNeverNegative() {
        Item item = new Item("Standard Item", 5, 0);
        QualityUpdateRule rule = new StandardItemStrategy();
        rule.updateQuality(item);
        assertEquals(0, item.quality);
        assertEquals(4, item.sellIn);
    }
}