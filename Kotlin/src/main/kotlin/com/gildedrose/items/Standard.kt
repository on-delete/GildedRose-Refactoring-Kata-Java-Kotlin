package com.gildedrose.items

import com.gildedrose.Item

private const val MULTIPLICATOR = 1

/**
 * - Quality of Standard decreases over time
 * - If expired, it decreases twice as fast
 */
class Standard: CustomItem {
    override fun updateQuality(item: Item) {
        decreaseQualityByMultiplicator(item, MULTIPLICATOR)

        if (isExpired(item.sellIn)) decreaseQualityByMultiplicator(item, MULTIPLICATOR)

        super.updateQuality(item)
    }
}

