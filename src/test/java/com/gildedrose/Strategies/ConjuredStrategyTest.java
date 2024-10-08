package com.gildedrose.Strategies;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ConjuredStrategyTest {

    private ConjuredStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new ConjuredStrategy();
    }

    @Test
    void testNormalUpdate() {
        Item item = new Item("Conjured", 5, 10);
        strategy.updateQuality(item);
        assertEquals(4, item.sellIn);
        assertEquals(8, item.quality);
    }

    @Test
    void testUpdateNearZeroQuality() {
        Item item = new Item("Conjured", 5, 1);
        strategy.updateQuality(item);
        assertEquals(4, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void testUpdateAtZeroQuality() {
        Item item = new Item("Conjured", 5, 0);
        strategy.updateQuality(item);
        assertEquals(4, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void testExpiredItemUpdate() {
        Item item = new Item("Conjured", 0, 10);
        strategy.updateQuality(item);
        assertEquals(-1, item.sellIn);
        assertEquals(6, item.quality);
    }

    @Test
    void testExpiredItemNearZeroQuality() {
        Item item = new Item("Conjured", 0, 3);
        strategy.updateQuality(item);
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void testMultipleDaysUpdate() {
        Item item = new Item("Conjured", 5, 20);
        for (int i = 0; i < 10; i++) {
            strategy.updateQuality(item);
        }
        assertEquals(-5, item.sellIn);
        assertEquals(0, item.quality);
    }

}
