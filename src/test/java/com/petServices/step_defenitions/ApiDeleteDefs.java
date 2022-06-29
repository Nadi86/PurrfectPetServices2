package com.petServices.step_defenitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ApiDeleteDefs {

    Response response;
    @Given("I logged Purrfect api using a Specific Registration")
    public void i_logged_purrfect_api_using_a_specific_registration() {
        baseURI="https://sdet-challenge.herokuapp.com/api/v1/pet_registrations";
    }
    @When("I send Delete request")
    public void i_send_delete_request() {
        response = given().auth().basic("sdet_challenge", "wackySumm3r")
                .and().pathParam("id", 377)
                .when().delete("{id}");
    }
    @Then("I verify the status code is {int} a Specific Registration")
    public void i_verify_the_status_code_is_a_specific_registration(Integer code) {
        Assertions.assertEquals(code,response.getStatusCode());
    }
}
