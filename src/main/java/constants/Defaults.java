package constants;

import java.io.File;

/**
 * author Sarthak
 */
public class Defaults {
    private static String slash = File.separator;

    public static String DEFAULT_ENVIRONMENT_PATH = System.getProperty("user.dir") + slash + "src" + slash + "main" + slash + "resources" + slash + "environments" + slash + "defaultEnvironment.properties";

    public static String EXTENT_REPORT_NAME = "APP_AUTOMATION";

    public static String EXTENT_DOCUEMTN_TITILE = "APP";
}
