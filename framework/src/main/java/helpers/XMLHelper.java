package helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import context.ContextManager;
import context.Contrasenias;
import context.Fechas;
import context.MesasOperativas;
import context.Objects;
import context.PreObjects;
import context.Usuario;

public class XMLHelper {

    public static Objects object;
    public static ArrayList<PreObjects> preObjects = new ArrayList<PreObjects>();

    public static void guardarXml(String testName) {
        try {
            File file = new File("src\\main\\java\\context\\"+testName+".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Objects.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            object.setNombreDeLaPrueba(testName);
            jaxbMarshaller.marshal(object, file);
            timer.Timers.endTimer();
            object.setTiempoFinal(timer.Timers.getTimer());
            ContextManager.putObject();
            //jaxbMarshaller.marshal(object, System.out);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void leerXml(String testName) {
        try {
        	File file = new File("src\\main\\java\\context\\"+testName+".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Objects.class);
            Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
            Objects obj = (Objects) jaxbMarshaller.unmarshal(file);
            object = obj;
            obj.getPasos().clear();
            timer.Timers.startTimer();
            object.setTiempoInicio(String.valueOf(timer.Timers.start / 1000));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            System.out.println(ex.getStackTrace());
        }
    }

    public static void generarXml() {
    	Usuario usuario = new Usuario("prueba", "PASSTEST");
    	Contrasenias contrasenia = new Contrasenias ("cmo", "cmotest1" , "cmotest5"); 	
    	MesasOperativas mesas = new MesasOperativas("MDQ", "MZA" , "MET","NEU", "ROS" , "TUC");
    	Fechas fecha = new Fechas("10/10/2006", "10/10/2016");
		Objects obj = new Objects(usuario, "TipoPrueba","Prioridad", "Referencia", "Asignado",
				"TiempoInicio", "TiempoFinal", "Estado", "Sprint", "version", "nombrePrueba", contrasenia, "modulo", "descripcion","imgFalla",mesas, fecha);

        try {
            File file = new File("src/main/java/context/Objects.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Objects.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(obj, file);
            jaxbMarshaller.marshal(obj, System.out);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
