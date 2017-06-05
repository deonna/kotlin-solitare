package co.deonna.solitare

class Deck {

    val cards: Array<Card> = Array(52, { index -> Card(index % 13, getSuit(index)) })

    private fun getSuit(index: Int): String = when (index) {
        0 -> "Clubs"
        1 -> "Diamonds"
        2 -> "Hearts"
        else -> "Spades"
    }
}