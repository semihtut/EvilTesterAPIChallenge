package EvilTester.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

    public static void setProperties(String keys, String values) {
        try (OutputStream outputStream = new FileOutputStream("Configuration.properties")) {
            properties.setProperty(keys, values);

            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}