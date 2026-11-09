package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String getProperty(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("src/test/resources/config.properties");
        properties.load(file);
        file.close();

        return properties.getProperty(key);
    }
}
