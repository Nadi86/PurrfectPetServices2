package com.petServices.step_defenitions;

import com.petServices.pages.DeletePage;
import com.petServices.utilities.ConfigurationReader;
import com.petServices.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static com.petServices.utilities.BrowserUtils.switchToWindow;
import static com.petServices.utilities.BrowserUtils.switchToWindowAlert;

public class DeletePage_steps {
   DeletePage deletePage=new DeletePage(); //created object to get the elements from pages

   @Given("User on registration page")
    public void user_on_registration_page() {
        String url = ConfigurationReader.getProperty("delete_url"); // from Configuration properties,
       // where we store all important data as URL, Login and Password
        Driver.getDriver().get(url);
    }
    @Given("User clicks on Delete button")
    public void user_clicks_on_delete_button() {
        deletePage.goToPetRegistration.click();
    }
    @Then("User verifies delete the registration")
    public void user_verifies_delete_the_registration() {
        deletePage.deleteButton.click();

    switchToWindowAlert(); // from BrowserUtils, switch the window to click OK
   String expectedResult="My pet registration was successfully destroyed.";
   String actualResult=deletePage.successfullyDestroyed.getText();
   Assert.assertEquals(expectedResult, actualResult); // Verified that the registration was deleted
    }
}
