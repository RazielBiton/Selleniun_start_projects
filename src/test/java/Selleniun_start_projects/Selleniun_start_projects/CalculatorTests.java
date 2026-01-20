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

public class CalculatorTests { // שינוי שם ל-PascalCase כמקובל ב-Java
    
    static WebDriver browser;
     
    @Before
    public void setup() {
        // הגדרת דרייבר אוטומטית שמתאימה ל-Mac
        WebDriverManager.firefoxdriver().setup();
        
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        String url = "https://testpages.eviltester.com/apps/button-calculator/";
        browser.get(url);
    }

    // Addition tests
     
    @Test
    public void OnePlusThree() {
        // לחיצה על 1 + 2 =
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button03")).click();
        
        // לחיצה על שווה
        browser.findElement(By.id("buttonequals")).click();
        
        // שליפת התוצאה משדה התצוגה (שימוש ב-getAttribute כי זה שדה Input)
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        
        System.out.println("Calculation Result: " + result); 
        
        String expected = "4";
        assertEquals("The calculator should show 4", expected, result);
    }

    @Test
    public void FivePlusFive() {
        // לחיצה על 1 + 2 =
        browser.findElement(By.id("button05")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button05")).click();
        
        // לחיצה על שווה
        browser.findElement(By.id("buttonequals")).click();
        
        // שליפת התוצאה משדה התצוגה (שימוש ב-getAttribute כי זה שדה Input)
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        
        System.out.println("Calculation Result: " + result); 
        
        String expected = "10";
        assertEquals("The calculator should show 10", expected, result);
    }

    // Subtraction tests

    @Test
    public void FiveMinusOne() {
        // לחיצה על 1 + 2 =
        browser.findElement(By.id("button05")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button01")).click();
        
        // לחיצה על שווה
        browser.findElement(By.id("buttonequals")).click();
        
        // שליפת התוצאה משדה התצוגה (שימוש ב-getAttribute כי זה שדה Input)
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        
        System.out.println("Calculation Result: " + result); 
        
        String expected = "4";
        assertEquals("The calculator should show 4", expected, result);
    }

    @Test
    public void SixMinusTwo() {
        // לחיצה על 1 + 2 =
        browser.findElement(By.id("button06")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button02")).click();
        
        // לחיצה על שווה
        browser.findElement(By.id("buttonequals")).click();
        
        // שליפת התוצאה משדה התצוגה (שימוש ב-getAttribute כי זה שדה Input)
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        
        System.out.println("Calculation Result: " + result); 
        
        String expected = "4";
        assertEquals("The calculator should show 4", expected, result);
    }

    // Multiplication tests

    @Test
    public void SixMultiplySix() {
        // לחיצה על 1 + 2 =
        browser.findElement(By.id("button06")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button06")).click();
        
        // לחיצה על שווה
        browser.findElement(By.id("buttonequals")).click();
        
        // שליפת התוצאה משדה התצוגה (שימוש ב-getAttribute כי זה שדה Input)
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        
        System.out.println("Calculation Result: " + result); 
        
        String expected = "36";
        assertEquals("The calculator should show 36", expected, result);
    }

    @Test
    public void SixMultiplyTwo() {
        // לחיצה על 1 + 2 =
        browser.findElement(By.id("button06")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button02")).click();
        
        // לחיצה על שווה
        browser.findElement(By.id("buttonequals")).click();
        
        // שליפת התוצאה משדה התצוגה (שימוש ב-getAttribute כי זה שדה Input)
        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        
        System.out.println("Calculation Result: " + result); 
        
        String expected = "12";
        assertEquals("The calculator should show 12", expected, result);
    }

    @After
    public void tearDown() {
        if (browser != null) {
            browser.quit(); // סוגר את הדפדפן בסוף הטסט
        }
    }
}