package Selleniun_start_projects.Selleniun_start_projects;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_calculator { // שינוי שם ל-PascalCase כמקובל ב-Java
    
    static WebDriver browser;
     
    @Before
    public void setup() {
        // הגדרת דרייבר אוטומטית שמתאימה ל-Mac
        WebDriverManager.firefoxdriver().setup();
        
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        String url = "https://testpages.eviltester.com/styled/apps/calculator.html";
        browser.get(url);
    }
     
    @Test
    public void testAddition() {
        // לחיצה על 1 + 2 =
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button02")).click();
        
        // לחיצה על שווה
        browser.findElement(By.id("buttonequals")).click();
        
        // שליפת התוצאה משדה התצוגה (שימוש ב-getAttribute כי זה שדה Input)
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        
        System.out.println("Calculation Result: " + result); 
        
        String expected = "3";
        assertEquals("The calculator should show 3", expected, result);
    }

    @After
    public void tearDown() {
        if (browser != null) {
            browser.quit(); // סוגר את הדפדפן כדי שלא יתקע את ה-Mac
        }
    }
}