package com.gildedrose.Strategies;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseStandardStrategyTest {
    @Test
    void standardItemDecreasesInQuality() {
        Item item = new Item("Standard Item", 10, 20, new StandardItemStrategy());
        item.updateQuality();
        assertEquals(19, item.quality);
        assertEquals(9, item.sellIn);
    }
}