package no.jonpus.enterprise2.cardgame.cards

import io.restassured.RestAssured
import io.restassured.RestAssured.given
import no.jonpus.enterprise2.cardgame.cards.RestApi.Companion.LATEST
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.annotation.PostConstruct

@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [(Application::class)],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class RestApiTest{

    @LocalServerPort
    protected var port = 0

    @PostConstruct
    fun init(){
        RestAssured.baseURI = "http://localhost"
        RestAssured.port = port
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
    }


    @Test
    fun testGetImg(){

        given().get("/api/cards/imgs/001-monster.svg")
                .then()
                .statusCode(200)
                .contentType("image/svg+xml")
                .header("cache-control", `is`(notNullValue()))
    }

    @Test
    fun testGetCollection(){

        given().get("/api/cards/collection_$LATEST")
                .then()
                .statusCode(200)
                .body("data.cards.size", greaterThan(10))
    }


    @Test
    fun testGetCollectionOldVersion(){

        given().get("/api/cards/collection_v0_002")
                .then()
                .statusCode(200)
                .body("data.cards.size", greaterThan(10))
    }
}