package testSteps;

import library.AppiumLibrary;
import org.testng.Assert;
import sessions.SessionManager;
import testClasses.LoginTest;
import utilities.LogUtility;
import utilities.PropertyReader;

import java.util.Properties;

public class LoginSteps {
    private AppiumLibrary appiumLibrary;
    private Properties loginPageOptions = PropertyReader.readLocatorProperties("loginScreen.properties");
    private LogUtility logger = new LogUtility(LoginTest.class);

    public LoginSteps(SessionManager sessionManager) {
        appiumLibrary = new AppiumLibrary(sessionManager);
    }

    public void verifyLogin(String username, String password) throws InterruptedException {
        logger.logInfo("Click Account Tab");
        appiumLibrary.waitTime(2);
        appiumLibrary.click(loginPageOptions.getProperty("accountTab"));
        appiumLibrary.waitTime(2);
        if (!appiumLibrary.isElementPresent(loginPageOptions.getProperty("loginSucess"), 5)) {
            isLoginSucess(username, password);
        } else {
            logout();
            isLoginSucess(username, password);

        }
    }


    public void isLoginSucess(String username, String password) throws InterruptedException {
        logger.logInfo("Sign IN");
        if (appiumLibrary.isElementPresent(loginPageOptions.getProperty("notMe"), 5)) {
            appiumLibrary.click(loginPageOptions.getProperty("notMe"));
        }
        appiumLibrary.waitTime(5);
        appiumLibrary.enterText(loginPageOptions.getProperty("username"), username);
        appiumLibrary.waitTime(5);
        appiumLibrary.enterText(loginPageOptions.getProperty("password"), password);
        appiumLibrary.waitTime(2);
        appiumLibrary.click(loginPageOptions.getProperty("loginScr"));
        appiumLibrary.waitTime(2);
        Assert.assertEquals(appiumLibrary.getText(loginPageOptions.getProperty("loginSucess")), "tester");
    }

    public void logout() throws InterruptedException {
        logger.logInfo("Sign OUT");
        appiumLibrary.waitTime(10);
        appiumLibrary.click(loginPageOptions.getProperty("menu"));
        appiumLibrary.waitTime(2);
        appiumLibrary.click(loginPageOptions.getProperty("logout"));
        appiumLibrary.waitTime(5);
        appiumLibrary.click(loginPageOptions.getProperty("login"));
        appiumLibrary.waitTime(2);
        Assert.assertEquals(appiumLibrary.isElementPresent(loginPageOptions.getProperty("notMe"), 5), true);
    }

    public void verifyLoginLogoutLogin(String username, String password) throws InterruptedException {
        logger.logInfo("Click Account Tab");
        appiumLibrary.waitTime(2);
        appiumLibrary.click(loginPageOptions.getProperty("accountTab"));
        appiumLibrary.waitTime(5);
        if (!appiumLibrary.isElementPresent(loginPageOptions.getProperty("loginSucess"), 5)) {
            isLoginSucess(username, password);
        } else {
            logout();
            isLoginSucess(username, password);
        }
        logout();
        appiumLibrary.waitTime(5);

        Assert.assertEquals(appiumLibrary.isElementPresent(loginPageOptions.getProperty("notMe"), 5), true);
    }

    public void tryNegativeLogin(String username, String password) throws InterruptedException {
        logger.logInfo("Sign IN");
//        logger.logInfo("Click Account Tab");
        appiumLibrary.waitTime(2);
        appiumLibrary.click(loginPageOptions.getProperty("accountTab"));

        if (appiumLibrary.isElementPresent(loginPageOptions.getProperty("notMe"), 5)) {
            appiumLibrary.click(loginPageOptions.getProperty("notMe"));
        }
        appiumLibrary.waitTime(5);
        appiumLibrary.enterText(loginPageOptions.getProperty("username"), username);
        appiumLibrary.waitTime(5);
        appiumLibrary.enterText(loginPageOptions.getProperty("password"), password);
        appiumLibrary.waitTime(2);
        appiumLibrary.click(loginPageOptions.getProperty("loginScr"));
        appiumLibrary.waitTime(2);
        Assert.assertEquals(appiumLibrary.isElementPresent(loginPageOptions.getProperty("loginSucess"), 3), false);
    }
}
