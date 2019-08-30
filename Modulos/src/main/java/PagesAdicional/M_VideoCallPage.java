package PagesAdicional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class M_VideoCallPage extends BasePage {

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

	public void completeRecord(String motivo, String enfermedadActual, String dx, String indicaciones, String reposo,
			String signos) {
		try {
			wait.until(ExpectedConditions.visibilityOf(inputMotivoExtendido));
			inputMotivoExtendido.sendKeys(motivo);
			inputEnfermedadActual.sendKeys(enfermedadActual);
			inputDiagnostico.click();
			selectDiagnosis(dx);
			inputIndicaciones.sendKeys(indicaciones);
			Select select = new Select(selectReposo);
			select.selectByValue(reposo);
			inputSignosAlerta.sendKeys(signos);
			PageHelper.waitImplicit();
			wait.until(ExpectedConditions.elementToBeClickable(btnFinalizarRegistro));
			btnFinalizarRegistro.click();
			wait.until(ExpectedConditions.elementToBeClickable(btnConfirmarRegistro));
			btnConfirmarRegistro.click();
			Log.info("Se completo el registro médico correctamente");
		} catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("Se produjo un error al completar el registro médico");
		}
	}

	private void selectDiagnosis(String dx) {
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
			Log.info("Falló la selección de dignóstico");
		}
	}
}
