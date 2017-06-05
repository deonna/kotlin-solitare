package co.deonna.solitare

class TableauPile(val cards: MutableList<Card>) {

    init {
        cards.last().faceUp = true
    }

    fun addCards(newCards: MutableList<Card>): Boolean {

        if (cards.size > 0) {
            
            if (cards.last().value == newCards.first().value - 1
                    && isDifferentColor(cards.last(), cards.first())) {

                cards.addAll(newCards)
                return true
            }
        } else if (newCards.first().value == 12) {

            cards.addAll(newCards)
            return true
        }

        return false
    }

    private fun isDifferentColor(c1: Card, c2: Card): Boolean {

        if (redCards.contains(c1.suit) && blackCards.contains(c2.suit)
                || blackCards.contains(c1.suit) && redCards.contains(c2.suit)) {

            return true
        }

        return false
    }
}