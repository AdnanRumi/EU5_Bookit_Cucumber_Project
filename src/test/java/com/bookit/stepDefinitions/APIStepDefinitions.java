package com.bookit.stepDefinitions;

import com.bookit.utilities.BookitAPIUtils;
import com.bookit.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class APIStepDefinitions {

    String token;

    Response response;

    @Given("the user logged Bookit api using {string} and {string}")
    public void the_user_logged_bookit_api_using_and(String email, String password) {

       token = BookitAPIUtils.generateToken(email, password);

    }

    @When("the user gets the current user information from api")
    public void the_user_gets_the_current_user_information_from_api() {

         String url = ConfigurationReader.get("qa2api.uri") + "/api/users/me";

        response = RestAssured.given().accept(ContentType.JSON)
                .and().header("Authorization", token)
                .when().get(url);

    }

    @Then("status code should be {int}")
    public void status_code_should_be(int statusCode) {

        Assert.assertEquals(statusCode,response.getStatusCode());

    }

}
