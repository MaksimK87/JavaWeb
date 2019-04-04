/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task05.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataConfiguration {
    private static final String file = "E:\\Мои документы\\Java courses\\IDEA" +
            "\\Workspace\\src\\by\\epam\\javawebtraining\\maksimkosmachev\\task05\\" +
            "resources\\configuration.properties";

    public static Integer getProperty(String key) {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(properties.getProperty(key));
    }

}
