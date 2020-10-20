package base;
/**
 * author Sarthak
 */

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import sessions.AndroidSession;
import sessions.SessionManager;
import utilities.EnvironmentFields;


public class BaseClass {
    protected SessionManager sessionManager;
    private Logger logger = Logger.getLogger(BaseClass.class);

    @BeforeMethod
    public void setUpTest() {
        initializeSession();
        sessionManager.startSession();
        sessionManager.initiateDriver();
    }

    @AfterMethod
    public void closeSession() {
        sessionManager.stopSession();

    }

    public void initializeSession() {
        String platformOs = EnvironmentFields.getPlatformOs();
        logger.info("Platform OS On Which Test To Run - " + platformOs);
        if (platformOs.equalsIgnoreCase("android")) {
            sessionManager = new AndroidSession();
        } else if (platformOs.equalsIgnoreCase("ios")) {
        //TODO For future IOS app we can add
        //    sessionManager = new IOSSession();
        }
    }

}
