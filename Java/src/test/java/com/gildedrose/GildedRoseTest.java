package com.gildedrose;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {


    @Test
    public void shouldDegradeAnOrdinaryItemByOne() {
        Item item = new Item("Ordinary", 6, 5);
        Item[] itemsArray = new Item[]{item};

        GildedRose gildedRose = new GildedRose(itemsArray);

        gildedRose.updateItems();

        assertThat(itemsArray[0].getQuality(), is(4));
        assertThat(itemsArray[0].sellIn, is(5));
    }

    @Test
    public void shouldDegradeOrdinaryItemTwiceAsQuickAfterSellInDate() {
        Item item = new Item("Ordinary", 0, 5);
        Item[] itemsArray = new Item[]{item};

        GildedRose gildedRose = new GildedRose(itemsArray);

        gildedRose.updateItems();

        assertThat(itemsArray[0].getQuality(), is(3));
        assertThat(itemsArray[0].sellIn, is(-1));
    }

    @Test
    public void shouldNotDecreaseQualityIfZero(){
        Item item = new Item("Any",0,0 );
        Item[] itemsArray = new Item[]{item};

        GildedRose gildedRose = new GildedRose(itemsArray);

        gildedRose.updateItems();

        assertThat(itemsArray[0].getQuality(), is(0));
        assertThat(itemsArray[0].sellIn, is(-1));

    }

    @Test
    public void shouldIncreaseQualityOfAgedBrieWithAge(){
        Item item = new AgedBrie("Aged Brie",8,3 );
        Item[] itemsArray = new Item[]{item};

        GildedRose gildedRose = new GildedRose(itemsArray);

        gildedRose.updateItems();

        assertThat(itemsArray[0].getQuality(), is(4));
        assertThat(itemsArray[0].sellIn, is(7));
    }

    @Test
    public void shouldNeverIncreaseQualityMoreThanFifty(){
        Item item = new AgedBrie("Aged Brie",-1,50 );
        Item[] itemsArray = new Item[]{item};

        GildedRose gildedRose = new GildedRose(itemsArray);

        gildedRose.updateItems();

        assertThat(itemsArray[0].getQuality(), is(50));
        assertThat(itemsArray[0].sellIn, is(-2));
    }

    @Test
    public void shouldNeverAlterSulfurasQualityOrSellIn(){
        Item item = new Sulfuras("Sulfuras, Hand of Ragnaros",0,80 );
        Item[] itemsArray = new Item[]{item};

        GildedRose gildedRose = new GildedRose(itemsArray);

        gildedRose.updateItems();

        assertThat(itemsArray[0].getQuality(), is(80));
        assertThat(itemsArray[0].sellIn, is(0));
    }

    @Test
    public void shouldIncreasebackStagePassesInQualityAsSellInValueApproaches(){
        Item item = new BackstagePass("Backstage passes to a TAFKAL80ETC concert",10,5 );
        Item[] itemsArray = new Item[]{item};

        GildedRose gildedRose = new GildedRose(itemsArray);

        gildedRose.updateItems();

        assertThat(itemsArray[0].getQuality(), is(7));
        assertThat(itemsArray[0].sellIn, is(9));
    }

    @Test
    public void shouldIncreaseBackStagePassesByThreeWhenFiveDays(){
        Item item = new BackstagePass("Backstage passes to a TAFKAL80ETC concert",5,5 );
        Item[] itemsArray = new Item[]{item};

        GildedRose gildedRose = new GildedRose(itemsArray);

        gildedRose.updateItems();

        assertThat(itemsArray[0].getQuality(), is(8));
        assertThat(itemsArray[0].sellIn, is(4));
    }
    @Test
    public void shouldDropQualityOfBackStagePassesTo0AfterTheConcert() {
        Item item = new BackstagePass("Backstage passes to a TAFKAL80ETC concert",0,5 );
        Item[] itemsArray = new Item[]{item};

        GildedRose gildedRose = new GildedRose(itemsArray);

        gildedRose.updateItems();

        assertThat(itemsArray[0].getQuality(), is(0));
        assertThat(itemsArray[0].sellIn, is(-1));
    }
}
