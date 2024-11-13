package com.gildedrose;

import com.gildedrose.items.CustomItemFactory;

class GildedRose {
    private final Item[] items;
    private final CustomItemFactory customItemFactory;

    public GildedRose(Item[] items) {
        this.items = items;
        this.customItemFactory = new CustomItemFactory();
    }

    public void updateQuality() {
        for (Item item : items) {
            customItemFactory.getCustomItem(item.name).updateQuality(item);
        }
    }

    public Item[] getItems() {
        return items;
    }
}
