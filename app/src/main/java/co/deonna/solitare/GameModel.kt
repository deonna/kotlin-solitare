package co.deonna.solitare

object GameModel {

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

    fun onTableauTap(tableauIndex: Int, cardIndex: Int) {

        val tableauPile = tableauPiles[tableauIndex]
        val cards = tableauPile.cards.subList(cardIndex, tableauPile.cards.lastIndex + 1)

        if (cards.isNotEmpty()) {
            if (playCards(cards)) {
                tableauPile.removeCards(cardIndex)
            }
        }
    }

    private fun playCards(cards: MutableList<Card>): Boolean {

        if (cards.size == 1)
            playCard(cards.first())

        tableauPiles.forEach {
            if (it.addCards(cards)) {
                return true
            }
        }

        return false
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