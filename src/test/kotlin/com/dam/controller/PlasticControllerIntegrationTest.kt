package com.dam.controller
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers.hasEntry
import org.junit.jupiter.api.Test
import io.quarkus.test.junit.QuarkusTest

@QuarkusTest
class PlasticControllerIntegrationTest {

    @Test
    fun testGetPlasticsSuccess() {
        given()
            .contentType(ContentType.JSON)
        .`when`()
            .get("/plastic")
        .then()
            .statusCode(200)
            .body("",
                hasItem(
                    allOf(
                        hasEntry("id", 1),
                        hasEntry("manufacturerId", 1),
                        hasEntry("name", "plasticname"),
                        hasEntry("description", "very plastic very nice"),
                        hasEntry("classification", "plastic classification")
                    )
                )
            )
    }

//    @Test
//    fun testGetDiscPlasticsSuccess() {
//        given()
//            .contentType(ContentType.JSON)
//        .`when`()
//            .get("/plastic/user/1/bag/1/disc/1/plastic/1")
        //to do we currently dont have anything in the sql to test this situation
    }

    @Test
    fun testCreatePlasticSuccess() {

        val plasticToBeCreated = """
            {
              "manufacturerId": 1,
              "name": "plastic2",
              "description": "hard",
              "classification": "plastic classification"
            }
        """.trimIndent()

        given()
            .contentType(ContentType.JSON)
            .body(plasticToBeCreated)
        .`when`()
            .post("/plastic/create")
        .then()
            .statusCode(201)
            .body(`is`("Plastic created with ID: 2"))
    }

}