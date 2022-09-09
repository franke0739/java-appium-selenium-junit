import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RunTest {

    @Test
    public void testBuyIphone14Pro() throws InterruptedException {
        // Launch Chrome Browser
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        // Navigate to Apple official website
        webDriver.get("https://www.apple.com/");

        // Create Webdriver Wait Object
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));

        // Assign iphoneLinkLocator locator
        By iphoneLinkLocator = By.className("ac-gn-link-iphone");

        // Wait iphoneLink to presence
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(iphoneLinkLocator));

        // Find iphoneLink
        WebElement iphoneLink = webDriver.findElement(iphoneLinkLocator);

        // Click iphoneLink
        iphoneLink.click();

        // Assign iphone14LinkLocator locator
        By iphone14LinkLocator = By.className("chapternav-item-iphone-14-pro");

        // Wait iphone14Link to presence
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(iphone14LinkLocator));

        // Find iphone14Link
        WebElement iphone14Link = webDriver.findElement(iphone14LinkLocator);

        // Click iphone14Link
        iphone14Link.click();

        // Assign iphone14LinkLocator locator
        By viewPricingButtonLocator = By.className("ac-ln-action-button");

        // Wait viewPricingButton to presence
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(viewPricingButtonLocator));

        // Find viewPricingButton
        WebElement viewPricingButton = webDriver.findElement(viewPricingButtonLocator);

        // Click viewPricingButton
        viewPricingButton.click();

        // Sleep 5 seconds
        Thread.sleep(5000);
    }
}
