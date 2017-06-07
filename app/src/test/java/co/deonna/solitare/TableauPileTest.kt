package co.deonna.solitare

import org.junit.Test

import org.junit.Assert.*

class TableauPileTest {
    @Test
    fun testAddCards() {
        //arrange
        val tableauPile = TableauPile(mutableListOf(Card(12, spades)))
        val cards = mutableListOf(Card(11, hearts))
        //act
        tableauPile.addCards(cards)

        //assert
        assertEquals(2, tableauPile.cards.size)
    }

    @Test
    fun testRemoveCards() {

    }

}