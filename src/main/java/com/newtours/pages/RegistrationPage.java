package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstNameTxt;

    @FindBy(name="lastName")
    private WebElement lastNameTxt;

    @FindBy(name="Email")
    private WebElement emailTxt;

    @FindBy(name="password")
    private WebElement PasswordTxt;

    @FindBy(name="confirmPassword")
    private WebElement ConfirmPasswordTxt;

    @FindBy(name="register")
    private WebElement SubmitBtn;

    public RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTo() {
        this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
    }

    public void enterUserDetails(String UserName,String Password)
    {
        firstNameTxt.sendKeys(UserName);
        lastNameTxt.sendKeys(Password);
    }

    public void enterUserCredential(String userName,String password)
    {
        firstNameTxt.sendKeys(userName);
        lastNameTxt.sendKeys(password);
        lastNameTxt.sendKeys(password);
    }

    public void Submit()
    {
        this.SubmitBtn.submit();
    }






}
