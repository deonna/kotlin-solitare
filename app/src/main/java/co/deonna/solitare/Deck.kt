package co.deonna.solitare

class Deck {

    val cards = Array(52, { Card(it % 13, getSuit(it)) })

    private fun getSuit(index: Int): String = when (index / 13) {
        0 -> "Clubs"
        1 -> "Diamonds"
        2 -> "Hearts"
        else -> "Spades"
    }
}