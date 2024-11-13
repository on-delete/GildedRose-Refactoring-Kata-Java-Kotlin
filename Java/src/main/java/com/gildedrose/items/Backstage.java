package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * - Quality of Backstage increases over time
 * - If sellIn is 10 or fewer days away, quality increased by 2
 * - If sellIn is 5 or fewer days away, quality increases by 3
 * - If Backstage is expired, the quality drops to 0
 */
class Backstage extends CustomItem {

    @Override
    public void updateQuality(Item item) {
        if (isExpired(item.sellIn)) item.quality = 0;
        else {
            increaseQualityByOne(item);
            if (item.sellIn < 11) increaseQualityByOne(item);
            if (item.sellIn < 6) increaseQualityByOne(item);
        }

        super.updateQuality(item);
    }
}
