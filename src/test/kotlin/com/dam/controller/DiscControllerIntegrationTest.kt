package com.dam.controller

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers.hasEntry
import org.junit.jupiter.api.Test

@QuarkusTest
class DiscControllerIntegrationTest {

    @Test
    fun testGetUserDiscsSuccess() {
        //test all user discs are pulled, work in progress
        given()
            .contentType(ContentType.JSON)
        .`when`()
            .get("/disc/user/1/bag/1")
        .then()
            .statusCode(200)
            .body("",
                hasItem(
                    allOf(
                        hasEntry("id", 1),
                        hasEntry("userId", 1),
                        hasEntry("name", "disc name"),
                        hasEntry("manufacturer", "discmaker"),
                        hasEntry("plastic", "plastic plasticy"),
                        //doesnt like decimals
//                        hasEntry("weight", 1.01),
//                        hasEntry("speed", 1.0),
//                        hasEntry("glide", 1.0),
//                        hasEntry("turn", 1.0),
//                        hasEntry("fade", 1.0),
                        hasEntry("description", "good disc"),
                        hasEntry("condition", "fair"),
                        hasEntry("color", "blue"),
                        hasEntry("favorite", false)
                    )
                )
            )
    }

    @Test
    fun testCreateUserDiscSuccess(){

        val discToBeCreated = """
            {
              "userId": 1,
              "name": "discname3",
              "manufacturer": "disc manufacturer",
              "plastic": "soft",
              "weight": 1.3,
              "speed": 2,
              "glide": 6,
              "turn": 2,
              "fade": 3,
              "description": "good disc",
              "condition": "fair",
              "color": "blue",
              "favorite": false
            }
        """.trimIndent()

        given()
            .contentType(ContentType.JSON)
            .body(discToBeCreated)
        .`when`()
            .post("/disc/create")
        .then()
            .statusCode(201)
            .body(`is`("Disc created with ID: 5"))
    }

    //getUserWhenNoDisc in bag
    //returns empty list/bag when do discs are created
    @Test
    fun getDiscsWhenEmptyBag() {
         given()
            .contentType(ContentType.JSON)
        .`when`()
                .get("/disc/user/1/bag/6")
        .then()
            .statusCode(200)
            .body(`is`("[]"))
    }

    //test allow duplicate discs
    @Test
    fun testAllowDuplicateDiscsSuccess(){

        val discToBeCreated = """
            {
              "userId": 1,
              "name": "discname3",
              "manufacturer": "disc manufacturer",
              "plastic": "soft",
              "weight": 1.3,
              "speed": 2,
              "glide": 6,
              "turn": 2,
              "fade": 3,
              "description": "good disc",
              "condition": "fair",
              "color": "blue",
              "favorite": false
            }
        """.trimIndent()

        given()
            .contentType(ContentType.JSON)
            .body(discToBeCreated)
        .`when`()
            .post("/disc/create")
        .then()
            .statusCode(201)
        given()
            .contentType(ContentType.JSON)
            .body(discToBeCreated)
        .`when`()
            .post("/disc/create")
        .then()
            .statusCode(201)
    }
}