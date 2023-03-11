package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties;

    static{
        properties= new Properties();
        try {
            properties.load(Files.newInputStream(Path.of("config.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
