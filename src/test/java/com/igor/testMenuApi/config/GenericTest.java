package com.igor.testMenuApi.config;

import com.igor.testMenuApi.TestMenuApiApplicationTests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.given;

@ActiveProfiles(profiles = "test")
@SpringBootTest(classes = {TestMenuApiApplicationTests.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GenericTest {
    protected String authorization;
    public String token;
    private boolean init;

    @BeforeEach
    public void init() {
        if (init)
            return;
        new GenericTest();
        try {
            authorization = getJwt();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        init = true;
    }

    public GenericTest() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    public String getJwt() throws JSONException {
        JSONObject auth = new JSONObject();
        auth.put("login", "igormonteiro2");
        auth.put("password", "123456789");
        JSONObject token = new JSONObject(
                given().
                        contentType(ContentType.JSON).
                        body(auth.toString()).
                        when().
                        post("http://localhost:8080/auth/login").
                        then().
                        extract().response().asString()
        );
        auth = token;
        return auth.getString("token");
    }
}
