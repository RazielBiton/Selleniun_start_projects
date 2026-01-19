package Selleniun_start_projects.Selleniun_start_projects;

import static org.junit.Assert.assertNotEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelleninumTesting_2 {
	
	static WebDriver  browser;
	 
	 @Before
	  public void setup() {
		 
			  System.setProperty("webdriver.gecko.driver","/Users/mymac/Downloads/geckodriver.exe");
		      browser = new FirefoxDriver();
		  	  browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
		      browser.get("https://testpages.eviltester.com/styled/validation/input-validation.html");
		
	  }
		
	@Test
	public void Tests1() {
   	
		
			WebElement textBox = browser.findElement(By.id("firstname"));
			textBox.sendKeys("chaya");
			textBox = browser.findElement(By.id("surname"));
			textBox.sendKeys("Zilberstein");
			textBox = browser.findElement(By.id("age"));
			textBox.sendKeys("21");
			Select drpCountry = new Select(browser.findElement(By.name("country")));
			drpCountry.selectByVisibleText("Israel");
			String currentPage=browser.getCurrentUrl();
			browser.findElement(By.cssSelector("input[type='submit']")).click();
			String newPage = browser.getCurrentUrl();
			assertNotEquals(currentPage, newPage);
   }

}
