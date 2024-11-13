package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return "{name: ${this.name}, sellIn: ${this.sellIn}, quality: ${this.quality}}"
    }
}