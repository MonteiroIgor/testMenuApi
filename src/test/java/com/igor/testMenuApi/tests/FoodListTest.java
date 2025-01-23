package com.igor.testMenuApi.tests;

import com.igor.testMenuApi.config.GenericTest;
import com.igor.testMenuApi.model.User;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class FoodListTest extends GenericTest {

    @Test
    public void listAllFoods(){

        given()
                .header("Authorization", authorization)
                .contentType(ContentType.JSON)
        .when()
                .get("/food")
        .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .log()
                .all();

    }
}
