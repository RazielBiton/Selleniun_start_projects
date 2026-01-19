package Selleniun_start_projects.Selleniun_start_projects;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class root_calculator { // שיניתי את שם המחלקה לאות גדולה (סטנדרט ב-Java)
    
    static WebDriver browser;
    
    @Before
    public void setup() {
        // שימוש ב-WebDriverManager במקום נתיב ידני לדרייבר
        WebDriverManager.firefoxdriver().setup();
        
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.manage().window().maximize(); // מומלץ להגדיל את החלון כדי שהאלמנטים יהיו גלויים
        
        String url = "https://www.mathportal.org/calculators/polynomials-solvers/polynomial-roots-calculator.php";
        browser.get(url);
    }
    
    @Test
    public void testRootsCalculation() {
        // מציאת תיבת הטקסט והכנסת המשוואה
        WebElement inputField = browser.findElement(By.id("val1"));
        inputField.clear(); // ניקוי השדה לפני כתיבה
        inputField.sendKeys("x^2+4x+3");
        
        // לחיצה על כפתור החישוב
        browser.findElement(By.id("submitButton")).click();
        
        // שליפת התוצאה - שים לב: השתמשתי ב-getText() כדי לקבל את הטקסט האמיתי
        // ה-Selector שרשמת עשוי להשתנות, אז הוספתי הדפסה של הטקסט שנמצא
        try {
            // המתנה קלה כדי שהתוצאה תספיק להתרנדר
            Thread.sleep(2000); 
            
            // כאן כדאי לבדוק מה ה-ID או ה-CSS של התוצאה באתר. 
            // בדרך כלל התוצאה מופיעה בתוך דיב של results.
            WebElement resultElement = browser.findElement(By.id("res_area")); 
            String resultText = resultElement.getText();
            
            System.out.println("-------------------------");
            System.out.println("The calculation result is:");
            System.out.println(resultText);
            System.out.println("-------------------------");
            
        } catch (Exception e) {
            System.out.println("Could not find the result element: " + e.getMessage());
        }
    }
    
    @After
    public void tearDown() {
        if (browser != null) {
            browser.quit(); // חשוב מאוד לסגור את הדפדפן בסיום
        }
    }
}