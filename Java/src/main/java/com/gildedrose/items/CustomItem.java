package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * - sellIn is updated every day
 * - Quality cannot be higher than 50
 * - Quality cannot be lower than 0
 * - Item is considered expired, if sellIn is 0 or lower
 */
public abstract class CustomItem {

    final int LOWEST_QUALITY_VALUE = 0;
    final int HIGHEST_QUALITY_VALUE = 50;

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured Mana Cake";

    public void updateQuality(Item item) {
        item.sellIn--;

        if (hasReachedLowestQualityValue(item)) item.quality = LOWEST_QUALITY_VALUE;
        if (hasReachedHighestQualityValue(item)) item.quality = HIGHEST_QUALITY_VALUE;
    }
    void increaseQualityByOne(Item item) { item.quality++; }
    void decreaseQualityByMultiplicator(Item item, int multiplicator) {
        item.quality -= multiplicator;
    }
    boolean isExpired(int sellIn) {
        return sellIn <= 0;
    }

    boolean hasReachedLowestQualityValue(Item item) { return item.quality < LOWEST_QUALITY_VALUE; }
    boolean hasReachedHighestQualityValue(Item item) { return item.quality > HIGHEST_QUALITY_VALUE; }
}
