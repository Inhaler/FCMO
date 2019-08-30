package context;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contrasenias {

	
	private String contraseniaLongitud;
	
	private String contraseniaCoincidencia;
	
	private String contraseniaObligatoriedad;

	
	public Contrasenias(String contraseniaLongitud, String contraseniaCoincidencia, String contraseniaObligatoriedad) {
		this.contraseniaLongitud = contraseniaLongitud;
		this.contraseniaCoincidencia = contraseniaCoincidencia;
		this.contraseniaObligatoriedad = contraseniaObligatoriedad;
	}
	
	public Contrasenias() {
		
	}

	public String getContraseniaLongitud() {
		return contraseniaLongitud;
	}

	@XmlElement
	public void setContraseniaLongitud(String contrasenia) {
		this.contraseniaLongitud = contrasenia;
	}

	public String getContraseniaCoincidencia() {
		return contraseniaCoincidencia;
	}

	public String getContraseniaObligatoriedad() {
		return contraseniaObligatoriedad;
	}

	@XmlElement
	public void setContraseniaCoincidencia(String contraseniaCoincidencia) {
		this.contraseniaCoincidencia = contraseniaCoincidencia;
	}
	
	@XmlElement
	public void setContraseniaObligatoriedad(String contraseniaObligatoriedad) {
		this.contraseniaObligatoriedad = contraseniaObligatoriedad;
	}
	
	
	
	
}
