package co.deonna.solitare

class Deck {
    
    val cards: Array<Card> = Array(52, fun(index: Int): Card {

        val value = index % 13
        val suit = when (index) {
            0 -> "Clubs"
            1 -> "Diamonds"
            2 -> "Hearts"
            else -> "Spades"
        }

        return Card(value, suit)
    })
}