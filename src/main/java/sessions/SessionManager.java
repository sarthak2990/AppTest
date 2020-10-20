package sessions;

/**
 * author Love
 */

import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.MobileSessionUtility;
import utilities.PropertyReader;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public interface SessionManager {

    public void initiateDriver();

    public void startSession();

    public void stopSession();

    public AppiumDriver getDriver();

    public DesiredCapabilities clientCapabilities();


        default AppiumDriverLocalService startAppiumServer(){
        AppiumDriverLocalService appiumDriverLocalService = null;
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        InetAddress inetAddress  = null;
        try {
             inetAddress  = InetAddress.getLocalHost();
        }catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        appiumServiceBuilder.usingAnyFreePort();
        appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL,Constants.APPIUM_SERVER_LOG_LEVEL);
        appiumServiceBuilder.withArgument(GeneralServerFlag.RELAXED_SECURITY);
        appiumServiceBuilder.withIPAddress(inetAddress.getHostAddress());
        appiumServiceBuilder.withCapabilities(serverCapability());
        appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumDriverLocalService.start();
        return appiumDriverLocalService;
    }


    default DesiredCapabilities serverCapability(){
        String SERVER_CAPABILITIES_PATH = Constants.SERVER_CAPABILITIES_PATH;
        Map<String,String> androidProperties = PropertyReader.getAllKeysAndValues(SERVER_CAPABILITIES_PATH);
        DesiredCapabilities desiredCapabilities = MobileSessionUtility.setCapability(androidProperties);
        return desiredCapabilities;
    }

}
