package org.openqa.selenium;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test; 
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class redbus {
     static FirefoxDriver driver;

   @BeforeMethod
      public void site() {
	String chromeDriverPath= System.getProperty("user.dir") + "geckodriver.exe";
	driver = new FirefoxDriver();
	
	 driver.navigate().to("https://www.redbus.in/");
	((Object) driver.manage()).window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
	public void login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement signin = (WebElement) driver.findElement(By.xpath("//a[@id='get_sign_in']"));
		signin.click();

		((Object) driver.switchTo()).frame("authiframe");
		WebElement facebook = (WebElement) driver.findElement(By.xpath("//button[@id='authFBSignInBtn']"));

		facebook.click();

		((Object) driver.manage()).timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String parent = driver.getWindowHandles();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				((Object) driver.switchTo()).window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Nithyashree@gmail.com");

				driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Nithya@786");
				driver.findElement(By.xpath("//input[@name='login']")).click();
				driver.close();
			}
			((Object) driver.switchTo()).window(parent);

		}
			}
	public void TripDetails() throws InterruptedException
	{
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		((WebElement) driver.findElement(By.xpath("//input[@id='src']"))).click();
		((WebElement) driver.findElement(By.xpath("//input[@id='src']"))).sendKeys("GOA");
		Thread.sleep(2000);
		((WebElement) driver.findElement(By.xpath(".//*[@id='search']/div/div[1]/div/ul/li[1]"))).click();
		Thread.sleep(5000);
		
		((WebElement) driver.findElement(By.xpath("//input[@id='dest']"))).click();
		((WebElement) driver.findElement(By.xpath("//input[@id='dest']"))).sendKeys("Mumbai");
		Thread.sleep(2000);
		((WebElement) driver.findElement(By.xpath(".//*[@id='search']/div/div[2]/div/ul/li[1]"))).click();
		Thread.sleep(5000);
		
		((WebElement) driver.findElement(By.xpath(".//*[@id='search']/div/div[3]/div/label"))).click();
		Thread.sleep(2000);
		
		String date = "10-Oct 2018";
		String splitter[] = date.split("-");
		String month_year = splitter[1];
		String day = splitter[0];	
		System.out.println(month_year);
		System.out.println(day);
		
		selectDate(month_year,day);		
		Thread.sleep(2000);
		((WebElement) driver.findElement(By.xpath(".//*[@id='search_btn']"))).click();
		Thread.sleep(5000);
		
		
	}	
	public void selectDate(String monthyear, String Selectday) throws InterruptedException
	{		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]"));
				
		for (int i=0; i<elements.size();i++)
		{
			System.out.println(elements.get(i).getText());
			//Selecting the month
			if(elements.get(i).getText().equals(monthyear))
			{				
				//Selecting the date				
				List<WebElement> days = driver.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
				
				for (WebElement d:days)
				{					
					System.out.println(d.getText());
					if(d.getText().equals(Selectday))
					{
						d.click();
						Thread.sleep(10000);
						return;
					}
				}								
				
			}			
					
		}
		((WebElement) driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]/button"))).click();
		selectDate(monthyear,Selectday);
		
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}
 
}