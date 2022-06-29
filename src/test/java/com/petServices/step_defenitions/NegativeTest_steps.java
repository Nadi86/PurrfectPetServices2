package com.petServices.step_defenitions;

import com.github.javafaker.Faker;
import com.petServices.pages.WelcomePage_page;
import com.petServices.utilities.ConfigurationReader;
import com.petServices.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static com.petServices.utilities.BrowserUtils.selectCheckBox;

public class NegativeTest_steps {
    Faker faker=new Faker();
    WelcomePage_page WelcomePage_page =new WelcomePage_page();
    @Given("User on welcome page on registration page")
    public void user_on_welcome_page_on_registration_page() {
        String url = ConfigurationReader.getProperty("pet_url");
        // from Configuration properties,
        // where we store all important data as URL, Login and Password
        Driver.getDriver().get(url);
    }
    @Given("User clicks on Register your pet button on registration page")
    public void user_clicks_on_register_your_pet_button_on_registration_page() {
        WelcomePage_page.register.click();
    }
    @When("User clicks on Make new pet registration button on registration page")
    public void user_clicks_on_make_new_pet_registration_button_on_registration_page() {
        WelcomePage_page.makeRegistration.click();
    }
    @When("user enters pet name on the registration page")
    public void user_enters_pet_name_on_the_registration_page() {
        String name=faker.dog().name();
        WelcomePage_page.petName.sendKeys(name);
    }
    @When("user enters pet owner the registration page")
    public void user_enters_pet_owner_the_registration_page() {
        WelcomePage_page.petOwnerName.sendKeys(faker.name().firstName());
    }

    @When("user selects color the registration page")
    public void user_selects_color_the_registration_page() {
        WelcomePage_page.color.click();
        selectCheckBox(WelcomePage_page.pickColor,true); // from BrowserUtils

    }
    @When("user selects age the registration page")
    public void user_selects_age_the_registration_page() {
        int age=10;
        WelcomePage_page.age.sendKeys(""+ Keys.DELETE);

        if(age>0&&age <=20) {

            WelcomePage_page.age.sendKeys(age + "");
        }else{
            System.err.println("Error - The age should be less than 20 or cannot be negative number");
        }
    }
    @When("user leaves blank description")
    public void user_leaves_blank_description() {
        String text=" ";
        WelcomePage_page.description.sendKeys("The dog is The dog is a pet animal. " +
                    "A dog has sharp teeth so that it can eat flesh very easily.");


    }
    @Then("verify user cannot submit the registration")
    public void verify_user_cannot_submit_the_registration() {
        WelcomePage_page.button.click();

        String expectedTitle="5 errors prohibited this my_pet_registration from being saved:";
        String actualTitle=WelcomePage_page.negativeResult.getText();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

}
