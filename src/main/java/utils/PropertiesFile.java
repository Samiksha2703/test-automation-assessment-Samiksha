package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
    public static String sysPath = System.getProperty("user.dir");
    public static Properties prop = new Properties();

    // Test method to get Properties from config file
    public static String getProperties(String propertyValue) {
        try {
            InputStream input = new FileInputStream(sysPath + "\\src\\main\\resources\\config.properties");
            prop.load(input);
        } catch (Exception e) {
            System.out.println("[ERROR] Exception Cause " + e.getMessage());
        }
        return prop.getProperty(propertyValue);
    }
}
