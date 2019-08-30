package context;

import javax.xml.bind.annotation.XmlRootElement;

import com.poiji.annotation.ExcelCell;


public class Invitaciones {

	@ExcelCell(value = 0)
	public String nroSocio;

	@ExcelCell(value = 1)
	public String nroCelular;

	@ExcelCell(value = 2)
	public String email;

	@ExcelCell(value = 3)
	public String especialidad;

	@ExcelCell(value = 4)
	public String detalleConsulta;

	@ExcelCell(value = 5)
	public String nombre;

	@ExcelCell(value = 6)
	public String apellido;

	@ExcelCell(value = 7)
	public String fechaNacimiento;

	@ExcelCell(value = 8)
	public String idServicio;
	
	@ExcelCell(value = 9)
	public String plan;
	
	@ExcelCell(value = 10)
	public String mesaOperativa;

	@ExcelCell(value = 11)
	public String provincia;
	
	@ExcelCell(value = 12)
	public String localidad;
	
	@ExcelCell(value = 13)
	public String barrio;
	
	@ExcelCell(value = 14)
	public String marcaCI;
	
	@ExcelCell(value = 15)
	public String marcaDiscapacidad;
	
	@ExcelCell(value = 16)
	public String marcaID;
	
	@ExcelCell(value = 17)
	public String marcaCX;
	
	@ExcelCell(value = 18)
	public String marcaPMI;

	@ExcelCell(value = 19)
	public String motivoExtendido;
	
	@ExcelCell(value = 20)	
	public String enfermedadActual;
	
	@ExcelCell(value = 21)	
	public String diagnostico;
	
	@ExcelCell(value = 22)
	public String indicaciones;
	
	@ExcelCell(value = 23)
	public String reposo;
	
	@ExcelCell(value = 24)
	public String signos;
	
	@ExcelCell(value = 25)
	public String motivoAnular;
	
	public Invitaciones() {

	}

	public Invitaciones(String nroSocio, String nroCelular, String especialidad, String detalleConsulta, String nombre,
			String apellido, String fechaNacimiento, String idServicio, String email, String plan, String mesaOperativa,
			String provincia, String localidad, String barrio, String marcaCI, String marcaDiscapacidad, String marcaID, String marcaCX, 
			String marcaPMI, String motivoExtendido, String enfermedadActual, String diagnostico, String indicaciones,
			String reposo, String signos, String motivoAnular) {
		this.nroSocio = nroSocio;
		this.nroCelular = nroCelular;
		this.especialidad = especialidad;
		this.detalleConsulta = detalleConsulta;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.idServicio = idServicio;
		this.email = email;
		this.plan = plan;
		this.mesaOperativa = mesaOperativa;
		this.provincia = provincia;
		this.localidad = localidad;
		this.barrio = barrio;
		this.marcaCI = marcaCI;
		this.marcaDiscapacidad = marcaDiscapacidad;
		this.marcaID = marcaID;
		this.marcaCX = marcaCX;
		this.marcaPMI = marcaPMI;
		this.motivoExtendido = motivoExtendido;
		this.enfermedadActual = enfermedadActual;
		this.diagnostico = diagnostico;
		this.indicaciones = indicaciones;
		this.reposo = reposo;
		this.signos = signos;
		this.motivoAnular = motivoAnular;
	}

	public String getEmail() {
		return email;
	}

	public String getNroSocio() {
		return nroSocio;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public String getDetalleConsulta() {
		return detalleConsulta;
	}

	public String getNroCelular() {
		return nroCelular;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getIdServicio() {
		return idServicio;
	}

	public String getPlan() {
		return plan;
	}

	public String getMesaOperativa() {
		return mesaOperativa;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getBarrio() {
		return barrio;
	}

	public String getMarcaCI() {
		return marcaCI;
	}

	public String getMarcaDiscapacidad() {
		return marcaDiscapacidad;
	}

	public String getMarcaID() {
		return marcaID;
	}

	public String getMarcaCX() {
		return marcaCX;
	}

	public String getMarcaPMI() {
		return marcaPMI;
	}

	public String getMotivoExtendido() {
		return motivoExtendido;
	}

	public String getEnfermedadActual() {
		return enfermedadActual;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public String getIndicaciones() {
		return indicaciones;
	}

	public String getReposo() {
		return reposo;
	}

	public String getSignos() {
		return signos;
	}

	public String getMotivoAnular() {
		return motivoAnular;
	}

}
