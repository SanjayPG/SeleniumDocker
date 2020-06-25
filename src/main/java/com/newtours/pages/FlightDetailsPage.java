package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="passCount")
    private WebElement passengersDrp;

    @FindBy(name="findFlights")
    private WebElement continueBtn;

    public FlightDetailsPage(WebDriver driver)
    {
         this.driver=driver;
         wait=new WebDriverWait(driver,30);
         PageFactory.initElements(driver,this);
    }

    public void selectNoOfPassenger(String NoOfpassenger)
    {
        Select sel=new Select(passengersDrp);
        sel.selectByValue(NoOfpassenger);
    }

    public void GoToFindFlightPage()
    {

        continueBtn.click();

    }




}
