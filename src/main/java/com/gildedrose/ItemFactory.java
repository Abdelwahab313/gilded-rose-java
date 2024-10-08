package com.gildedrose;

import com.gildedrose.Strategies.*;

public class ItemFactory {

    public static QualityUpdateRule createUpdateRule(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieStrategy();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassStrategy();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasStrategy();
            case "Conjured":
                return new ConjuredStrategy();
            default:
                return new StandardItemStrategy();
        }
    }
}
