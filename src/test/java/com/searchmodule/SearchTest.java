package com.searchmodule;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author hp
 */
public class SearchTest extends BaseTest {

  @Test()
  @Parameters({"keyword"})
  public void searchGoogleTest(String keyword)
  {
      SearchPage searchPage=new SearchPage(driver);
      searchPage.gotTo();
      searchPage.doSearch(keyword);
      int noOfLinks=searchPage.getNoOfLinks();
      Assert.assertTrue(noOfLinks>0);
  }

}
