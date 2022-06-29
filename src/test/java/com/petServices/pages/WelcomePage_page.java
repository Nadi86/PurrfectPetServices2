package com.petServices.pages;

import  com.petServices.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WelcomePage_page extends BasePage{


    @FindBy(xpath = "//a[.='Register your pet meow!!!']")
    public static WebElement register;

    @FindBy(xpath = "//a[.='Make new pet registration']")
    public static WebElement makeRegistration;

    @FindBy(id= "my_pet_registration_pet_name")
    public static WebElement petName;

    @FindBy(id= "my_pet_registration_pet_owner")
    public static WebElement petOwnerName;

    @FindBy(id= "my_pet_registration_color")
    public static WebElement color;

    @FindBy(xpath= "//select[@id='my_pet_registration_color']/option[4]")
    public static WebElement pickColor;

    @FindBy(id= "my_pet_registration_age")
    public static WebElement age;

    @FindBy(id= "my_pet_registration_description")
    public static WebElement description;

    @FindBy(id= "my_pet_registration_species_dog")
    public WebElement dog;


    @FindBy(id= "my_pet_registration_vaccination_status")
    public WebElement vaccinationStatus;

    @FindBy(xpath= "//select[@id='my_pet_registration_vaccination_status']/option[2]")
    public WebElement SelectVaccinationStatus;

    @FindBy(id= "my_pet_registration_membership")
    public WebElement membership;

    @FindBy(xpath= "//select[@id='my_pet_registration_membership']/option[2]")
    public WebElement selectMembership;

    @FindBy(xpath= "//input[@type='checkbox']")
    public List<WebElement> checkServices;

    @FindBy(xpath= "//input[@value='Register']")
    public static WebElement button;

    @FindBy(xpath= "//p[.='My pet registration was successfully created.']")
    public static WebElement registered;

    @FindBy(xpath= "//h2[contains(text(), '5 errors prohibited this my_pet_registration from being saved:')]")
    public static WebElement negativeResult;

}
