package utilities;

/**
 * author Love
 */

import constants.Constants;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PropertyReader {
    private static FileInputStream fileInputStream;
    private static Properties properties;
    private static Logger logger = Logger.getLogger(PropertyReader.class);

    public static Properties readProperty(String filePath) {
        try {
            fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException f) {
            logger.error(f.getMessage());
        }
        return properties;
    }

    public static Map<String, String> getAllKeysAndValues(String filePath) {
        Properties properties = readProperty(filePath);
        Map<String, String> map = new HashMap<>();
        Set propertySet = properties.entrySet();
        Iterator iterator = propertySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) iterator.next();
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    public static Properties readLocatorProperties(String filePath) {
        return readProperty(Constants.LOCATORS_DIRECTORY_PATH + Constants.slash + filePath);
    }

}
