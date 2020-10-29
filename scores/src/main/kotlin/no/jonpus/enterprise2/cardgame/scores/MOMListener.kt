package no.jonpus.enterprise2.cardgame.scores

import no.jonpus.enterprise2.cardgame.scores.db.UserStatsService
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class MOMListener(
        private val statsService: UserStatsService
) {

    companion object {
        private val log = LoggerFactory.getLogger(MOMListener::class.java)
    }

    @RabbitListener(queues = ["#{queue.name}"])
    fun receiveFromAMQP(userId: String) {
        val ok = statsService.registerNewUser(userId)
        if(ok){
           log.info("Registered new user via MOM: $userId")
        }
    }


}