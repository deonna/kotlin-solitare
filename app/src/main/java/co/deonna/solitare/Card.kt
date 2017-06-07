package co.deonna.solitare

val clubs = "Clubs"
val diamonds = "Diamonds"
val hearts = "Hearts"
val spades = "Spades"
val redCards = arrayOf(diamonds, hearts)
val blackCards = arrayOf(clubs, spades)

data class Card(val value: Int, val suit: String, var faceUp: Boolean = false)