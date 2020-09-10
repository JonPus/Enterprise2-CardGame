package no.jonpus.enterprise2.cardgame.scores

import no.jonpus.enterprise2.cardgame.scores.db.UserStats
import no.jonpus.enterprise2.cardgame.scores.dto.UserStatsDto

object DtoConverter {

    fun transform(stats: UserStats) : UserStatsDto =
            stats.run { UserStatsDto(userId, victories, defeats, draws, score)}

    fun transform(scores: Iterable<UserStats>) : List<UserStatsDto> = scores.map { transform(it) }
}