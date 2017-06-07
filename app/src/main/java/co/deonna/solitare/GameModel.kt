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

    fun onDeckTap() {

        if (deck.cardsInDeck.isNotEmpty()) {
            val card = deck.drawCard()
            card.faceUp = true
            wastePile.add(card)
        } else {
            deck.cardsInDeck = wastePile.toMutableList()
            wastePile.clear()
        }
    }

    fun onWasteTap() {

        if (wastePile.isNotEmpty()) {
            val card = wastePile.last()

            if (playCard(card)) {
                wastePile.remove(card)
            }
        }
    }

    fun onFoundationTap(foundationIndex: Int) {

        val foundationPile = foundationPiles[foundationIndex]
        
        if (foundationPile.cards.isNotEmpty()) {
            val card = foundationPile.cards.last()

            if (playCard(card))
                foundationPile.removeCard(card)
        }
    }

    private fun playCard(card: Card): Boolean {

        foundationPiles.forEach {
            if (it.addCard(card))
                return true
        }

        tableauPiles.forEach {
            if (it.addCards(mutableListOf(card))) {
                return true
            }
        }

        return false
    }
}