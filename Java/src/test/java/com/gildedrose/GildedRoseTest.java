package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.gildedrose.items.CustomItem.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private void doTest(Item[] items, int expectedSellIn, int expectedQuality) {
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(expectedSellIn, app.getItems()[0].sellIn);
        assertEquals(expectedQuality, app.getItems()[0].quality);
    }

    private static Stream<Arguments> provideNormalItems() {
        String NORMAL_ITEM = "normal-item";
        return Stream.of(
            Arguments.of(
                new Item(NORMAL_ITEM, 10, 20), 9, 19
            ),
            Arguments.of(
                new Item(NORMAL_ITEM, 1, 20), 0, 19
            ),
            Arguments.of(
                new Item(NORMAL_ITEM, 0, 20), -1, 18
            ),
            Arguments.of(
                new Item(NORMAL_ITEM, -2, 20), -3, 18
            ),
            Arguments.of(
                new Item(NORMAL_ITEM, 10, 0), 9, 0
            )
        );
    }

    private static Stream<Arguments> provideAgedBrieItems() {
            return Stream.of(
                Arguments.of(
                    new Item(AGED_BRIE, 10, 20), 9, 21
                ),
                Arguments.of(
                    new Item(AGED_BRIE, 10, 50), 9, 50
                ),
                Arguments.of(
                    new Item(AGED_BRIE, 1, 0), 0, 1
                ),
                Arguments.of(
                    new Item(AGED_BRIE, 0, 0), -1, 2
                ),
                Arguments.of(
                    new Item(AGED_BRIE, -2, 4), -3, 6
                ),
                Arguments.of(
                    new Item(AGED_BRIE, -2, 48), -3, 50
                ),
                Arguments.of(
                    new Item(AGED_BRIE, -2, 49), -3, 50
                )
            );
        }

    private static Stream<Arguments> provideBackstageItems() {
            return Stream.of(
                Arguments.of(
                    new Item(BACKSTAGE, 11, 20), 10, 21
                ),
                Arguments.of(
                    new Item(BACKSTAGE, 10, 20), 9, 22
                ),
                Arguments.of(
                    new Item(BACKSTAGE, 6, 20), 5, 22
                ),
                Arguments.of(
                    new Item(BACKSTAGE, 5, 20), 4, 23
                ),
                Arguments.of(
                    new Item(BACKSTAGE, 0, 20), -1, 0
                ),
                Arguments.of(
                    new Item(BACKSTAGE, 11, 49), 10, 50
                ),
                Arguments.of(
                    new Item(BACKSTAGE, 11, 50), 10, 50
                ),
                Arguments.of(
                    new Item(BACKSTAGE, 10, 48), 9, 50
                ),
                Arguments.of(
                    new Item(BACKSTAGE, 10, 49), 9, 50
                ),
                Arguments.of(
                    new Item(BACKSTAGE, 5, 47), 4, 50
                ),
                Arguments.of(
                    new Item(BACKSTAGE, 5, 48), 4, 50
                )
            );
        }

    private static Stream<Arguments> provideConjuredItems() {
        return Stream.of(
            Arguments.of(
                new Item(CONJURED, 10, 20), 9, 18
            ),
            Arguments.of(
                new Item(CONJURED, 1, 20), 0, 18
            ),
            Arguments.of(
                new Item(CONJURED, 0, 20), -1, 16
            ),
            Arguments.of(
                new Item(CONJURED, -2, 20), -3, 16
            ),
            Arguments.of(
                new Item(CONJURED, 10, 0), 9, 0
            )
        );
    }

    @ParameterizedTest
    @MethodSource("provideNormalItems")
    void normalItem_should_decrease_correctly(Item item, int expectedSellIn, int expectedQuality) {
        doTest(new Item[]{item}, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @MethodSource("provideAgedBrieItems")
    void agedBrie_should_increase_correctly(Item item, int expectedSellIn, int expectedQuality) {
        doTest(new Item[]{item}, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @MethodSource("provideBackstageItems")
    void backstage_should_increase_correctly(Item item, int expectedSellIn, int expectedQuality) {
        doTest(new Item[]{item}, expectedSellIn, expectedQuality);
    }

    @Test
    void sulfuras_should_never_change() {
        doTest(new Item[]{new Item(SULFURAS, 10, 80)}, 10, 80);
    }

    @ParameterizedTest
    @MethodSource("provideConjuredItems")
    void conjured_should_decrease_correctly(Item item, int expectedSellIn, int expectedQuality) {
        doTest(new Item[]{item}, expectedSellIn, expectedQuality);
    }

}
