package com.petServices.step_defenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;


import static io.restassured.RestAssured.*;

public class ApiGetDefs {

    Response response ;

    @Given("Status Code should be {int}")
    public void status_code_should_be(Integer int1) {
    baseURI="https://sdet-challenge.herokuapp.com/api/v1/pet_registrations";

    response = given().auth().basic("sdet_challenge", "wackySumm3r")
              .and().accept(ContentType.JSON)
              .and().when().get("");
  }
    @When("I send a GET request to url")
    public void i_send_a_get_request_to_url() {
    response.getStatusCode();
    }
    @Then("status code must be {int}")
    public void status_code_must_be(Integer int1) {
    Assertions.assertEquals(int1,response.getStatusCode());

   }

    Response response1;


    @Given("endpoint retrieves a specific registration")
    public void endpoint_retrieves_a_specific_registration() {
        baseURI="https://sdet-challenge.herokuapp.com/api/v1/pet_registrations";
        response1 = given().auth().basic("sdet_challenge", "wackySumm3r").
                accept(ContentType.JSON).when().
                pathParam("id", 377)
                .when()
                .get("/{id}");


    }
    @When("I send a GET request")
    public void i_send_a_get_request() {
        System.out.println("response1.getStatusCode() = " + response1.getStatusCode());
    }
    @Then("status code must be {int} with endpoint")
    public void status_code_must_be_with_endpoint(Integer int1) {
        Assertions.assertEquals(int1,response1.getStatusCode());
    }

}
