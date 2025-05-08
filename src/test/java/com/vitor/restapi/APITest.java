package com.vitor.restapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApiTest {

    private static final String BASE_URI = "https://jsonplaceholder.typicode.com";
    private static final String POSTS_ENDPOINT = "/posts";

    @Test
    public void getPosts() {
        RestAssured.baseURI = BASE_URI;

        Response response = RestAssured
                .given()
                .get(POSTS_ENDPOINT);

        assertEquals(200, response.getStatusCode());

        for (int i = 1; i <= 100; i++) {
            assertEquals(String.valueOf(i), response.jsonPath().getString("[" + (i - 1) + "].id"));
        }
        assertNotNull(response.jsonPath().getString("userId"));
        assertNotNull(response.jsonPath().getString("title"));
        assertNotNull(response.jsonPath().getString("body"));
    }
    @Test
    public void getPostOne(){
        RestAssured.baseURI = BASE_URI;

        Response response = RestAssured
                .given()
                .get(POSTS_ENDPOINT + "/1");

        assertEquals(200, response.getStatusCode());

        assertEquals("1", response.jsonPath().getString("id"));
        assertEquals("1", response.jsonPath().getString("userId"));
        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", response.jsonPath().getString("title"));
        assertEquals("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto", response.jsonPath().getString("body"));
    }
}