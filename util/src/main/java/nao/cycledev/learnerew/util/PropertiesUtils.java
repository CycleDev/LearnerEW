package nao.cycledev.learnerew.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtils {

    private final static String PROPERTIES_FILE_NAME = "application.properties";

    private PropertiesUtils(){}

    public static Properties readApplicationProperties(final Class<?> classObj) throws IOException {
        Properties properties = null;
        InputStream is = classObj.getResourceAsStream("/" + PROPERTIES_FILE_NAME);
        try {
            properties = new Properties();
            properties.load(is);
        } finally {
            is.close();
        }
        return properties;
    }
}
