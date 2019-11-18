package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {
    private static Properties appProps = null;

    public static void initProperties(){
        //String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = System.getProperty("user.dir") + "//src//test//testConfig//test.properties";

        appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            System.out.println("No property file detected on path: " + appConfigPath);
        }
    }

    public static String getProperty(String propertyName){
        if (appProps != null){
            return appProps.getProperty(propertyName);
        }
        else{
            initProperties();
            return appProps.getProperty(propertyName);
        }
    }
}
