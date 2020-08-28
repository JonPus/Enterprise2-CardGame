package no.jonpus.enterprise2.cardgame.usercollections.model

import no.jonpus.enterprise2.cardgame.cards.dto.dto.CardDto
import no.jonpus.enterprise2.cardgame.cards.dto.dto.Rarity

data class Card(
        val cardId : String,
        val rarity: Rarity
){

    constructor(dto: CardDto): this(
            dto.cardId ?: throw IllegalArgumentException("Null cardId"),
            dto.rarity ?: throw IllegalArgumentException("Null rarity"))
}