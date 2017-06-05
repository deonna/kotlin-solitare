package co.deonna.solitare

class GameModel {
    val Deck = Deck()
    val wastePile: MutableList<Card> = mutableListOf()
    val foundationPile: Array<FoundationPile> = arrayOf(
            FoundationPile("Clubs"),
            FoundationPile("Diamonds"),
            FoundationPile("Hearts"),
            FoundationPile("Spades")
    )
}