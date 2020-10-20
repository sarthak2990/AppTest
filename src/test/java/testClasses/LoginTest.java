package testClasses;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testSteps.LoginSteps;
import utilities.LogUtility;
import utilities.PropertyReader;

import java.util.Properties;

public class LoginTest extends BaseClass {
    private LogUtility logger = new LogUtility(LoginTest.class);
    private LoginSteps loginSteps;
    private Properties loginPageOptions = PropertyReader.readLocatorProperties("loginScreen.properties");

    /*
     * Creating Dataprovider for username and password for login Test with different users
     * @return Object[][] where first column contains 'username/email'
     * and second column contains 'password'
     * Also you need gice param parallel = true for running this test in parallel with data provider
     */
    @DataProvider(name = "UserProvider", parallel = true)
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {
                        {"kyiezmty@gmail.com", "nmmxuhk"},
                        {"mpypiwnt@gmail.com", "mhrwxnh"},
                        {"hsknglcu@gmail.com", "rwgxdvm"},
                        {"mkrhywwj@gmail.com", "dlevwae"},
                        {"wofpjjez@gmail.com", "tiatokw"}
                };

    }

    @BeforeMethod
    public void intialize() {
        loginSteps = new LoginSteps(sessionManager);
    }

    @Test
    public void verifyLoginPositive() throws InterruptedException {
        /**
         * In this we  will veridy positive login scenerio*/
        loginSteps.verifyLogin(loginPageOptions.getProperty("email"), loginPageOptions.getProperty("passwrd"));
    }

    @Test
    public void verifyLoginLogoutAndAgainLogin() throws InterruptedException {
        //In this test we will verify Login after logout
        loginSteps.verifyLoginLogoutLogin(loginPageOptions.getProperty("email"), loginPageOptions.getProperty("passwrd"));
    }

    //Using data provider to run tests
    @Test(dataProvider = "UserProvider")
    public void verifyNegativeScenerio(String email, String password) throws InterruptedException {
        loginSteps.tryNegativeLogin(email, password);
    }
}
