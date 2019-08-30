package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import context.Objects;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {


    public static Objects objects;
    public static ObjectMapper mapper;

    public static void guardarJson(String testName) throws IOException {
        File file = new File("src/main/java/context/" + testName + ".json");
        mapper = new ObjectMapper();
        mapper.writeValue(file, objects);
    }


    public static void leerJson(String testName) throws IOException {
        File file = new File("src/main/java/context/" + testName + ".json");
        mapper = new ObjectMapper();
        Objects tmp = mapper.readValue(file, Objects.class);
        objects = tmp;
    }

	
}
