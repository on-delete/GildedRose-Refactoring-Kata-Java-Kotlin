package com.gildedrose.items

import com.gildedrose.Item

private const val MULTIPLICATOR = 2

/**
 * - Quality of Conjured decreases over time
 * - It decreases twice as fast as Standard items
 * - If expired, it decreases twice as fast
 */
class Conjured : CustomItem {
    override fun updateQuality(item: Item) {
        decreaseQualityByMultiplicator(item, MULTIPLICATOR)

        if (isExpired(item.sellIn)) decreaseQualityByMultiplicator(item, MULTIPLICATOR)

        super.updateQuality(item)
    }
}
