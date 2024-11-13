package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * - Quality of Conjured decreases over time
 * - It decreases twice as fast as Standard items
 * - If expired, it decreases twice as fast
 */
class Conjured extends CustomItem {

    private static final int MULTIPLICATOR = 2;

    @Override
    public void updateQuality(Item item) {
        decreaseQualityByMultiplicator(item, MULTIPLICATOR);

        if (isExpired(item.sellIn)) decreaseQualityByMultiplicator(item, MULTIPLICATOR);

        super.updateQuality(item);
    }
}
