package com.newtours;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightTest extends BaseTest {

    private String noOfPassangers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setupParameter(String noOfPassangers,String expectedPrice)
    {
        this.noOfPassangers=noOfPassangers;
        this.expectedPrice=expectedPrice;
    }

    @Test
    public void RegistrationPageTest(){

        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("Sanjay","Gorai");
        registrationPage.enterUserCredential("Sanjay","Gorai");
        registrationPage.Submit();

    }

    @Test(dependsOnMethods = "RegistrationPageTest")
    public void RegistrationConfirmationPage()
    {
        RegistrationConfirmationPage registrationConfirmationPage=new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "RegistrationConfirmationPage")
    public void FlightDetailsPage()
    {
        FlightDetailsPage flightDetailsPage=new FlightDetailsPage(driver);
        flightDetailsPage.selectNoOfPassenger(noOfPassangers);
        flightDetailsPage.GoToFindFlightPage();
    }

    @Test(dependsOnMethods = "FlightDetailsPage")
    public void findDetailsPage()
    {
        FindFlightPage findFlightPage=new FindFlightPage(driver);
        findFlightPage.submitFindFlightPage();
        findFlightPage.GoToFlightConfirmationPage();
    }

   @Test(dependsOnMethods ="findDetailsPage" )
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage=new FlightConfirmationPage(driver);
       // Thread.sleep(2000);
        String actualPrice=flightConfirmationPage.TotalPrice();
       Assert.assertEquals(actualPrice,expectedPrice);
   }

   @AfterTest
    public void quitBrowser()
   {
       this.driver.quit();
   }
}
