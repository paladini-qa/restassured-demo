package com.vitor.restapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ApiTest {

    private static final String BASE_URI = "https://jsonplaceholder.typicode.com";
    private static final String POSTS_ENDPOINT = "/posts/1";

    @Test
    public void testGetPost() {
        RestAssured.baseURI = BASE_URI;

        Response response = RestAssured
                .given()
                .get(POSTS_ENDPOINT);

        assertEquals(200, response.getStatusCode());

        assertEquals("1", response.jsonPath().getString("id"));
        assertEquals("1", response.jsonPath().getString("userId"));
        assertEquals(
                "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                response.jsonPath().getString("title")
        );
        assertEquals(
                "quia et suscipit\nsuscipit\nsuscipit\nsuscipit\nsuscipit\nsuscipit\nsuscipit\nsuscipit\nsuscipit\nsuscipit",
                response.jsonPath().getString("body")
        );
    }
}