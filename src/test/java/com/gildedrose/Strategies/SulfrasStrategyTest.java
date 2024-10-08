package com.gildedrose.Strategies;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfrasStrategyTest {
    @Test
    void sulfurasNeverChangesInQualityOrSellIn() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80, new SulfurasStrategy());
        item.updateQuality();
        assertEquals(80, item.quality);
        assertEquals(0, item.sellIn);
    }

    @Test
    void sulfurasCanHaveAnyInitialSellIn() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80, new SulfurasStrategy());
        item.updateQuality();
        assertEquals(80, item.quality);
        assertEquals(10, item.sellIn);
    }
}