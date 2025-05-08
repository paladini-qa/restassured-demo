package com.vitor.restapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class APITest{

    @Test
    public void testGetPost(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = RestAssured.given().get("/posts/1");
        
        assertEquals(200, response.getStatusCode());
    }
}