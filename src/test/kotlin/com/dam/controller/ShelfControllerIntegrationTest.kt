package com.dam.controller
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers.hasEntry
import org.junit.jupiter.api.Test
import io.quarkus.test.junit.QuarkusTest

@QuarkusTest
class ShelfControllerIntegrationTest {

    @Test
    fun testGetUserShelfSuccess() {
        given()
            .contentType(ContentType.JSON)
        .`when`()
            .get("/shelf/user/1")
        .then()
            .statusCode(200)
            .body("",
                hasItem(
                    allOf(
                        hasEntry("id", 1),
                        hasEntry("userId", 1),
                        hasEntry("discId", 1)
                    )
                )
            )
    }

    @Test
    fun testCreateShelf() {
        val shelfToBeCreated = """
            {
              "userId": 1,
              "discId": 2
            }
        """.trimIndent()

        given()
            .contentType(ContentType.JSON)
            .body(shelfToBeCreated)
        .`when`()
            .post("/shelf/create")
        .then()
            .statusCode(201)
            .body(`is`("Shelf created with ID: 2"))
    }

}