package com.petServices.step_defenitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ApiPutDefs {
    Response response;
    @Given("I logged Purrfect api using for updating")
    public void i_logged_purrfect_api_using_for_updating() {
        baseURI="https://sdet-challenge.herokuapp.com/api/v1/pet_registrations";
    }
    @When("I send PUT request endpoint")
    public void i_send_put_request_endpoint() {

        Map<String,Object> requestMap=new LinkedHashMap<>();

        requestMap.put("pet_name","Dogggie");

        response = given().auth().basic("sdet_challenge", "wackySumm3r")
                .and().accept(ContentType.JSON)
                .body(requestMap)
                .pathParam("id",377)
                .when().patch("/{id}");
    }
    @Then("I verify the status code is {int} after updating")
    public void i_verify_the_status_code_is_after_updating(Integer code) {
        Assertions.assertEquals(code,response.getStatusCode());
    }
}
