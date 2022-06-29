package com.petServices.step_defenitions;

import com.github.javafaker.Faker;
import com.petServices.pages.WelcomePage_page;
import com.petServices.utilities.ConfigurationReader;
import com.petServices.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.petServices.utilities.BrowserUtils.selectCheckBox;
import static com.petServices.utilities.BrowserUtils.waitFor;

public class WelcomePage_steps {
    WelcomePage_page WelcomePage_page =new WelcomePage_page(); //created object to get the elements from pages
    Faker faker=new Faker();
    @Given("User on welcome page")
    public void i_am_on_welcome_page() {
        String url = ConfigurationReader.getProperty("pet_url");
        // from Configuration properties,
        // where we store all important data as URL, Login and Password
       Driver.getDriver().get(url);

    }
    @And("User clicks on Register your pet button")
    public void i_click_on_register_your_pet_button() {
        WelcomePage_page.register.click(); //from Pages
    }

    @When("User clicks on Make new pet registration button")
    public void user_clicks_on_make_new_pet_registration_button() {
      WelcomePage_page.makeRegistration.click();
    }
    @When("user enters pet name")
    public void user_enters_pet_name() {

      String name=faker.dog().name();
        WelcomePage_page.petName.sendKeys(name);
    }
    @When("user enters pet owner")
    public void user_enters_pet_owner() {
        WelcomePage_page.petOwnerName.sendKeys(faker.name().firstName());
    }
    @When("user selects color")
    public void user_selects_color() {
        WelcomePage_page.color.click();
         selectCheckBox(WelcomePage_page.pickColor,true); // from BrowserUtils

    }

    @When("user selects age")
    public void user_selects_age() {
      int age=10;
        WelcomePage_page.age.sendKeys(""+Keys.DELETE);

      if(age>0&&age <=20) {

          WelcomePage_page.age.sendKeys(age + "");
      }else{
          System.err.println("Error - The age should be less than 20 or cannot be negative number");
      }
    }
    @When("user enters description")
    public void user_enters_description() {
        String text="The dog is The dog is a pet animal." +
                "A dog has sharp teeth so that it can eat flesh very easily.";

        WelcomePage_page.description.sendKeys(text);


    }
    @When("user clicks species")
    public void user_clicks_species() {
        WelcomePage_page.dog.click();
    }
    @When("user selects vaccination status")
    public void user_selects_vaccination_status() {
        WelcomePage_page.vaccinationStatus.click();
        selectCheckBox(WelcomePage_page.SelectVaccinationStatus,true);

    }

    @When("user selects purrfect Membership")
    public void user_selects_purrfect_membership() {
        WelcomePage_page.membership.click();
        selectCheckBox(WelcomePage_page.selectMembership,true);

    }

    @When("user clicks service needed")
    public void user_clicks_service_needed() {

       List<WebElement> allCheckBoxes = WelcomePage_page.checkServices;
       for (WebElement allCheckBox : allCheckBoxes) {
       allCheckBox.click();
        }


}
    @Then("verify user registered the pet")
    public void verify_user_registered_the_pet() {
      waitFor(2);
        WelcomePage_page.button.click();
        String expectedTitle="My pet registration was successfully created.";
        String actualTitle=WelcomePage_page.registered.getText();

       Assert.assertEquals(expectedTitle, actualTitle);


    }




}
