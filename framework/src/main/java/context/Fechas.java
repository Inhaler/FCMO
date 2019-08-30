package context;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fechas {

	private String fechaDesde;
	private String fechaHasta;
	
	public Fechas(String fechaDesde, String fechaHasta) {
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}
	
	public Fechas() {
		
	}

	public String getFechaDesde() {
		return fechaDesde;
	}

	public String getFechaHasta() {
		return fechaHasta;
	}

	@XmlElement
	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	@XmlElement
	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	


	
	
	
}
