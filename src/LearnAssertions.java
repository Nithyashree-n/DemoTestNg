import org.openqa.selenium.WebDriver;
import org.testng.TestNGException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LearnAssertions {
	static String chromePath, url;  
	static WebDriver driver;

 

String path = System.getProperty("C:\\Users\\nithyashree.n");
     
@BeforeTest
public void SetDriver(){
	


System.setProperty("webdriver.chrome.driver",chromePath);
driver = new ChromeDriver();
driver.get(url);
   driver.manage().window().maximize();

 
}
@Test
public void verifyTitle()throws InterruptedException {
{
driver.get(https://www.amazon.com/);
String ActualTitle = driver.getTitle();
String ExpectedTitle = “Amazon.com: Online Shopping for Electronics, Apparel,
    Computers, Books, DVDs & more;
Assert.assertEquals(ActualTitle, ExpectedTitle);
System.out.println("Assert passed");


@AfterTest
public void closedriver(){

//closes the browser instance
driver.close();

}

   
