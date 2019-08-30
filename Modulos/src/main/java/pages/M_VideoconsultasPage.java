package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class M_VideoconsultasPage extends BasePage {

	@FindBy(xpath = "//button[@ng-click='atenderPacienteVcCtrl.fireConfirmFinalizarVideoConsulta()']")
	private WebElement btnFinalizar;

	@FindBy(xpath = "//button[@ng-click='atenderPacienteVcCtrl.confirmReubicarPacienteSalaEspera()']")
	private WebElement btnRegresarSalaEspera;

	@FindBy(xpath = "//button[@ng-click='atenderPacienteVcCtrl.fireConfirmDevolverDespacho()']")
	private WebElement btnDevolverDespacho;

	@FindBy(xpath = "//button[@ng-click='atenderPacienteVcCtrl.toggleVideoChat()']")
	private WebElement btnChat;

	@FindBy(xpath = "//button[@ng-click='atenderPacienteVcCtrl.toggleAttachFiles()']")
	private WebElement btnAdjuntos;

	@FindBy(xpath = "//button[@ng-click='atenderPacienteVcCtrl.toggleHistorial()']")
	private WebElement btnHistorial;

	@FindBy(xpath = "//button[@ng-click='atenderPacienteVcCtrl.toggleForm()']")
	private WebElement btnRegistroMedico;

	@FindBy(xpath = "//form[@name='formConsulta']")
	private WebElement formRegistroMedico;

	@FindBy(id = "textMotivoExtendido")
	private WebElement inputMotivoExtendido;

	@FindBy(id = "textEnfermedadActual")
	private WebElement inputEnfermedadActual;

	@FindBy(xpath = "//tags-input[@ng-model='atenderPacienteVcCtrl.formData.diagnosticos']")
	private WebElement inputDiagnostico;

	@FindBy(xpath = "//div[@class='autocomplete']/ul/li")
	private WebElement autocompletDiagnostico;

	@FindBy(id = "indicaciones")
	private WebElement inputIndicaciones;

	@FindBy(id = "reposo")
	private WebElement selectReposo;

	@FindBy(id = "signosDeAlerta")
	private WebElement inputSignosAlerta;

	@FindBy(xpath = "//input[@ng-model='atenderPacienteVcCtrl.formData.indicarConsultaPresencial']")
	private WebElement checkPresencial;

	@FindBy(xpath = "//button[@ng-click='atenderPacienteVcCtrl.fireConfirmUrgencia()'])")
	private WebElement btnMarcarUrgencia;

	@FindBy(xpath = "//*[@id='main']/div/div/div[2]/div[5]/div[2]/form/div[4]/div/ul/li[2]")
	private WebElement solapaNotasPrivadas;

	@FindBy(xpath = "//*[@id='main']/div/div/div[2]/div[5]/div[2]/form/div[4]/div/ul/li[3]")
	private WebElement solapaMedicamentos;

	@FindBy(xpath = "//*[@id='main']/div/div/div[2]/div[5]/div[2]/form/div[4]/div/ul/li[4]")
	private WebElement solapaEstudios;

	@FindBy(xpath = "//button[@ng-click='atenderPacienteVcCtrl.fireNuevaRecetaFarmalinkModal()']")
	private WebElement btnNuevaReceta;

	@FindBy(xpath = "//tags-input[@ng-model='atenderPacienteVcCtrl.formData.laboratoriosADomicilio']")
	private WebElement inputLaboratorio;

	@FindBy(xpath = "//button[@ng-really-click='atenderPacienteVcCtrl.finalizarAtencion()']")
	private WebElement btnFinalizarRegistro;

	@FindBy(xpath = "//tags-input[@ng-model='atenderPacienteVcCtrl.formData.imagenesADomicilio']")
	private WebElement inputImagenes;

	@FindBy (xpath = "//button[@ng-click='ok()']")
	private WebElement btnConfirmarRegistro;
	
	@FindBy (xpath = "//button[@ng-click='cancel()']")
	private WebElement btnCancelarRegistro;

	@FindBy(id = "loading-bar")
	WebElement cargandoGrilla;
	
	public boolean esVisibleBtnFinalizar(){
		Boolean esVisible = false;
		try {
			waitFluent.until(ExpectedConditions.elementToBeClickable(btnFinalizar));
			esVisible = btnFinalizar.isDisplayed();
			Log.info("Se obtuvo el elemento btnFinalizar");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnFinalizar");
		}
		return esVisible;
	}
	
	public boolean estaHabilitadoBtnFinalizar() {
		Boolean estaHabilitado = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnFinalizar));
			estaHabilitado = btnFinalizar.isEnabled();
			Log.info("El elemento btnFinalizar se encuentra habilitado");
		} catch (Exception e) {
			Log.info("Fallo al obtener el estado del elemento btnFinalizar");
		}
		return estaHabilitado;
	}
	
	
	
	public boolean esVisibleBtnRegresarASalaEspera(){
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegresarSalaEspera));
			esVisible = btnRegresarSalaEspera.isDisplayed();
			Log.info("Se obtuvo el elemento btnRegresarSalaEspera");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnRegresarSalaEspera");
		}
		return esVisible;
	}
	
	public boolean estaHabilitadoBtnRegresarASalaEspera() {
		Boolean estaHabilitado = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnRegresarSalaEspera));
			estaHabilitado = btnRegresarSalaEspera.isEnabled();
			Log.info("El elemento btnRegresarSalaEspera se encuentra habilitado");
		} catch (Exception e) {
			Log.info("Fallo al obtener el estado del elemento btnRegresarSalaEspera");
		}
		return estaHabilitado;
	}
	
	
	public boolean esVisibleBtnDevolverDespacho(){
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnDevolverDespacho));
			esVisible = btnDevolverDespacho.isDisplayed();
			Log.info("Se obtuvo el elemento btnDevolverDespacho");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnDevolverDespacho");
		}
		return esVisible;
	}
	
	public boolean estaHabilitadoBtnDevolverDespacho() {
		Boolean estaHabilitado = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnDevolverDespacho));
			estaHabilitado = btnDevolverDespacho.isEnabled();
			Log.info("El elemento btnDevolverDespacho se encuentra habilitado");
		} catch (Exception e) {
			Log.info("Fallo al obtener el estado del elemento btnDevolverDespacho");
		}
		return estaHabilitado;
	}
	
	
	
	public boolean esVisibleBtnChat(){
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnChat));
			esVisible = btnChat.isDisplayed();
			Log.info("Se obtuvo el elemento btnChat");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnChat");
		}
		return esVisible;
	}
	
	public boolean esVisibleBtnAdjuntos(){
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAdjuntos));
			esVisible = btnAdjuntos.isDisplayed();
			Log.info("Se obtuvo el elemento btnAdjuntos");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnAdjuntos");
		}
		return esVisible;
	}
	
	public boolean esVisibleBtnHistorial(){
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnHistorial));
			esVisible = btnHistorial.isDisplayed();
			Log.info("Se obtuvo el elemento btnHistorial");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnHistorial");
		}
		return esVisible;
	}
	
	public boolean esVisibleBtnRegistroMedico(){
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegistroMedico));
			esVisible = btnRegistroMedico.isDisplayed();
			Log.info("Se obtuvo el elemento btnRegistroMedico");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnRegistroMedico");
		}
		return esVisible;
	}
	
	public boolean esVisibleFormRegistroMedico(){
		Boolean esVisible = false;
		try {
			waitFluent.until(ExpectedConditions.elementToBeClickable(formRegistroMedico));
			esVisible = formRegistroMedico.isDisplayed();
			Log.info("Se obtuvo el elemento formRegistroMedico");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento formRegistroMedico");
		}
		return esVisible;
	}
	
	
	
	public void clicBtnFinalizar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnFinalizar));
			btnFinalizar.click();
			Log.info("Se hizo click en el boton btnFinalizar");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton btnFinalizar");
			e.printStackTrace();
		}
	}

	public void clicBtnRegresarSalaEspera() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegresarSalaEspera));
			btnRegresarSalaEspera.click();
			Log.info("Se hizo click en el boton btnRegresarSalaEspera");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton btnRegresarSalaEspera");
			e.printStackTrace();
		}
	}
	
	
	public void clicBtnDevolverDespacho() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnDevolverDespacho));
			btnDevolverDespacho.click();
			Log.info("Se hizo click en el boton btnDevolverDespacho");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton btnDevolverDespacho");
			e.printStackTrace();
		}
	}
	
	
	public void clicBtnChat() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnChat));
			btnChat.click();
			Log.info("Se hizo click en el boton btnChat");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton btnChat");
			e.printStackTrace();
		}
	}
	
	public void clicBtnAdjuntos() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAdjuntos));
			btnAdjuntos.click();
			Log.info("Se hizo click en el boton btnAdjuntos");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton btnAdjuntos");
			e.printStackTrace();
		}
	}
	
	public void clicBtnHistorial() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnHistorial));
			btnHistorial.click();
			Log.info("Se hizo click en el boton btnHistorial");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton btnHistorial");
			e.printStackTrace();
		}
	}
	
	
	public void clicBtnRegistroMedico() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegistroMedico));
			btnRegistroMedico.click();
			Log.info("Se hizo click en el boton btnRegistroMedico");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton btnRegistroMedico");
			e.printStackTrace();
		}
	}
	
	//Metodos para completar Registro Medico
	
	public void completarRegistro(String motivo, String enfermedadActual, String dx, String indicaciones, String reposo,
			String signos) {
		try {
			wait.until(ExpectedConditions.visibilityOf(inputMotivoExtendido));
			inputMotivoExtendido.sendKeys(motivo);
			inputEnfermedadActual.sendKeys(enfermedadActual);
			inputDiagnostico.click();
			seleccionarDx(dx);
			inputIndicaciones.sendKeys(indicaciones);
			Select select = new Select(selectReposo);
			select.selectByValue(reposo);
			inputSignosAlerta.sendKeys(signos);
			PageHelper.waitImplicit();
			wait.until(ExpectedConditions.elementToBeClickable(btnFinalizarRegistro));
			btnFinalizarRegistro.click();
			wait.until(ExpectedConditions.elementToBeClickable(btnConfirmarRegistro));
			btnConfirmarRegistro.click();
			esperaCargaGrilla();
			wait.until(ExpectedConditions.urlContains("atender-videoconsulta/calificacion"));
			Log.info("Se completo el registro medico correctamente");
		} catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("Se produjo un error al completar el registro medico");
		}
	}

	private void seleccionarDx(String dx) {
		try {
			action.moveToElement(inputDiagnostico);
			action.click();
			action.sendKeys(dx);
			action.build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(autocompletDiagnostico));
			autocompletDiagnostico.click();
			Log.info("Se logro seleccionar el diagnostico");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.getMessage());
			Log.info("Fallo la seleccion de dx");
		}
	}
	
	public void esperaCargaGrilla() {
		try {
			wait.until(ExpectedConditions.visibilityOf(cargandoGrilla));
			while (PageHelper.elementStillPresent(cargandoGrilla)) {
				wait.until(ExpectedConditions.stalenessOf(cargandoGrilla));
			}
			Log.info("Se espera que se cargue la grilla");
		} catch (Exception e) {
			Log.info("No se muestra la barra de carga de grilla");
		}
	}


}
