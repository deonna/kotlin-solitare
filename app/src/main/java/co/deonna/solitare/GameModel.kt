package co.deonna.solitare

class GameModel {
    
    val deck = Deck()
    val wastePile: MutableList<Card> = mutableListOf()
    val foundationPiles: Array<FoundationPile> = arrayOf(
            FoundationPile(clubs),
            FoundationPile(diamonds),
            FoundationPile(hearts),
            FoundationPile(spades)
    )
    val tableauPiles: Array<TableauPile> = Array(7, { TableauPile() })

    fun resetGame() {

        wastePile.clear()
        foundationPiles.forEach { it.reset() }
        deck.reset()

        tableauPiles.forEachIndexed { i, tableauPile ->
            val cardsInPile: MutableList<Card> = Array(i + 1, { deck.drawCard() }).toMutableList()
            tableauPiles[i] = TableauPile(cardsInPile)
        }
    }
}