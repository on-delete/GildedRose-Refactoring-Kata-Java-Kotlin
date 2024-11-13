package com.gildedrose.items

import com.gildedrose.Item

private const val LOWEST_QUALITY_VALUE = 0
private const val HIGHEST_QUALITY_VALUE = 50

const val AGED_BRIE = "Aged Brie"
const val SULFURAS = "Sulfuras, Hand of Ragnaros"
const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
const val CONJURED = "Conjured Mana Cake"

/**
 * - sellIn is updated every day
 * - Quality cannot be higher than 50
 * - Quality cannot be lower than 0
 * - Item is considered expired, if sellIn is 0 or lower
 */
interface CustomItem {
    fun updateQuality(item: Item) {
        item.sellIn--

        if (hasReachedLowestQualityValue(item)) item.quality = LOWEST_QUALITY_VALUE
        if (hasReachedHighestQualityValue(item)) item.quality = HIGHEST_QUALITY_VALUE
    }
    fun increaseQualityByOne(item: Item) = item.quality++
    fun decreaseQualityByMultiplicator(item: Item, multiplicator: Int) {
        item.quality -= multiplicator
    }
    fun isExpired(sellIn: Int) = sellIn <= 0

    private fun hasReachedLowestQualityValue(item: Item) = item.quality < LOWEST_QUALITY_VALUE
    private fun hasReachedHighestQualityValue(item: Item) = item.quality > HIGHEST_QUALITY_VALUE
}
