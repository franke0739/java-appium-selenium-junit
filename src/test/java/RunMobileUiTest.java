import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class RunMobileUiTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    @Before
    public void beforeTest() throws MalformedURLException {
        // Set common desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //android automation
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "false");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "600000"); //milliseconds
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/bunyeechai/IdeaProjects/automation/hi-uat.apk");

        // Set android desired capabilities
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, "1234"); //must not in use

        // Launch Mobile App

        webDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

        // Create Webdriver Wait Object
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    @After
    public void afterTest(){
        // Close Chrome Browser
        webDriver.quit();
    }

    @Test
    public void testLoginHiAppByEmail() throws InterruptedException {
        // Assign Login Text
        By loginTextLocator = AppiumBy.androidUIAutomator("text(\"Login\")");

        // wait LoginText
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(loginTextLocator));

        // Click LoginText
        webDriver.findElement(loginTextLocator).click();

        // Assign EmailText
        By emailTextLocator = AppiumBy.androidUIAutomator("text(\"Email\")");

        // wait EmailText
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(emailTextLocator));

        // Click EmailText
        webDriver.findElement(emailTextLocator).click();

        // Assign EmailInput
        By emailInputLocator = AppiumBy.id("et_email");

        // wait EmailInput
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(emailInputLocator));

        // Input text to EmailInput
        webDriver.findElement(emailInputLocator).sendKeys("tester@hi.com");

        // Assign ContinueButton
        By continueButtonLocator = AppiumBy.id("login_button");

        // wait ContinueButton
        webDriverWait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));

        // Click ContinueButton
        webDriver.findElement(continueButtonLocator).click();

        // Sleep 5 seconds
        Thread.sleep(5000);
    }

}
