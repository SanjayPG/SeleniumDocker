package com.searchmodule.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author hp
 */
public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="q")
    private WebElement txtSearchBox;

    @FindBy(name="btnK")
    private WebElement btnSearch;

//    @FindBy(xpath="//a[@class='q qs']")
//    private WebElement lnkImge;

    @FindBy(xpath="//a/h3")
    private List<WebElement> lnkOfSearchPages;

    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void gotTo()
    {
        this.driver.get("https://www.google.com");
    }

    public void doSearch(String keyword)
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.txtSearchBox));
        txtSearchBox.sendKeys(keyword);
        btnSearch.submit();
    }

//    public void goToImage()
//    {
//        this.wait.until(ExpectedConditions.visibilityOf(this.lnkImge));
//        this.lnkImge.click();
//    }

   public int getNoOfLinks()
   {
       System.out.println(this.lnkOfSearchPages.size());
       return this.lnkOfSearchPages.size();
   }


}
