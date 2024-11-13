package com.gildedrose.items

class CustomItemFactory {

    companion object {
        val ITEM_TYPE_MAP = mapOf(AGED_BRIE to AgedBrie(), SULFURAS to Sulfuras(), BACKSTAGE to Backstage(), CONJURED to Conjured())
    }

    fun getCustomItem(itemName: String) = ITEM_TYPE_MAP[itemName] ?: Standard()

}