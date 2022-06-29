package com.petServices.step_defenitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;


import static io.restassured.RestAssured.*;

public class ApiPostDefs {

    Response response;
    @Given("I logged Purrfect api using")
    public void i_logged_purrfect_api_using() {
        baseURI="https://sdet-challenge.herokuapp.com/api/v1/pet_registrations";

    }
    @When("I send POST request endpoint")
    public void i_send_post_request_endpoint() {
        response = given().auth().basic("sdet_challenge", "wackySumm3r").
                accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                body("\"pet_name\":\"Misha\",\n" +
                        "\"pet_owner\":\"Mike\", \n" +
                        "\"color\":\"black\",\n" +
                        "\"description\": \"a scary GSD\",\n" +
                        "\"age\": 4,\n" +
                        "\"species\": \"dog\",\n" +
                        "\"vaccination_status\": true,\n" +
                        "\"membership\": true,\n" +
                        "\"services\" :[\"bath\",\"vitamins\"]")
                .when().post();


    }
    @Then("I verify the status code is {int}")
    public void i_verify_the_status_code_is(Integer int1) {
       Assertions.assertEquals(int1,response.getStatusCode());
    }
}
