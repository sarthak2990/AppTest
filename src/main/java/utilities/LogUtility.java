package utilities;

/**
 * author Love
 */

import org.apache.log4j.Logger;

public class LogUtility {
    private Logger logger;

    public LogUtility(Class clasName) {
        logger = Logger.getLogger(clasName);
    }

    public void logInfo(String infoMsg) {
        logger.info(infoMsg);
    }

    public void logWarn(String warnMsg) {
        logger.warn(warnMsg);
    }

    public void logError(String errorMsg) {
        logger.error(errorMsg);
    }

    public void logDebug(String debugMsg) {
        logger.debug(debugMsg);
    }

}
