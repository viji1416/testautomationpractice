package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties properties;

    public ConfigReader() {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\SeleniumAutomation\\src\\test\\resources\\config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

