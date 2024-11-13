package com.gildedrose

import com.gildedrose.items.AGED_BRIE
import com.gildedrose.items.BACKSTAGE
import com.gildedrose.items.CONJURED
import com.gildedrose.items.SULFURAS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

const val NORMAL_ITEM = "normal-item"

internal class GildedRoseTest {

    private fun doTest(item: Item, expectedSellIn: Int, expectedQuality: Int) {
        val app = GildedRose(listOf(item))

        app.updateQuality()
        assertEquals(expectedSellIn, app.items[0].sellIn)
        assertEquals(expectedQuality, app.items[0].quality)
    }

    companion object {
        @JvmStatic
        fun provideNormalItems(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Item(NORMAL_ITEM, 10, 20), 9, 19
                ),
                Arguments.of(
                    Item(NORMAL_ITEM, 1, 20), 0, 19
                ),
                Arguments.of(
                    Item(NORMAL_ITEM, 0, 20), -1, 18
                ),
                Arguments.of(
                    Item(NORMAL_ITEM, -2, 20), -3, 18
                ),
                Arguments.of(
                    Item(NORMAL_ITEM, 10, 0), 9, 0
                )
            )
        }

        @JvmStatic
        fun provideAgedBrieItems(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Item(AGED_BRIE, 10, 20), 9, 21
                ),
                Arguments.of(
                    Item(AGED_BRIE, 10, 50), 9, 50
                ),
                Arguments.of(
                    Item(AGED_BRIE, 1, 0), 0, 1
                ),
                Arguments.of(
                    Item(AGED_BRIE, 0, 0), -1, 2
                ),
                Arguments.of(
                    Item(AGED_BRIE, -2, 4), -3, 6
                ),
                Arguments.of(
                    Item(AGED_BRIE, -2, 48), -3, 50
                ),
                Arguments.of(
                    Item(AGED_BRIE, -2, 49), -3, 50
                )
            )
        }

        @JvmStatic
        fun provideBackstageItems(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Item(BACKSTAGE, 11, 20), 10, 21
                ),
                Arguments.of(
                    Item(BACKSTAGE, 10, 20), 9, 22
                ),
                Arguments.of(
                    Item(BACKSTAGE, 6, 20), 5, 22
                ),
                Arguments.of(
                    Item(BACKSTAGE, 5, 20), 4, 23
                ),
                Arguments.of(
                    Item(BACKSTAGE, 0, 20), -1, 0
                ),
                Arguments.of(
                    Item(BACKSTAGE, 11, 49), 10, 50
                ),
                Arguments.of(
                    Item(BACKSTAGE, 11, 50), 10, 50
                ),
                Arguments.of(
                    Item(BACKSTAGE, 10, 48), 9, 50
                ),
                Arguments.of(
                    Item(BACKSTAGE, 10, 49), 9, 50
                ),
                Arguments.of(
                    Item(BACKSTAGE, 5, 47), 4, 50
                ),
                Arguments.of(
                    Item(BACKSTAGE, 5, 48), 4, 50
                )
            )
        }

        @JvmStatic
        fun provideConjuredItems(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Item(CONJURED, 10, 20), 9, 18
                ),
                Arguments.of(
                    Item(CONJURED, 1, 20), 0, 18
                ),
                Arguments.of(
                    Item(CONJURED, 0, 20), -1, 16
                ),
                Arguments.of(
                    Item(CONJURED, -2, 20), -3, 16
                ),
                Arguments.of(
                    Item(CONJURED, 10, 0), 9, 0
                )
            )
        }
    }

    @ParameterizedTest(name = "$NORMAL_ITEM {0} should have sellIn {1} and quality {2} after update")
    @MethodSource("provideNormalItems")
    fun normalItem_should_decrease_correctly(item: Item, expectedSellIn: Int, expectedQuality: Int) {
        doTest(item, expectedSellIn, expectedQuality)
    }

    @ParameterizedTest(name = "$AGED_BRIE {0} should have sellIn {1} and quality {2} after update")
    @MethodSource("provideAgedBrieItems")
    fun agedBrie_should_increase_correctly(item: Item, expectedSellIn: Int, expectedQuality: Int) {
        doTest(item, expectedSellIn, expectedQuality)
    }

    @ParameterizedTest(name = "$BACKSTAGE {0} should have sellIn {1} and quality {2} after update")
    @MethodSource("provideBackstageItems")
    fun backstage_should_increase_correctly(item: Item, expectedSellIn: Int, expectedQuality: Int) {
        doTest(item, expectedSellIn, expectedQuality)
    }

    @Test
    fun sulfuras_should_never_change() {
        doTest(Item(SULFURAS, 10, 80), 10, 80)
    }

    @ParameterizedTest(name = "$CONJURED {0} should have sellIn {1} and quality {2} after update")
    @MethodSource("provideConjuredItems")
    fun conjured_should_decrease_correctly(item: Item, expectedSellIn: Int, expectedQuality: Int) {
        doTest(item, expectedSellIn, expectedQuality)
    }
}


