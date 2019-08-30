package config;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class DataSetter {

    public static Configuration configuration;

    public static void getConfiguration() {
        try {
            File file = new File("src/main/java/configuration/ConfigurationFile.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Configuration.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            configuration = (Configuration) jaxUnmarshaller.unmarshal(file);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void dispose() {
        configuration = null;
    }
}
