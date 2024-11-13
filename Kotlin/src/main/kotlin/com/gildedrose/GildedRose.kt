package com.gildedrose

import com.gildedrose.items.CustomItemFactory

class GildedRose(var items: List<Item>) {

    companion object {
        val customItemFactory = CustomItemFactory()
    }

    fun updateQuality() {
        for (item in items) {
            customItemFactory.getCustomItem(item.name).updateQuality(item)
        }
    }
}

