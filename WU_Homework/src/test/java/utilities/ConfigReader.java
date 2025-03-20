package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static {
        String dosya="configuration.properties";

        try{
            FileInputStream fileInputStream=new FileInputStream(dosya);
            properties=new Properties();
            properties.load(fileInputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return  properties.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        String dosya="configuration.properties";
        properties.setProperty(key, value);
        try {
            OutputStream outputStream = new FileOutputStream(dosya);
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
