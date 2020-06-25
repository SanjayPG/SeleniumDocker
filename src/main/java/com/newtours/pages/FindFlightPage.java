package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

     @FindBy(name="reserveFlights")
     private WebElement BtnFirstSumbit;

    @FindBy(name="buyFlights")
    private WebElement BtnSecondSumbit;

    public FindFlightPage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void submitFindFlightPage()
    {
        wait.until(ExpectedConditions.elementToBeClickable(BtnFirstSumbit));
        BtnFirstSumbit.click();
    }

    public void GoToFlightConfirmationPage()
    {
       // wait.until(ExpectedConditions.elementToBeClickable(BtnFirstSumbit));
        BtnSecondSumbit.click();
    }








}
