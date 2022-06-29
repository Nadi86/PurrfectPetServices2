package com.petServices.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePage extends BasePage {

    @FindBy(xpath = "//a[.='Go to pet registration']")
    public WebElement goToPetRegistration;

    @FindBy(xpath = "//a[.='Delete registration']")
    public WebElement deleteButton;

    @FindBy(xpath = "//p[.='My pet registration was successfully destroyed.']")
    public WebElement successfullyDestroyed;
}
