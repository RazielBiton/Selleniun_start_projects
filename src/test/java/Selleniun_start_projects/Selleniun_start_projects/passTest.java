package Selleniun_start_projects.Selleniun_start_projects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Before;
import org.junit.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class PassTest {
     
     static WebDriver browser;
     
     @Before
     public void setup() {
          WebDriverManager.firefoxdriver().setup();
          browser = new FirefoxDriver();
          browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          // הכתובת המדויקת של עמוד הבדיקה
          browser.get("https://testpages.eviltester.com/apps/7-char-val/");
     }

     @Test
     public void testValidInput() {
          // טסט טוב שבודק שהכל טוב
          WebElement input = browser.findElement(By.name("characters"));
          input.sendKeys("Abc123*"); 
          browser.findElement(By.name("validate")).click();
          
          String message = browser.findElement(By.name("validation_message")).getText();
          assertEquals("Valid Input", message);
     }

     @Test
     public void testInvalidCharacters() {
          // טסט ששם תווים לא חוקיים
          WebElement input = browser.findElement(By.name("characters"));
          input.sendKeys("Abc12#*"); 
          browser.findElement(By.name("validate")).click();
          
          String message = browser.findElement(By.name("validation_message")).getText();
          assertEquals("Invalid Input", message);
     }

     @Test
     public void testTooShort() {
          // טסט עם מספר תווים לא תקין
          WebElement input = browser.findElement(By.name("characters"));
          input.sendKeys("Abc1*"); 
          browser.findElement(By.name("validate")).click();
          
          String message = browser.findElement(By.name("validation_message")).getText();
          assertEquals("Invalid Input", message);
     }

     @Test
     public void testTooShort() {
          // טסט ללא מספרים
          WebElement input = browser.findElement(By.name("characters"));
          input.sendKeys("Abcdef*"); 
          browser.findElement(By.name("validate")).click();
          
          String message = browser.findElement(By.name("validation_message")).getText();
          assertEquals("Invalid Input", message);
     }
}