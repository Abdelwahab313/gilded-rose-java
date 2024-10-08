package com.gildedrose.Strategies;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieStrategyTest {
    @Test
    void agedBrieIncreasesInQuality() {
        Item item = new Item("Aged Brie", 2, 0, new AgedBrieStrategy());
        item.updateQuality();
        assertEquals(1, item.quality);
        assertEquals(1, item.sellIn);
    }

    @Test
    void agedBrieQualityNeverExceeds50() {
        Item item = new Item("Aged Brie", 2, 50, new AgedBrieStrategy());
        item.updateQuality();
        assertEquals(50, item.quality);
        assertEquals(1, item.sellIn);
    }

    @Test
    void agedBrieIncreasesQualityTwiceAsFastAfterSellIn() {
        Item item = new Item("Aged Brie", 0, 0, new AgedBrieStrategy());
        item.updateQuality();
        assertEquals(2, item.quality);
        assertEquals(-1, item.sellIn);
    }

}