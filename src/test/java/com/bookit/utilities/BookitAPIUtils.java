package com.bookit.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookitAPIUtils {

    public static String generateToken(String email, String password){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("email", email)
                .and().queryParam("password", password)
                .when().get(ConfigurationReader.get("qa2api.uri") + "/sign");

        String token = response.path("accessToken");

        String finalToken = "Bearer "+ token;
        System.out.println("finalToken = " + finalToken);

        return finalToken;
    }
}
