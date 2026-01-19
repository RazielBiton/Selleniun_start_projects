package Selleniun_start_projects.Selleniun_start_projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main( String[] args )
    {
        // This line replaces the need for setBinary or manual paths
        WebDriverManager.firefoxdriver().setup();
        
        WebDriver driver = new FirefoxDriver();
        
        driver.get("https://www.google.com");
        System.out.println("Title is: " + driver.getTitle());
        
        driver.quit();
    }
}