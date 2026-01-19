package Selleniun_start_projects.Selleniun_start_projects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Before;
import org.junit.After; // כדאי להוסיף כדי לסגור את הדפדפן בסיום
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertNotEquals;

public class AppTest {
     
     static WebDriver browser;
     
     @Before
     public void setup() {
          // WebDriverManager דואג להוריד ולהגדיר את הדרייבר המתאים ל-Mac באופן אוטומטי
          WebDriverManager.firefoxdriver().setup();
          
          browser = new FirefoxDriver();
          browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 10 שניות זה בד"כ מספיק
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
            
            String currentPage = browser.getCurrentUrl();
            
            // לחיצה על כפתור השליחה
            browser.findElement(By.cssSelector("input[type='submit']")).click();
            
            String newPage = browser.getCurrentUrl();
            
            // בדיקה שהכתובת השתנתה (כלומר הטופס נשלח בהצלחה)
            assertNotEquals(currentPage, newPage);
    }
}