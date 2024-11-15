package com.gildedrose;

public class Item {

    public final String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return "{name: " + this.name + ", sellIn: " + this.sellIn + ", quality: " + this.quality + "}";
    }
}
