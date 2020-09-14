import org.openqa.selenium.WebElement;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exception {
	static String chromePath, url;
	static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("google method is executing...");
		chromePath = "C:\\Webdrivers\\chromedriver.exe";
		url = "http://www.google.com";
	}
	@Test
	public void google() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",chromePath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.name("q")).sendKeys("java");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void exit() {
		System.out.println("google method execution Completed..!");
		driver.close();

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("SecondProgram Class is ready to test...");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("SecondProgram Class is tested..!");
	}

