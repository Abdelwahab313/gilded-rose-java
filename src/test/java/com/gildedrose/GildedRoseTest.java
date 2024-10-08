package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String NORMAL_ITEM = "foo";
    private static final String CONJURED = "Conjured";


    @Test
    void testUpdateQualityForNormalItem() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void testUpdateQualityForNormalItemPastSellIn() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void testUpdateQualityForAgedBrie() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void testUpdateQualityForAgedBriePastSellIn() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void testUpdateQualityForBackstagePasses() {
        Item[] items = new Item[] { 
            new Item(BACKSTAGE_PASSES, 15, 20),
            new Item(BACKSTAGE_PASSES, 10, 20),
            new Item(BACKSTAGE_PASSES, 5, 20),
            new Item(BACKSTAGE_PASSES, 0, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
        assertEquals(9, app.items[1].sellIn);
        assertEquals(22, app.items[1].quality);
        assertEquals(4, app.items[2].sellIn);
        assertEquals(23, app.items[2].quality);
        assertEquals(-1, app.items[3].sellIn);
        assertEquals(0, app.items[3].quality);
    }

    @Test
    void testUpdateQualityForSulfuras() {
        Item[] items = new Item[] { new Item(SULFURAS, 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testQualityNeverNegative() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testQualityNeverMoreThan50() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }


    @Test
    void testMultipleItemsUpdateSimultaneously() {
        Item[] items = new Item[] { 
            new Item(NORMAL_ITEM, 10, 20),
            new Item(AGED_BRIE, 5, 10),
            new Item(BACKSTAGE_PASSES, 15, 20),
            new Item(SULFURAS, 0, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
        
        assertEquals(4, items[1].sellIn);
        assertEquals(11, items[1].quality);
        
        assertEquals(14, items[2].sellIn);
        assertEquals(21, items[2].quality);
        
        assertEquals(0, items[3].sellIn);
        assertEquals(80, items[3].quality);
    }

    @Test
    void testQualityDecreasesTwiceAsFastAfterSellIn() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    void testAgedBrieIncreasesQualityToMaximum() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(50, items[0].quality);
        
        app.updateQuality();
        assertEquals(8, items[0].sellIn);
        assertEquals(50, items[0].quality);  // Should not increase beyond 50
    }

    @Test
    void testBackstagePassesQualityIncreasesLaterGradual() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 11, 20) };
        GildedRose app = new GildedRose(items);
        
        for (int i = 0; i < 12; i++) {
            app.updateQuality();
        }
        
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testItemWithVeryHighInitialQuality() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 10, 100) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(99, items[0].quality);
    }

    @Test
    void testUpdateQualityMultipleDays() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 3, 10) };
        GildedRose app = new GildedRose(items);
        
        for (int i = 0; i < 5; i++) {
            app.updateQuality();
        }
        
        // test degrade for 5 times for the first three days degrade 3 , for the next two days degrade 4
        assertEquals(-2, items[0].sellIn);
        assertEquals(3, items[0].quality);
    }

    @Test
    void testBackstagePassesQualityDropsToZeroImmediatelyAfterConcert() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testUpdateQualityForConjuredItem() {
        Item[] items = new Item[] { new Item(CONJURED, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void testUpdateQualityForConjuredItemPastSellIn() {
        Item[] items = new Item[] { new Item(CONJURED, 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(16, app.items[0].quality);
    }

    @Test
    void testConjuredItemQualityNeverNegative() {
        Item[] items = new Item[] { new Item(CONJURED, 5, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testConjuredItemUpdateQualityMultipleDays() {
        Item[] items = new Item[] { new Item(CONJURED, 3, 10) };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 5; i++) {
            app.updateQuality();
        }

        assertEquals(-2, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testConjuredItemWithNormalItemSimultaneously() {
        Item[] items = new Item[] {
                new Item(NORMAL_ITEM, 10, 20),
                new Item(CONJURED, 10, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);

        assertEquals(9, items[1].sellIn);
        assertEquals(18, items[1].quality);
    }

}
