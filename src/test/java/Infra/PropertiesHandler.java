package Infra;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {

    public static Properties readProperties(String filename) {
        Properties properties = new Properties();

        try (InputStream input = PropertiesHandler.class.getClassLoader().getResourceAsStream(filename)) {
            if (input == null) {
                throw new IOException("Unable to find " + filename);
            }

            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error reading properties file: " + e.getMessage());
        }

        return properties;
    }

    public static String getProperty(String filename, String key) {
        Properties properties = readProperties(filename);
        return properties.getProperty(key);
    }
}