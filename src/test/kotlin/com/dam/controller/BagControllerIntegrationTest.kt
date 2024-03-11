package com.dam.controller

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers.hasEntry
import org.junit.jupiter.api.Test

@QuarkusTest
class BagControllerIntegrationTest {

    @Test
    fun testGetUserBagsSuccess() {
        given()
            .contentType(ContentType.JSON)
        .`when`()
            .get("/bag/user/1")
        .then()
            .statusCode(200)
            .body("",
                hasItems(
                    allOf(
                        hasEntry("id", 1),
                        hasEntry("userId", 1),
                        hasEntry("name", "testbag"),
                        hasEntry("type", "grip")
                    ),
                    allOf(
                        hasEntry("id", 2),
                        hasEntry("userId", 1),
                        hasEntry("name", "testbag2"),
                        hasEntry("type", "pund")
                    )
                )
            )
    }

    //getUserWhenNoBags
    //successfully returns empty list
    @Test
    fun getUserWhenNoBags() {
        given()
            .contentType(ContentType.JSON)
        .`when`()
            .get("/bag/user/6")
        .then()
            .statusCode(200)
            .body(`is`("[]"))
    }

    //successfully create bag
    //assert valid ID is returned
    @Test
    fun testCreateBagSuccess() {

        val bagToBeCreated = """
            {
              "userId": 1,
              "type": "piound",
              "name": "test bag"
            }
        """.trimIndent()

        given()
            .contentType(ContentType.JSON)
            .body(bagToBeCreated)
        .`when`()
            .post("/bag/create")
        .then()
            .statusCode(200)
            .body(`is`("4"))
    }

    //no duplicate bags
    //successful when it returns same bagID, idempotent
}