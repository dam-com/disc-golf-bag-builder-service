package com.dam.controller

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers.hasEntry
import org.junit.jupiter.api.Test

@QuarkusTest
class MainDiscControllerIntegrationTest {

    @Test
    fun testGetAllMainDiscsSuccess() {
        given()
            .contentType(ContentType.JSON)
        .`when`()
            .get("/maindisc")
        .then()
            .statusCode(200)
            .body("",
                hasItem(
                    allOf(
                        hasEntry("id", 1),
                        hasEntry("name", "Nord"),
                        hasEntry("manufacturer", "Kastaplast"),
                        hasEntry("speed", null),
                        hasEntry("glide", null),
                        hasEntry("turn", null),
                        hasEntry("fade", null),
                        hasEntry("description", null),
//                        hasEntry("maxWeight", "180.1"),
                        hasEntry("diameter", "21.7"),
                        hasEntry("height", "2"),
                        hasEntry("rimDepth", "1.3"),
                        hasEntry("insideRimDiameter", "19"),
                        hasEntry("rimThickness", "1.3"),
                        hasEntry("rimDepthDiameterRatio", "6"),
                        hasEntry("rimConfiguration", "47.5"),
                        hasEntry("flexibility", "7.73"),
                        hasEntry("approvedDate", "Feb 19, 2024")
                    )
                )
            )
    }
}