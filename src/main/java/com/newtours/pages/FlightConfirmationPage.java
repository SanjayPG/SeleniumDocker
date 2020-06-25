package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
    private WebElement lblFlightConfirmation;

     @FindBy(xpath = "//font[contains(text(),'USD')]")
     private List<WebElement> lblTotalPrice;

//     @FindBy(xpath = "a[contains(text(),'SIGN-OFF')]")
//     private WebElement lnkSignOff;

    @FindBy(linkText = "SIGN-OFF")
     private WebElement lnkSignOff;


    public  FlightConfirmationPage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public String TotalPrice()
    {
       // wait.until(ExpectedConditions.visibilityOf(lblFlightConfirmation));
         String lblprice=lblTotalPrice.get(1).getText();
        System.out.println(lblprice);
         return lblprice;

    }

     public void signOff()
     {
        lnkSignOff.click();
     }

}
