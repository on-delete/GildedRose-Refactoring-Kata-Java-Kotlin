package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * - Quality of Aged Brie increases over time
 * - If Aged Brie is expired, quality increases twice as fast
 */
class AgedBrie extends CustomItem {

    @Override
    public void updateQuality(Item item) {
        increaseQualityByOne(item);

        if (isExpired(item.sellIn)) increaseQualityByOne(item);

        super.updateQuality(item);
    }
}
