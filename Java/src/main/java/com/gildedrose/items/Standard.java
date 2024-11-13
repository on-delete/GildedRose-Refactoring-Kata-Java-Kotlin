package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * - Quality of Standard decreases over time
 * - If expired, it decreases twice as fast
 */
class Standard extends CustomItem {

    private static final int MULTIPLICATOR = 1;

    @Override
    public void updateQuality(Item item) {
        decreaseQualityByMultiplicator(item, MULTIPLICATOR);

        if (isExpired(item.sellIn)) decreaseQualityByMultiplicator(item, MULTIPLICATOR);

        super.updateQuality(item);
    }
}

