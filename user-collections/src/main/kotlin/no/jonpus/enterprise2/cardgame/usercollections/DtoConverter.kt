package no.jonpus.enterprise2.cardgame.usercollections

import no.jonpus.enterprise2.cardgame.usercollections.db.CardCopy
import no.jonpus.enterprise2.cardgame.usercollections.db.User
import no.jonpus.enterprise2.cardgame.usercollections.dto.CardCopyDto
import no.jonpus.enterprise2.cardgame.usercollections.dto.UserDto

object DtoConverter {

    fun transform(user: User) : UserDto {

        return UserDto().apply {
            userId = user.userId
            coins = user.coins
            cardPacks = user.cardPacks
            ownedCards = user.ownedCards.map { transform(it) }.toMutableList()

        }
    }

    fun transform( cardCopy: CardCopy) : CardCopyDto{
        return CardCopyDto().apply {
            cardId = cardCopy.cardId
            numberOfCopies = cardCopy.numberOfCopies
        }
    }
}