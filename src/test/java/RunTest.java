import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RunTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    @Before
    public void beforeTest(){
        // Launch Chrome Browser
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        // Create Webdriver Wait Object
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    @After
    public void afterTest(){
        // Close Chrome Browser
        webDriver.quit();
    }

    @Test
    public void testViewPriceOfIphone14Pro() throws InterruptedException {
        // Navigate to Apple official website
        webDriver.get("https://www.apple.com/");

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

    @Test
    public void testSearchIphone14ProMax() throws InterruptedException{
        // Navigate to Apple official website
        webDriver.get("https://www.apple.com/");

        // Assign searchButtonLocator locator
        By searchButtonLocator = By.id("ac-gn-link-search");

        // Wait searchButton to presence
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(searchButtonLocator));

        // Find searchButton
        WebElement searchButton = webDriver.findElement(searchButtonLocator);

        // Click searchButton
        searchButton.click();

        // Assign searchInputLocator locator
        By searchInputLocator = By.id("ac-gn-searchform-input");

        // Wait searchInput to presence
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(searchInputLocator));

        // Find searchInput
        WebElement searchInput = webDriver.findElement(searchInputLocator);

        // Send text to searchInput
        searchInput.sendKeys("iphone 14 Pro Max");

        // Sleep 5 seconds, so you can see the text entered
        Thread.sleep(5000);

        // Assign submitSearchButtonLocator locator
        By submitSearchButtonLocator = By.id("ac-gn-searchform-submit");

        // Wait searchInput to presence
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(submitSearchButtonLocator));

        // Find searchInput
        WebElement submitSearchButton = webDriver.findElement(submitSearchButtonLocator);

        // Click submitSearchButton
        submitSearchButton.click();

        // Sleep 5 seconds
        Thread.sleep(5000);
    }
}
