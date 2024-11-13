package com.gildedrose.items;

import java.util.HashMap;
import java.util.Map;

import static com.gildedrose.items.CustomItem.*;

public class CustomItemFactory {

    private static final Map<String, CustomItem> ITEM_TYPE_MAP;

    static {
        ITEM_TYPE_MAP = new HashMap<>();
        ITEM_TYPE_MAP.put(AGED_BRIE, new AgedBrie());
        ITEM_TYPE_MAP.put(SULFURAS, new Sulfuras());
        ITEM_TYPE_MAP.put(BACKSTAGE, new Backstage());
        ITEM_TYPE_MAP.put(CONJURED, new Conjured());
    }

    public CustomItem getCustomItem(String itemName) {
        if (ITEM_TYPE_MAP.containsKey(itemName)) {
            return ITEM_TYPE_MAP.get(itemName);
        } else {
            return new Standard();
        }
    }
}
