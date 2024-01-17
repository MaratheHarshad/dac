package basic;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAmazonSearch {
	
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
  @Test
  public void performTest() {
	  
	  
	  // navigate to the amazon.in
	  driver.get("https://www.amazon.in/");
	  
	  // select search box in amazon.in and search
	  WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	  
	  String searchQuery = "laptop";
	  
	  // insert values
	  
	  searchBox.sendKeys(searchQuery);
	  
	  // select the search button and press
	  WebElement buttonElement = driver.findElement(By.id("nav-search-submit-button"));
	  
	  buttonElement.click();
	  
	  
	  // select the title to verify the expected result
	  
	  
	  
	  System.out.println(driver.getTitle());
	  
	  // compare the expected and actual
	  
	  assertEquals(driver.getTitle(), "Amazon.in : " + searchQuery);
	  
	  
  }
  
//  @AfterClass
//  public void tearDown() {
//	  
//	  if(driver != null) {
//		  driver.quit();
//	  }
//  }
}
