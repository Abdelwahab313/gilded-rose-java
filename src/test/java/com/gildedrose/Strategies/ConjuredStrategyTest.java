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

}
