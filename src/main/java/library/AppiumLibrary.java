package library;

/**
 * author Sarthak
 */

import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sessions.SessionManager;

import java.util.*;

public class AppiumLibrary {
    private AppiumDriver driver;
    private Logger logger = Logger.getLogger(AppiumLibrary.class);
    private ElementLocator elementLocator = new ElementLocator();
    private int DEFAULT_TIME_OUT = Constants.ELEMENT_EXPLICIT_WAIT;

    public AppiumLibrary(SessionManager sessionManager) {
        this.driver = sessionManager.getDriver();
    }

    public void click(String element) {
        isElementPresent(element, DEFAULT_TIME_OUT);
        MobileElement mobileElement = getElememnt(element);
        mobileElement.click();
    }

    public void click(MobileElement element) {
        element.click();
    }

    public void clickIfPresent(String element) {
        boolean isPresent = isElementPresent(element, DEFAULT_TIME_OUT);
        if (isPresent) {
            logger.info("Element " + element + " present and clicking on it.");
            MobileElement mobileElement = getElememnt(element);
            mobileElement.click();
        } else {
            logger.warn("Element " + element + " not present on screen..");
        }
    }

    public void enterText(String element, String text) {
        isElementPresent(element, DEFAULT_TIME_OUT);
        MobileElement mobileElement = getElememnt(element);
        click(mobileElement);
        mobileElement.sendKeys(text);
    }

    public int getScreenHeight() {
        return driver.manage().window().getSize().getHeight();
    }

    public int getScreenWidth() {
        return driver.manage().window().getSize().getWidth();
    }


    public boolean isElementPresent(String element, int time) {
        boolean found = false;
        ;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, time);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator.locateElement(element)));
            found = true;
        } catch (TimeoutException timeoutException) {
            logger.error("Element - " + elementLocator.locateElement(element) + " Not Present");
        }
        return found;
    }

    public boolean areElementPresent(String element, int time) {
        boolean found = false;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, time);
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementLocator.locateElement(element)));
            found = true;
        } catch (TimeoutException t) {
            logger.error("Element - " + element + " Not present ");
        }
        return found;
    }

    public String getText(String element) {
        isElementPresent(element, DEFAULT_TIME_OUT);
        MobileElement mobileElement = getElememnt(element);
        String text = mobileElement.getText();
        return text;
    }

    public String getTextAttribute(String element) {
        isElementPresent(element, DEFAULT_TIME_OUT);
        MobileElement mobileElement = getElememnt(element);
        String text = mobileElement.getAttribute("text");
        return text;
    }

    public String getAttributeValue(String element, String attribute) {
        isElementPresent(element, DEFAULT_TIME_OUT);
        MobileElement mobileElement = getElememnt(element);
        String text = mobileElement.getAttribute(attribute);
        return text;
    }

    public void closeKeyboard() {
        driver.hideKeyboard();
    }

    public void removeApp(String bundleId) {
        driver.removeApp(bundleId);
    }

    public void closeApp() {
        driver.closeApp();
    }


    public MobileElement getElememnt(String element) {
        elementLocator = new ElementLocator();
        return (MobileElement) driver.findElement(elementLocator.locateElement(element));
    }

    public void waitTime(long i) throws InterruptedException {
        Thread.sleep(i*1000);
    }
}

