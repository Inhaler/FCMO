package config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Configuration {
	private String browser;
	private String urlPrestadores;
	private String urlMedico;
	private String urlAdmin;
	private String urlSocio;
	private String correo;
	private String driverPath;
	private String log4jPath;
	private String delivery;
	private String deliveryPath;
	private String reportPath;
	private String reportRepository;
	private String imageRepository;
	private String urlDriver;
	private String pruebaRemota;

	public Configuration() {
	}

	public Configuration(String browser, String urlPrestadores, String urlMedico, String urlAdmin, String urlSocio, String driverPath,
			String log4jPath, String delivery, String reportPath, String reportRepository, String imageRepository,
			String deliveryPath, String urlDriver, String pruebaRemota, String correo) {
		this.browser = browser;
		this.driverPath = driverPath;
		this.log4jPath = log4jPath;
		this.delivery = delivery;
		this.reportPath = reportPath;
		this.reportRepository = reportRepository;
		this.imageRepository = imageRepository;
		this.deliveryPath = deliveryPath;
		this.urlDriver = urlDriver;
		this.pruebaRemota = pruebaRemota;
		this.urlPrestadores = urlPrestadores;
		this.urlMedico = urlMedico;
		this.urlAdmin = urlAdmin;
		this.urlSocio = urlSocio;
		this.correo = correo;
	}

	
	
	public String getPruebaRemota() {
		return pruebaRemota;
	}

	@XmlElement
	public void setPruebaRemota(String pruebaRemota) {
		this.pruebaRemota = pruebaRemota;
	}

	public String getUrlDriver() {
		return urlDriver;
	}
	
	@XmlElement
	public void setUrlDriver(String urlDriver) {
		this.urlDriver = urlDriver;
	}

	public String getDeliveryPath() {
		return deliveryPath;
	}

	@XmlElement
	public void setDeliveryPath(String deliveryPath) {
		this.deliveryPath = deliveryPath;
	}

	public String getBrowser() {
		return browser;
	}

	@XmlElement
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getDriverPath() {
		return driverPath;
	}

	@XmlElement
	public void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}

	public String getLog4jPath() {
		return log4jPath;
	}

	@XmlElement
	public void setLog4jPath(String log4jPath) {
		this.log4jPath = log4jPath;
	}

	public String getDelivery() {
		return delivery;
	}

	@XmlElement
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getReportPath() {
		return reportPath;
	}

	@XmlElement
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public String getReportRepository() {
		return reportRepository;
	}

	@XmlElement
	public void setReportRepository(String reportRepository) {
		this.reportRepository = reportRepository;
	}

	public String getImageRepository() {
		return imageRepository;
	}

	@XmlElement
	public void setImageRepository(String imageRepository) {
		this.imageRepository = imageRepository;
	}

	public String geturlAdmin() {
		return urlAdmin;
	}

	@XmlElement
	public void seturlPrestadores(String urlPrestadores) {
		this.urlPrestadores = urlPrestadores;
	}

	@XmlElement
	public void seturlMedico(String urlMedico) {
		this.urlMedico = urlMedico;
	}

	@XmlElement
	public void seturlAdmin(String urlAdmin) {
		this.urlAdmin = urlAdmin;
	}

	public String getUrlPrestadores() {
		return urlPrestadores;
	}

	public String getUrlMedico() {
		return urlMedico;
	}

	public String getUrlAdmin() {
		return urlAdmin;
	}

	public String getUrlSocio() {
		return urlSocio;
	}

	public String geturlSocio() {
		return urlSocio;
	}
	@XmlElement
	public void seturlSocio(String urlSocio) {
		this.urlSocio = urlSocio;
	}

	public String getCorreo() {
		return correo;
	}

	@XmlElement
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}
