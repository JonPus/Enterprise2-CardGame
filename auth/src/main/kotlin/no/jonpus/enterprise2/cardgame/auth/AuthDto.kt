package no.jonpus.enterprise2.cardgame.auth

import javax.validation.constraints.NotBlank

class AuthDto(

        @get:NotBlank
        var userId: String? = null,

        @get:NotBlank
        var password: String? = null
)