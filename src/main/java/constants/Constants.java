package constants;

/**
 * author Sarthak
 */

import utilities.EnvironmentFields;

import java.io.File;

public class Constants {

    public static String PROJECT_PATH = System.getProperty("user.dir");

    public static String slash = File.separator;

    public static String REPORTS_DIRECTORY_PATH = PROJECT_PATH + slash + "reports";

    public static String SRC_DIRECTORY_PATH = PROJECT_PATH + slash + "src";

    public static String MAIN_DIRECTORY_PATH = SRC_DIRECTORY_PATH + slash + "main";

    public static String JAVA_DIRECTORY_PATH = MAIN_DIRECTORY_PATH + slash + "java";

    public static String RESOURCE_DIRECTORY_PATH = MAIN_DIRECTORY_PATH + slash + "resources";

    public static String LOCATORS_DIRECTORY_PATH = MAIN_DIRECTORY_PATH + slash + "locators" + slash + EnvironmentFields.getPlatformOs();

    public static String CAPABILITIES_DIRECTORY_PATH = RESOURCE_DIRECTORY_PATH + slash + "capabilities";

    public static String SERVER_CAPABILITIES_PATH = CAPABILITIES_DIRECTORY_PATH + slash + "serverCapabilities.properties";

    public static String ENVIRONEMENTS_DIRECTORY_PATH = RESOURCE_DIRECTORY_PATH + slash + "environments";

    public static String ENVIRONEMENT_PROPERTIES_PATH = ENVIRONEMENTS_DIRECTORY_PATH + slash + EnvironmentFields.getDefaultTestEnv() + ".properties";

    public static String SHELL_COMMAND_DIRECTORY_PATH = RESOURCE_DIRECTORY_PATH + slash + "shellCommands";

    public static String LOGS_DIRECTORY_PATH = PROJECT_PATH + slash + "logs";

    public static String SERVER_LOGS_PATH = LOGS_DIRECTORY_PATH + slash + "server";

    public static String APPIUM_SERVER_LOGS_PATH = SERVER_LOGS_PATH + slash + "appiumServerLog.txt";

    public static String SHELL_COMMAND_PROPERTIES_PATH = SHELL_COMMAND_DIRECTORY_PATH + slash + EnvironmentFields.getPlatformOs() + "Command.properties";

    public static String APPIUM_SERVER_LOG_LEVEL = "info";

    public static int ELEMENT_EXPLICIT_WAIT = 15;

    public static String EXTENT_REPORT_PATH = REPORTS_DIRECTORY_PATH + slash + "extentReport.html";
}
