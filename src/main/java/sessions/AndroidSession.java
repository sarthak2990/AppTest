package sessions;

/**
 * author Sarthak
 */

import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.MobileSessionUtility;
import utilities.PropertyReader;
import utilities.ShellExecutor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class AndroidSession implements SessionManager {
    private Logger logger = Logger.getLogger(AndroidSession.class);
    private AppiumDriver appiumDriver;
    private AppiumDriverLocalService appiumDriverLocalService;


    @Override
    public void startSession() {
        appiumDriverLocalService = startAppiumServer();
        logger.info("Appium Server Started Successfully");
    }

    public synchronized void initiateDriver() {
        try {
            appiumDriver = new AndroidDriver(new URL(getUrl()), clientCapabilities());
        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
        }
    }

    public DesiredCapabilities clientCapabilities() {
        /*
        * Adding capablities for Andriod
        * */
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.storms.store");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.stormsclient.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"D:\\Imp\\TestAutomationFramework\\data\\original.apk");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET,false);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, ShellExecutor.getListOfConnectedDevices().get(0));
        return desiredCapabilities;
    }

    @Override
    public AppiumDriver getDriver() {
        return this.appiumDriver;
    }

    public String getUrl() {
        return appiumDriverLocalService.getUrl().toString();
    }

    @Override
    public void stopSession() {
        logger.info("Appium Server is getting closed");
        appiumDriverLocalService.stop();
    }

}
