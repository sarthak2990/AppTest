package library;
/**
 * author Sarthak
 */

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.Assert;


public class ElementLocator {

    public By locateElement(String query) {
        String locator[] = query.split("_", 2);
        String locatorType = locator[0];
        String locatorValue = locator[1];
        By by = null;
        switch (locatorType) {
            case "ID":
                by = MobileBy.id(locatorValue);
                break;
            case "XP":
                by = MobileBy.xpath(locatorValue);
                break;
            case "CS":
                by = MobileBy.cssSelector(locatorValue);
                break;
            case "NM":
                by = MobileBy.name(locatorValue);
                break;
            case "CN":
                by = MobileBy.className(locatorValue);
                break;
            case "LT":
                by = MobileBy.linkText(locatorValue);
                break;
            case "TN":
                by = MobileBy.tagName(locatorValue);
                break;
            case "PL":
                by = MobileBy.partialLinkText(locatorValue);
                break;
            case "AS":
                by = MobileBy.AccessibilityId(locatorValue);
                break;
            default:
                Assert.fail("Invalid choice of element identifier- " + locator + ". Please select appropriate element identfier or make sure you have used correct abbreviation in property file.");
        }
        return by;
    }
}

