package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {

    static String browser = "FireFox";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        // 1. Open URL
        driver.get(baseUrl);

        // 2. Maximise the Browser
        driver.manage().window().maximize();

        // We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Print the title of the page
        System.out.println(driver.getTitle());

        // 4. print the current URL
        System.out.println("Current URL :" + driver.getCurrentUrl());

        // 5. Print the page source
        System.out.println("Page source :" + driver.getPageSource());

        //6. Enter the username to username field
        driver.findElement(By.name("username")).sendKeys("Admin");

        // 7. Enter password to password field
        driver.findElement(By.name("password")).sendKeys("admin123");

        // 8. Close the browser
        driver.close();

    }
}
