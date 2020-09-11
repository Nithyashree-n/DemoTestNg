import org.testng.annotations.Test;


import org.testng.annotations.Test;

 

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Webdriver {
   
	public String baseUrl = "https://www.amazon.com/";
    String driverPath = "C:\\geckodriver.exe";
    public FirefoxDriver driver ; 
     
  @Test
  public void verifyHomepageTitle()throws InterruptedException  {
       
      System.out.println("launching firefox browser"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
       driver = new FirefoxDriver();
      driver.get(baseUrl);
      String expectedTitle = "Online Shopping for Electronics, Apparel,\n" + 
      		"    Computers, Books, DVDs & more";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.close();
  }
}