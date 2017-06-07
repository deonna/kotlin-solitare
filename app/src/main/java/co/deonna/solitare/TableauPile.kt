package co.deonna.solitare

class TableauPile(val cards: MutableList<Card> = mutableListOf()) {

    init {
        if (cards.isNotEmpty()) {
            cards.last().faceUp = true
        }
    }

    fun addCards(newCards: MutableList<Card>): Boolean {

        if (cards.isNotEmpty()) {

            if (newCards.first().value == cards.last().value - 1
                    && isDifferentColor(cards.last(), newCards.first())) {

                cards.addAll(newCards)
                return true
            }
        } else if (newCards.first().value == 12) {

            cards.addAll(newCards)
            return true
        }

        return false
    }

    fun removeCards(tappedIndex: Int) {

        for (i in tappedIndex..cards.size) {
            cards.removeAt(i)
        }

        if (cards.isNotEmpty()) {
            cards.last().faceUp = true
        }
    }

    private fun isDifferentColor(c1: Card, c2: Card): Boolean {

        if (redCards.contains(c1.suit) && blackCards.contains(c2.suit)
                || blackCards.contains(c1.suit) && redCards.contains(c2.suit)) {

            return true
        }

        return false
    }
}