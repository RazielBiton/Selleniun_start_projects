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

public class passTest {
     
     static WebDriver browser;
     
     @Before
     public void setup() {
          // WebDriverManager דואג להוריד ולהגדיר את הדרייבר המתאים ל-Mac באופן אוטומטי
          WebDriverManager.firefoxdriver().setup();
          
          browser = new FirefoxDriver();
          browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 10 שניות זה בד"כ מספיק
          browser.get("https://testpages.eviltester.com/apps/7-char-val/.html");
     }
}