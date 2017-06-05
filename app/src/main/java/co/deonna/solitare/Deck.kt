package co.deonna.solitare

import java.util.*

class Deck {

    val cards = Array(52, { Card(it % 13, getSuit(it)) })
    var cardsInDeck = cards.toMutableList();

    fun drawCard(): Card = cardsInDeck.removeAt(0)

    fun reset() {
        cardsInDeck = cards.toMutableList()
        Collections.shuffle(cardsInDeck)
    }

    private fun getSuit(index: Int): String = when (index / 13) {
        0 -> "Clubs"
        1 -> "Diamonds"
        2 -> "Hearts"
        else -> "Spades"
    }
}