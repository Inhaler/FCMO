package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class D_Envio_InvitacionesPage extends BasePage {

	@FindBy(css = "#main > div > div > div > div > div.col-lg-12.text-right > button")
	WebElement btnEnviarInvitacion;

	@FindBy(className = "panel-heading")
	WebElement divInvitacion;

	@FindBy(css = "#enviarInvitacionForm > div > div > div.ng-hide")
	WebElement divCampoNOObligatoriosOcultos;

	@FindBy(css = "#enviarInvitacionForm > div > div > div.form-group.form-group-sm.has-feedback.has-error > div.row > div.col-md-8 > div > input")
	WebElement campNSocio;

	@FindBy(css = "#enviarInvitacionForm > div > div > div.form-group.form-group-sm.has-feedback > div.row > div.col-md-8 > div > input")
	WebElement campNroSocio;

	@FindBy(css = "#enviarInvitacionForm > div > div > div:nth-child(8) > div:nth-child(11) > div > div > div > ul")
	WebElement listaBarrios;

	@FindBy(css = "#enviarInvitacionForm > div > div > div:nth-child(8) > div:nth-child(11) > div > div > div > ul > li:nth-child(1)")
	WebElement itemBarrio;

	@FindBy(css = "#phone")
	WebElement campNTelefono;

	@FindBy(css = "#email")
	WebElement campEmail;

	@FindBy(id = "clinica")
	WebElement checkClinica;

	@FindBy(id = "pediatria")
	WebElement checkPediatria;

	@FindBy(name = "detalleMotivo")
	WebElement campDetalleMotivo;

	@FindBy(css = "#nombre")
	WebElement campNombre;

	@FindBy(css = "#apellido")
	WebElement campApellido;

	@FindBy(css = "#fechaNacimiento")
	WebElement campFechaNacimiento;

	@FindBy(id = "id_servicio")
	WebElement campIdServicio;

	@FindBy(id = "mesa")
	WebElement comboMesaOperativa;

	@FindBy(id = "plan")
	WebElement comboPlan;

	@FindBy(id = "ic15")
	WebElement marcaClienteInterno;

	@FindBy(id = "id12")
	WebElement marcaDiscapacidad;

	@FindBy(id = "di24")
	WebElement marcaInternacionDomiciliaria;

	@FindBy(id = "cp16")
	WebElement marcaCronicidad;

	@FindBy(id = "mp3")
	WebElement marcaPMI;

	@FindBy(id = "provincia")
	WebElement comboProvincia;

	@FindBy(id = "localidad")
	WebElement comboLocalidad;

	@FindBy(id = "barrio")
	WebElement campoBarrio;

	@FindBy(id = "dniTipo")
	WebElement comboSocio;

	@FindBy(css = "#enviarInvitacionForm > div > div > a")
	WebElement linkOcultarInfo;

	@FindBy(css = "#enviarInvitacionForm > div > footer > div > div > div > div > button")
	WebElement btnEnviar;

	@FindBy(css = "#enviarInvitacionForm > div > footer > div > div > div > div:nth-child(1) > button")
	WebElement btnVolver;

	@FindBy(xpath = "//*[@id='main']/div/div/div/div/div[3]")
	WebElement panelInvitaciones;

	@FindBy(xpath = "//*[@id='main']/div/div/div/div/div[3]/div/div[2]/div/div[2]/table")
	WebElement panelVideoconsultas;

	@FindBy(className = "toast-message")
	WebElement toastMessage;

	WebElement btnAnular;

	@FindBy(name = "detalleMotivo")
	WebElement txtDetalleMotivo;

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.modal-body > form > div.modal-footer > button.btn.btn-danger")
	WebElement btnAnularPopUp;

	@FindBy(xpath = "//button[@ng-click='cancel()']")
	WebElement btnSalirPopUpAnular;

	@FindBy(xpath = "//button[@class='close']")
	WebElement btnCerrarPopUpAnular;

	WebElement btnReenviar;

	@FindBy(name = "modal-content")
	WebElement formModal;

	@FindBy(xpath = "/html/body/div[1]/div/div/div/div/div[2]/form/div[2]/button[2]")
	WebElement formModalBtnReenviar;

	@FindBy(id = "phone")
	WebElement formModalcampTelefono;

	@FindBy(id = "email")
	WebElement formModalcampEmail;

	@FindBy(xpath = "/html/body/div[1]/div/div/div/div/div[2]/div[1]")
	WebElement modalDetail;

	@FindBy(xpath = "//button[@ng-if='vcDetailModalCtrl.vc.boton_cancelar']")
	WebElement btnCancelarVC;

	@FindBy(xpath = "//button[@ng-if='vcDetailModalCtrl.vc.boton_devolver_medico']")
	WebElement btnDevolverMed;

	@FindBy(xpath = "//button[@ng-if='vcDetailModalCtrl.vc.boton_devolver_sala']")
	WebElement btnDevolverSocio;

	@FindBy(xpath = "//button[@ng-if='vcDetailModalCtrl.vc.boton_devolver_sala_prioridad']")
	WebElement btnDevolverSocioPrioridad;

	@FindBy(xpath = "//button[@ng-click='close()']")
	WebElement btnContinuarPopUp;

	@FindBy(xpath = "//button[@ng-click='cancel()']")
	WebElement btnCancelarPopUp;

	@FindBy(xpath = "//input[@ng-model='enterContactoModalCtrl.editFields']")
	WebElement checkEditar;

	@FindBy(id = "phone")
	WebElement campoTelPopUp;

	@FindBy(id = "email")
	WebElement campoEmailPopUp;

	@FindBy(css = "#enviarInvitacionForm > div > div > div.form-group.form-group-sm.has-feedback.has-error > div.help-block.ng-active")
	WebElement lblNroSocioMsjCampoObligatorio;

	@FindBy(css = "#enviarInvitacionForm > div > div > div:nth-child(2) > div > div.help-block.ng-active")
	WebElement lblNroTelMsjCampoObligatorio;

	@FindBy(css = "#enviarInvitacionForm > div > div > div:nth-child(3) > div > div.help-block.ng-active")
	WebElement lblEmailMsjCampoObligatorio;

	@FindBy(css = "#enviarInvitacionForm > div > div > div:nth-child(5) > div")
	WebElement lblEspecialidadMsjCampoObligatorio;

	@FindBy(css = "#enviarInvitacionForm > div > div > div:nth-child(7) > div > div")
	WebElement lblMotivoMsjCampoObligatorio;

	@FindBy(css = "#enviarInvitacionForm > div > div > div:nth-child(8) > div:nth-child(2) > div > div.help-block.ng-active")
	WebElement lblNombreMsjCampoObligatorio;

	@FindBy(css = "#enviarInvitacionForm > div > div > div:nth-child(8) > div:nth-child(3) > div > div.help-block.ng-active")
	WebElement lblApellidoMsjCampoObligatorio;

	@FindBy(css = "#enviarInvitacionForm > div > div > div:nth-child(8) > div:nth-child(5) > div.col-md-8 > div > div > div.help-block.ng-active")
	WebElement lblIdServicioMsjCampoObligatorio;

	@FindBy(css = "#enviarInvitacionForm > div > div > div:nth-child(8) > div:nth-child(6) > div > div > div > div")
	WebElement lblPlanMsjCampoObligatorio;

	@FindBy(css = "#enviarInvitacionForm > div > div > div:nth-child(8) > div:nth-child(4) > div > div.help-block.ng-active")
	WebElement lblFechaMsjError;

	@FindBy(css = "#main > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div > div.panel-body.pre-scrollable > table")
	WebElement tablaInvitaciones;

	// elementos formreenvio

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.modal-body > form")
	WebElement formReenvio;

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.modal-body > form > div.row > div > div.form-group.form-group-sm.has-feedback > div > div.col-md-8 > div > input")
	WebElement campoReenvioNroSocio;

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.modal-body > form > div.row > div > div:nth-child(7) > div > textarea")
	WebElement campoReenvioMotivo;

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.modal-body > form > div.row > div > div:nth-child(16) > div > div > div")
	WebElement campoReenvioProvincia;

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.modal-body > form > div.row > div > div:nth-child(17) > div > div > div")
	WebElement campoReenvioLocalidad;

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.modal-body > form > div.row > div > div:nth-child(18) > div > div > div")
	WebElement campoReenvioBarrio;

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.modal-body > form > div.modal-footer > button.btn.btn-default")
	WebElement btnReenvioSalir;

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.modal-header > button")
	WebElement btnReenvioCerrarPopup;

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.modal-body > form > div.row > div > div:nth-child(3) > div > div.help-block.ng-active > p")
	WebElement lblMsjErrorEmail;

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.modal-body > form > div.row > div > div:nth-child(2) > div > div.help-block.ng-active > p")
	WebElement lblMsjErrorTelefono;

	// Elementos grilla de invitaciones

	@FindBy(xpath = "//*[@id='main']/div/div/div/div/div[3]/div/div[1]/div/div[1]")
	WebElement grillaInvitacionesTitulo;

	@FindBy(css = "#main > div > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div > div.panel-body.pre-scrollable > div")
	WebElement grillaInvitaciones;

	@FindBy(xpath = "//input[@ng-model='enviarInvitacionVcCtrl.soloActivas']")
	WebElement grillaInvitacionesCheckActivas;

	@FindBy(xpath = "//button[@ng-click='enviarInvitacionVcCtrl.fireExportarInvites()']")
	WebElement grillaInvitacionesBtnExportar;

	@FindBy(xpath = "//span[@ng-click='enviarInvitacionVcCtrl.getInfoSharedVc()']")
	WebElement grillaInvitacionesHoraActualizacion;

	@FindBy(xpath = "//table[@ng-if='enviarInvitacionVcCtrl.invites.length > 0']")
	WebElement hayInvitacionesEnGrilla;

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div")
	WebElement popUpExportar;

	@FindBy(xpath = "//input[@ng-click='chooseDatesModalCtrl.openDatePickerDesde()']")
	WebElement exportarPopUpFechaDesde;

	@FindBy(xpath = "//input[@ng-click='chooseDatesModalCtrl.openDatePickerHasta()']")
	WebElement exportarPopUpFechaHasta;

	@FindBy(css = "body > div.modal.fade.in > div > div > div > div > div.modal-body > form > div.modal-footer > button.btn.btn-primary")
	WebElement exportarPopUpBtnExportar;

	@FindBy(xpath = "//button[@ng-click='cancel()']")
	WebElement exportarPopUpBtnSalir;
	
	@FindBy(id = "loading-bar")
	WebElement cargandoGrilla;

	public Boolean esVisibleGrillaInvitaciones() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(panelInvitaciones));
			esVisible = panelInvitaciones.isDisplayed();
			Log.info("Se obtuvo el elemento panelInvitaciones");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento panelInvitaciones");
		}
		return esVisible;
	}

	public Boolean esVisibleGrillaVideoconsultas() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(panelVideoconsultas));
			esVisible = panelVideoconsultas.isDisplayed();
			Log.info("Se obtuvo el elemento panelVideoconsultas");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento panelVideoconsultas");
		}
		return esVisible;
	}

	public Boolean estaHabilitadoBtnInvitaciones() {
		Boolean estaHabilitado = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(panelInvitaciones));
			estaHabilitado = btnEnviarInvitacion.isEnabled();
			Log.info("Se obtuvo el elemento btnEnviarInvitacion");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnEnviarInvitacion");
		}
		return estaHabilitado;
	}

	public Boolean abrirFormInvitaciones() {
		Boolean esVisible = false;
		if (estaHabilitadoBtnInvitaciones()) {
			btnEnviarInvitacion.click();
			wait.until(ExpectedConditions.elementToBeClickable(divInvitacion));
			esVisible = divInvitacion.isDisplayed();
			divInvitacion.click();
			Log.info("Se realizo la apertura del form de invitaciones");
		} else {
			Log.info("Invitaciones manuales deshabilitadas");
		}
		return esVisible;
	}

	//////

	public Boolean esVisibleComboSocio() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(comboSocio));
			esVisible = comboSocio.isDisplayed();
			Log.info("Se obtuvo el elemento comboSocio");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento comboSocio");
		}
		return esVisible;
	}

	public Boolean esVisibleCampoNroSocio() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campNSocio));
			esVisible = campNSocio.isDisplayed();
			Log.info("Se obtuvo el elemento campNSocio");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campNSocio");
		}
		return esVisible;
	}

	public Boolean esVisibleCampoNroTelefono() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campNTelefono));
			esVisible = campNTelefono.isDisplayed();
			Log.info("Se obtuvo el elemento campNTelefono");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campNTelefono");
		}
		return esVisible;
	}

	public Boolean esVisibleCampoEmail() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campEmail));
			esVisible = campEmail.isDisplayed();
			Log.info("Se obtuvo el elemento campEmail");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campEmail");
		}
		return esVisible;
	}

	public Boolean esVisibleRadioButtonEspClinica() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(checkClinica));
			esVisible = checkClinica.isDisplayed();
			Log.info("Se obtuvo el elemento checkClinica");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento checkClinica");
		}
		return esVisible;
	}

	public Boolean esVisibleRadioButtonEspPediatria() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(checkPediatria));
			esVisible = checkPediatria.isDisplayed();
			Log.info("Se obtuvo el elemento checkPediatria");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento checkPediatria");
		}
		return esVisible;
	}

	public Boolean esVisibleCampoDetalleMotivo() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campDetalleMotivo));
			esVisible = campDetalleMotivo.isDisplayed();
			Log.info("Se obtuvo el elemento campDetalleMotivo");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campDetalleMotivo");
		}
		return esVisible;
	}

	public Boolean esVisibleCampoNombre() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campNombre));
			esVisible = campNombre.isDisplayed();
			Log.info("Se obtuvo el elemento campNombre");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campNombre");
		}
		return esVisible;
	}

	public Boolean esVisibleCampoApellido() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campApellido));
			esVisible = campApellido.isDisplayed();
			Log.info("Se obtuvo el elemento campApellido");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campApellido");
		}
		return esVisible;
	}

	public Boolean esVisibleCampoFechaNac() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campFechaNacimiento));
			esVisible = campFechaNacimiento.isDisplayed();
			Log.info("Se obtuvo el elemento campFechaNacimiento");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campFechaNacimiento");
		}
		return esVisible;
	}

	public Boolean esVisibleComboMesaOperativa() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(comboMesaOperativa));
			esVisible = comboMesaOperativa.isDisplayed();
			Log.info("Se obtuvo el elemento comboMesaOperativa");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento comboMesaOperativa");
		}
		return esVisible;
	}

	public Boolean esVisibleCampoIdServicio() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campIdServicio));
			esVisible = campIdServicio.isDisplayed();
			Log.info("Se obtuvo el elemento campIdServicio");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campIdServicio");
		}
		return esVisible;
	}

	public Boolean esVisibleComboPlan() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(comboPlan));
			esVisible = comboPlan.isDisplayed();
			Log.info("Se obtuvo el elemento comboPlan");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento comboPlan");
		}
		return esVisible;
	}

	public Boolean esVisibleCheckMarcaClienteInterno() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(marcaClienteInterno));
			esVisible = marcaClienteInterno.isDisplayed();
			Log.info("Se obtuvo el elemento marcaClienteInterno");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento marcaClienteInterno");
		}
		return esVisible;
	}

	public Boolean esVisibleCheckMarcaDiscapacidad() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(marcaDiscapacidad));
			esVisible = marcaDiscapacidad.isDisplayed();
			Log.info("Se obtuvo el elemento marcaDiscapacidad");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento marcaDiscapacidad");
		}
		return esVisible;
	}

	public Boolean esVisibleCheckMarcaID() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(marcaInternacionDomiciliaria));
			esVisible = marcaInternacionDomiciliaria.isDisplayed();
			Log.info("Se obtuvo el elemento marcaInternacionDomiciliaria");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento marcaInternacionDomiciliaria");
		}
		return esVisible;
	}

	public Boolean esVisibleCheckMarcaCronicidad() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(marcaCronicidad));
			esVisible = marcaCronicidad.isDisplayed();
			Log.info("Se obtuvo el elemento marcaCronicidad");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento marcaCronicidad");
		}
		return esVisible;
	}

	public Boolean esVisibleCheckMarcaPMI() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(marcaPMI));
			esVisible = marcaPMI.isDisplayed();
			Log.info("Se obtuvo el elemento marcaPMI");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento marcaPMI");
		}
		return esVisible;
	}

	public Boolean esVisibleComboProvincia() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(comboProvincia));
			esVisible = comboProvincia.isDisplayed();
			Log.info("Se obtuvo el elemento comboProvincia");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento comboProvincia");
		}
		return esVisible;
	}

	public Boolean esVisibleComboLocalidad() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(comboLocalidad));
			esVisible = comboLocalidad.isDisplayed();
			Log.info("Se obtuvo el elemento comboLocalidad");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento comboLocalidad");
		}
		return esVisible;
	}

	public Boolean esVisibleCampoBarrio() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoBarrio));
			esVisible = campoBarrio.isDisplayed();
			Log.info("Se obtuvo el elemento campoBarrio");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campoBarrio");
		}
		return esVisible;
	}

	public Boolean esVisibleBotonVolver() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnVolver));
			esVisible = btnVolver.isDisplayed();
			Log.info("Se obtuvo el elemento btnVolver");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnVolver");
		}
		return esVisible;
	}

	public Boolean esVisibleBotonEnviar() {
		Boolean esVisible = false;
		try {
			PageHelper.ScrollToTheBottom();
			wait.until(ExpectedConditions.elementToBeClickable(btnEnviar));
			esVisible = btnEnviar.isDisplayed();
			Log.info("Se obtuvo el elemento btnEnviar");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnEnviar");
		}
		return esVisible;
	}

	public Boolean esVisibleListaBarrios() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(listaBarrios));
			esVisible = listaBarrios.isDisplayed();
			Log.info("Se obtuvo el elemento lista de barrios");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento lista de barrios");
		}
		return esVisible;
	}

	public Boolean esVisibleLinkOcultarInfo() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(linkOcultarInfo));
			esVisible = linkOcultarInfo.isDisplayed();
			Log.info("Se obtuvo el elemento linkOcultarInfo");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento linkOcultarInfo");
		}
		return esVisible;
	}

	public Boolean clicBotonOcultarInfo() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(linkOcultarInfo));
			esVisible = linkOcultarInfo.isDisplayed();
			linkOcultarInfo.click();
			Log.info("Se hizo clic en el elemento linkOcultarInfo");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento linkOcultarInfo");
		}
		return esVisible;
	}

	public Boolean clicCampoBarrio() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoBarrio));
			esVisible = campoBarrio.isDisplayed();
			campoBarrio.click();
			Log.info("Se hizo clic en el elemento campo Barrio");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento campo Barrio");
		}
		return esVisible;
	}

	public Boolean clicItemListaBarrio() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(itemBarrio));
			esVisible = itemBarrio.isDisplayed();
			itemBarrio.click();
			Log.info("Se hizo clic en el primer item de la lista de Barrios");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el item de la lista de barrios");
		}
		return esVisible;
	}

	public Boolean clicBotonEnviar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnEnviar));
			esVisible = btnEnviar.isDisplayed();
			btnEnviar.click();
			Log.info("Se realizo clic en el elemento btnEnviar");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento btnEnviar");
		}
		return esVisible;
	}

	public Boolean clicBotonVolver() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnVolver));
			esVisible = btnVolver.isDisplayed();
			btnVolver.click();
			Log.info("Se realizo clic en el elemento btnVolver");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento btnVolver");
		}
		return esVisible;
	}

	public String obtenerErrorLabelNroSocio() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(lblNroSocioMsjCampoObligatorio));
			msjError = lblNroSocioMsjCampoObligatorio.getText();
			Log.info("Se obtuvo el label de error del campo nroSocio");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo nroSocio");
			e.printStackTrace();
		}
		return msjError;
	}

	public String obtenerErrorLabelTelefono() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(lblNroTelMsjCampoObligatorio));
			msjError = lblNroTelMsjCampoObligatorio.getText();
			Log.info("Se obtuvo el label de error del campo nro Tel");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo nro Tel");
			e.printStackTrace();
		}
		return msjError;
	}

	public String obtenerErrorLabelEmail() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(lblEmailMsjCampoObligatorio));
			msjError = lblEmailMsjCampoObligatorio.getText();
			Log.info("Se obtuvo el label de error del campo email");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo email");
			e.printStackTrace();
		}
		return msjError;
	}

	public String obtenerErrorLabelEspecialidad() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(lblEspecialidadMsjCampoObligatorio));
			msjError = lblEspecialidadMsjCampoObligatorio.getText();
			Log.info("Se obtuvo el label de error del campo especialidad");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo especialidad");
			e.printStackTrace();
		}
		return msjError;
	}

	public String obtenerErrorLabelDetalleMotivo() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(lblMotivoMsjCampoObligatorio));
			msjError = lblMotivoMsjCampoObligatorio.getText();
			Log.info("Se obtuvo el label de error del campo motivo");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo motivo");
			e.printStackTrace();
		}
		return msjError;
	}

	public String obtenerErrorLabelNombre() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(lblNombreMsjCampoObligatorio));
			msjError = lblNombreMsjCampoObligatorio.getText();
			Log.info("Se obtuvo el label de error del campo nombre");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo nombre");
			e.printStackTrace();
		}
		return msjError;
	}

	public String obtenerErrorLabelApellido() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(lblApellidoMsjCampoObligatorio));
			msjError = lblApellidoMsjCampoObligatorio.getText();
			Log.info("Se obtuvo el label de error del campo apellido");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo apellido");
			e.printStackTrace();
		}
		return msjError;
	}

	public String obtenerErrorLabelIDServicio() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(lblIdServicioMsjCampoObligatorio));
			msjError = lblIdServicioMsjCampoObligatorio.getText();
			Log.info("Se obtuvo el label de error del campo id Servicio");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo id Servicio");
			e.printStackTrace();
		}
		return msjError;
	}

	public String obtenerErrorLabelPlan() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(lblPlanMsjCampoObligatorio));
			msjError = lblPlanMsjCampoObligatorio.getText();
			Log.info("Se obtuvo el label de error del campo plan");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo plan");
			e.printStackTrace();
		}
		return msjError;
	}

	public Boolean generarInvitacion(String NSocio, String NTelefono, String Email, String Especialidad,
			String DetalleMotivo, String Nombre, String Apellido, String FechaNacimiento, String idServicio,
			String MesaOperativa, String Plan, String Provincia, String Localidad, String Barrio, String MarcaCI,
			String MarcaDiscapacidad, String MarcaID, String MarcaCX, String MarcaPMI) {
		Boolean envioOK = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(divInvitacion));
			divInvitacion.click();
			campNSocio.click();
			campNSocio.sendKeys(NSocio);

			campNTelefono.click();
			campNTelefono.sendKeys(NTelefono);

			campEmail.click();
			campEmail.sendKeys(Email);

			switch (Especialidad) {
			case "Clinica":
				checkClinica.click();
				break;
			case "Pediatria":
				checkPediatria.click();
				break;
			}

			campDetalleMotivo.click();
			campDetalleMotivo.sendKeys(DetalleMotivo);

			campNombre.click();
			campNombre.sendKeys(Nombre);

			campApellido.click();
			campApellido.sendKeys(Apellido);

			campFechaNacimiento.click();
			campFechaNacimiento.sendKeys(FechaNacimiento);

			if (Plan != "") {
				Select selectPlan = new Select(comboPlan);
				selectPlan.selectByVisibleText(Plan);
			}

			if (MesaOperativa != "") {
				Select selectMesaOperativa = new Select(comboMesaOperativa);
				selectMesaOperativa.selectByVisibleText(MesaOperativa);
			}

			campIdServicio.click();
			campIdServicio.sendKeys(idServicio);

			if (Provincia != "") {
				Select selectProvincia = new Select(comboProvincia);
				selectProvincia.selectByVisibleText(Provincia);
			}

			if (Localidad != "") {
				Select selectLocalidad = new Select(comboLocalidad);
				selectLocalidad.selectByVisibleText(Localidad);
			}

			campoBarrio.click();
			campoBarrio.sendKeys(Barrio);
			if (MarcaCI.equals("SI")) {
				marcaClienteInterno.click();
			}
			if (MarcaDiscapacidad.equals("SI")) {
				marcaDiscapacidad.click();
			}
			if (MarcaID.equals("SI")) {
				marcaInternacionDomiciliaria.click();
			}
			if (MarcaCX.equals("SI")) {
				marcaCronicidad.click();
			}
			if (MarcaPMI.equals("SI")) {
				marcaPMI.click();
			}
			btnEnviar.click();
			PageHelper.WaitForPageLoading();
			envioOK = wait.until(ExpectedConditions.textToBePresentInElement(toastMessage, "Invitación enviada."));
			Log.info("Invitacion enviada correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return envioOK;
	}

	public void cargarDatos(String NSocio, String NTelefono, String Email, String Especialidad, String DetalleMotivo,
			String Nombre, String Apellido, String FechaNacimiento, String idServicio, String MesaOperativa,
			String Plan, String Provincia, String Localidad, String Barrio, String MarcaCI, String MarcaDiscapacidad,
			String MarcaID, String MarcaCX, String MarcaPMI) {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(divInvitacion));
			divInvitacion.click();
			campNSocio.click();
			campNSocio.sendKeys(NSocio);

			campNTelefono.click();
			campNTelefono.sendKeys(NTelefono);

			campEmail.click();
			campEmail.sendKeys(Email);

			switch (Especialidad) {
			case "Clinica":
				checkClinica.click();
				break;
			case "Pediatria":
				checkPediatria.click();
				break;
			}

			campDetalleMotivo.click();
			campDetalleMotivo.sendKeys(DetalleMotivo);

			campNombre.click();
			campNombre.sendKeys(Nombre);

			campApellido.click();
			campApellido.sendKeys(Apellido);

			campFechaNacimiento.click();
			campFechaNacimiento.sendKeys(FechaNacimiento);

			if (Plan != "") {
				Select selectPlan = new Select(comboPlan);
				selectPlan.selectByVisibleText(Plan);
			}

			if (MesaOperativa != "") {
				Select selectMesaOperativa = new Select(comboMesaOperativa);
				selectMesaOperativa.selectByVisibleText(MesaOperativa);
			}
			campIdServicio.click();
			campIdServicio.sendKeys(idServicio);

			if (Provincia != "") {
				Select selectProvincia = new Select(comboProvincia);
				selectProvincia.selectByVisibleText(Provincia);
			}

			if (Localidad != "") {
				Select selectLocalidad = new Select(comboLocalidad);
				selectLocalidad.selectByVisibleText(Localidad);
			}

			campoBarrio.click();
			campoBarrio.sendKeys(Barrio);
			if (MarcaCI.equals("SI")) {
				marcaClienteInterno.click();
			}
			if (MarcaDiscapacidad.equals("SI")) {
				marcaDiscapacidad.click();
			}
			if (MarcaID.equals("SI")) {
				marcaInternacionDomiciliaria.click();
			}
			if (MarcaCX.equals("SI")) {
				marcaCronicidad.click();
			}
			if (MarcaPMI.equals("SI")) {
				marcaPMI.click();
			}
			Log.info("Se cargaron los datos de la invitacion");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean obtenerMensajeAlertaLogin(String msj) {
		Boolean mensaje = false;
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(toastMessage, msj));
			mensaje = true;
			Log.info("Se obtuvo el mensaje de alerta");
		} catch (Exception e) {
			Log.info("Fallo al obtener mensaje de alerta");
		}
		return mensaje;
	}

	public String obtenerErrorLabelFecha() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(lblFechaMsjError));
			msjError = lblFechaMsjError.getText();
			Log.info("Se obtuvo el label de error del campo Fecha");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo Fecha");
			e.printStackTrace();
		}
		return msjError;
	}

	public String obtenerDatoFecha() {
		String datoFecha = "";
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campFechaNacimiento));
			campFechaNacimiento.click();
			datoFecha = campFechaNacimiento.getAttribute("value");
			Log.info("Se obtuvo el dato del campo Fecha");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo Fecha");
			e.printStackTrace();
		}
		return datoFecha;
	}

	public String obtenerDatoNroSocio() {
		String datoNroSocio = "";
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campNroSocio));
			datoNroSocio = campNroSocio.getAttribute("value");
			Log.info("Se obtuvo el dato del campo NroSocio");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo NroSocio");
			e.printStackTrace();
		}
		return datoNroSocio;
	}

	public String obtenerDatoCelular() {
		String datoCelular = "";
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campNTelefono));
			datoCelular = campNTelefono.getAttribute("value");
			Log.info("Se obtuvo el dato del campo Nro Celular");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo Nro Celular");
			e.printStackTrace();
		}
		return datoCelular;
	}

	public String obtenerDatoApellido() {
		String datoApell = "";
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campApellido));
			datoApell = campApellido.getAttribute("value");
			Log.info("Se obtuvo el dato del campo Apellido");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo Apellido");
			e.printStackTrace();
		}
		return datoApell;
	}

	public String obtenerDatoNombre() {
		String datoNombre = "";
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campNombre));
			datoNombre = campNombre.getAttribute("value");
			Log.info("Se obtuvo el dato del campo Nombre");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo Nombre");
			e.printStackTrace();
		}
		return datoNombre;
	}

	public String obtenerDatoDetalleMotivo() {
		String datoDetalle = "";
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campDetalleMotivo));
			datoDetalle = campDetalleMotivo.getAttribute("value");
			Log.info("Se obtuvo el dato del campo Detalle Motivo");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo Detalle Motivo");
			e.printStackTrace();
		}
		return datoDetalle;
	}

	public String obtenerDatoIDServicio() {
		String datoIDServicio = "";
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campIdServicio));
			datoIDServicio = campIdServicio.getAttribute("value");
			Log.info("Se obtuvo el dato del campo ID Servicio");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo ID Servicio");
			e.printStackTrace();
		}
		return datoIDServicio;
	}

	public String obtenerDatoEmail() {
		String datoEmail = "";
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campEmail));
			datoEmail = campEmail.getAttribute("value");
			Log.info("Se obtuvo el dato del campo Email");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo Email");
			e.printStackTrace();
		}
		return datoEmail;
	}

	public Boolean seleccionarMesaOperativa(String mesa) {
		Boolean mensaje = false;

		if (mesa != "") {
			Select selectMesaOperativa = new Select(comboMesaOperativa);
			try {
				selectMesaOperativa.selectByVisibleText(mesa);
				mensaje = true;
				Log.info("Se selecciono la mesa");
			} catch (NoSuchElementException e) {
				Log.info("No se encontro la mesa");
			}
		}
		return mensaje;
	}

	public Boolean seleccionarProvincia(String prov) {
		Boolean mensaje = false;

		if (prov != "") {
			Select selectProvincia = new Select(comboProvincia);
			try {
				selectProvincia.selectByVisibleText(prov);
				mensaje = true;
				Log.info("Se selecciono la provincia");
			} catch (NoSuchElementException e) {
				Log.info("No se encontro la provincia");
			}
		}
		return mensaje;
	}

	public Boolean seleccionarLocalidad(String localidad) {
		Boolean mensaje = false;

		if (localidad != "") {
			Select selectLocalidad = new Select(comboLocalidad);
			try {
				selectLocalidad.selectByVisibleText(localidad);
				mensaje = true;
				Log.info("Se selecciono la localidad");
			} catch (NoSuchElementException e) {
				Log.info("No se encontro la localidad");
			}
		}
		return mensaje;
	}

	public boolean cancelarInvitacion(String socio, String txtMotivo) {
		boolean borradoOK = false;
		try {
			Log.info("Comienza la anulacion de la invitacion");
			PageHelper.ScrollToTheTop();
			PageHelper.waitImplicit();
			btnAnular = existeNroSocioEnInvitacionsPanel(socio).findElement(By.xpath("./td[last()]/a[2]"));
			wait.until(ExpectedConditions.elementToBeClickable(btnAnular));
			btnAnular.click();
			wait.until(ExpectedConditions.elementToBeClickable(txtDetalleMotivo));
			txtDetalleMotivo.sendKeys(txtMotivo);
			wait.until(ExpectedConditions.elementToBeClickable(btnAnularPopUp));
			btnAnularPopUp.click();
			Log.info("Se hace click en anular");
			try {
				wait.until(ExpectedConditions.textToBePresentInElement(toastMessage, "Actualizando tablas..."));
				toastMessage.click();
				wait.until(
						ExpectedConditions.textToBePresentInElement(toastMessage, "Invitación anulada exitosamente"));
				toastMessage.click();
				Log.info("Se hace click en los mensajes");
			} catch (Exception e) {
				Log.info(e.getMessage());
				Log.info("error esperando mensaje de eliminacion");
			}
			borradoOK = true;
			Log.info("Finaliza la anulacion de la invitacion");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Error al cancelar la invitacion");
		}

		return borradoOK;
	}

	public WebElement existeNroSocioEnInvitacionsPanel(String socio) {
		try {
			List<WebElement> elementos = panelInvitaciones
					.findElements(By.xpath("//div/div[1]/div/div[2]/table/tbody/tr"));
			for (WebElement element : elementos) {
				String attribute = element.getAttribute("innerText");
				if (attribute.contains(socio)) {
					Log.info("El socio se encuentra en el panel de invitaciones");
					return element;
				}

			}
		} catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("error al buscar el socio en el panel de invitaciones");
		}
		return null;
	}

	public void eliminarTodasLasInvitaciones() {

		Log.info("se ingresa al panel invitaciones");
		List<WebElement> elementos = panelInvitaciones.findElements(By.xpath("//div/div[1]/div/div[2]/table/tbody/tr"));
		int cant = elementos.size();
		Log.info("cantidad de items: " + cant);

		for (int i = cant; i > 1; i--) {
			try {
				WebElement element = panelInvitaciones
						.findElement(By.xpath("//div/div[1]/div/div[2]/table/tbody/tr[" + i + "]"));
				Log.info("item nro: " + i + " -- " + element.getAttribute("innerText"));
				btnAnular = element.findElement(By.xpath("./td[last()]/a[2]"));

				wait.until(ExpectedConditions.elementToBeClickable(btnAnular));
				btnAnular.click();
				Log.info("Se hace click en boton anular");
				wait.until(ExpectedConditions.elementToBeClickable(txtDetalleMotivo));
				txtDetalleMotivo.sendKeys("prueba");
				Log.info("Se ingresa motivo");
				wait.until(ExpectedConditions.elementToBeClickable(btnAnularPopUp));
				btnAnularPopUp.click();
				Log.info("Se hace click en anular");

				try {
					wait.until(ExpectedConditions.textToBePresentInElement(toastMessage, "Actualizando tablas..."));
					toastMessage.click();
					wait.until(ExpectedConditions.textToBePresentInElement(toastMessage,
							"InvitaciÃ³n anulada exitosamente"));
					toastMessage.click();
					Log.info("Se hace click en los mensajes");
				} catch (Exception e) {
					Log.info(e.getMessage());
					Log.info("error esperando mensaje de eliminacion");
				}
			} catch (Exception e) {
				Log.info(e.getMessage());
				Log.info("error eliminando invitacion");
			}
		}
	}

	public boolean abrirFormReenviarInvitacion(String socio) {
		boolean reenvioOK = false;
		try {
			Log.info("Comienza el reenvio de la invitacion");
			PageHelper.ScrollToTheTop();
			PageHelper.waitImplicit();
			btnReenviar = existeNroSocioEnInvitacionsPanel(socio).findElement(By.xpath("./td[last()]/a"));
			btnReenviar.click();
			wait.until(ExpectedConditions.elementToBeClickable(formReenvio));
			formReenvio.click();
			Log.info("Se abre el form de reenvio de la invitacion");
			reenvioOK = true;
			formReenvio.click();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("error abriendo form de reenvio de la invitacion");
		}
		return reenvioOK;
	}

	public boolean reenviarInvitacion(String msj1, String msj2) {
		boolean reenvioOK = false;
		try {
			Log.info("Comienza el reenvio de la invitacion");
			wait.until(ExpectedConditions.elementToBeClickable(formModalBtnReenviar));
			PageHelper.ScrollingToElement(formModalBtnReenviar);
			formModalBtnReenviar.click();
			wait.until(ExpectedConditions.textToBePresentInElement(toastMessage, msj1));
			toastMessage.click();
			wait.until(ExpectedConditions.textToBePresentInElement(toastMessage, msj2));
			toastMessage.click();
			reenvioOK = true;
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("error en el reenvio de la invitacion");
		}
		return reenvioOK;
	}

	public String obtenerDatoReenvioNroSocio() {
		String datoNroSocio = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(campoReenvioNroSocio));
			datoNroSocio = campoReenvioNroSocio.getAttribute("value");
			Log.info("Se obtuvo el dato del campo NroSocio");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo NroSocio");
			e.printStackTrace();
		}
		return datoNroSocio;
	}

	public String obtenerDatoReenvioNombre() {
		String datoNombre = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(campNombre));
			datoNombre = campNombre.getAttribute("value");
			Log.info("Se obtuvo el dato del campo Nombre");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo Nombre");
			e.printStackTrace();
		}
		return datoNombre;
	}

	public String obtenerDatoReenvioApellido() {
		String datoApell = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(campApellido));
			datoApell = campApellido.getAttribute("value");
			Log.info("Se obtuvo el dato del campo Apellido");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo Apellido");
			e.printStackTrace();
		}
		return datoApell;
	}

	public String obtenerDatoReenvioIDServicio() {
		String datoIDServicio = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(campIdServicio));
			datoIDServicio = campIdServicio.getAttribute("value").trim();
			Log.info("Se obtuvo el dato del campo ID Servicio");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo ID Servicio");
			e.printStackTrace();
		}
		return datoIDServicio;
	}

	public String obtenerDatoReenvioFecha() {
		String datoFecha = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(campFechaNacimiento));
			campFechaNacimiento.click();
			String fecha = campFechaNacimiento.getAttribute("value");

			SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat myFormat = new SimpleDateFormat("ddMMyyyy");

			try {
				datoFecha = myFormat.format(fromUser.parse(fecha));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Log.info("Se obtuvo el dato del campo Fecha");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo Fecha");
			e.printStackTrace();
		}
		return datoFecha;
	}

	public Boolean seEncuentraSeleccionadoDatoReenvioEspecialidad(String especialidad) {
		Boolean data = false;
		switch (especialidad) {
		case "Clinica":
			data = checkClinica.isSelected();
			break;
		case "Pediatria":
			data = checkPediatria.isSelected();
			break;
		}
		return data;
	}

	public String obtenerDatoReenvioMotivo() {
		String dato = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(campoReenvioMotivo));
			dato = campoReenvioMotivo.getAttribute("value").trim();
			Log.info("Se obtuvo el dato del campo Motivo");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo Motivo");
			e.printStackTrace();
		}
		return dato;
	}

	public String obtenerDatoReenvioMesa() {
		String dato = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(comboMesaOperativa));
			Select selectMesaOperativa = new Select(comboMesaOperativa);
			WebElement option = selectMesaOperativa.getFirstSelectedOption();
			dato = option.getText();
			Log.info("Se obtuvo el dato del campo mesa");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo mesa");
			e.printStackTrace();
		}
		return dato;
	}

	public String obtenerDatoReenvioPlan() {
		String dato = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(comboPlan));
			Select selectPlan = new Select(comboPlan);
			WebElement option = selectPlan.getFirstSelectedOption();
			dato = option.getText();
			Log.info("Se obtuvo el dato del campo plan");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo plan");
			e.printStackTrace();
		}
		return dato;
	}

	public String obtenerDatoReenvioProvincia() {
		String dato = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(campoReenvioProvincia));
			dato = campoReenvioProvincia.getText().trim();
			Log.info("Se obtuvo el dato del campo provincia");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo provincia");
			e.printStackTrace();
		}
		return dato;
	}

	public String obtenerDatoReenvioLocalidad() {
		String dato = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(campoReenvioLocalidad));
			dato = campoReenvioLocalidad.getText().trim();
			Log.info("Se obtuvo el dato del campo localidad");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo localidad");
			e.printStackTrace();
		}
		return dato;
	}

	public String obtenerDatoReenvioBarrio() {
		String dato = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(campoReenvioBarrio));
			dato = campoReenvioBarrio.getText().trim();
			Log.info("Se obtuvo el dato del campo barrio");
		} catch (Exception e) {
			Log.info("Fallo al obtener el dato del campo barrio");
			e.printStackTrace();
		}
		return dato;
	}

	public Boolean validarMarcasReenvio(String MarcaCI, String MarcaDiscapacidad, String MarcaID, String MarcaCX,
			String MarcaPMI) {
		Boolean data = false;

		if (MarcaCI.equals("SI")) {
			if (marcaClienteInterno.isSelected()) {
				data = true;
			} else {
				data = false;
				Log.info("Fallo al obtener la marca CI");
				return data;
			}
		} else {
			data = true;
		}

		if (MarcaDiscapacidad.equals("SI")) {
			if (marcaDiscapacidad.isSelected()) {
				data = true;
			} else {
				data = false;
				Log.info("Fallo al obtener la marca CI");
				return data;
			}
		} else {
			data = true;
		}

		if (MarcaID.equals("SI")) {
			if (marcaInternacionDomiciliaria.isSelected()) {
				data = true;
			} else {
				data = false;
				Log.info("Fallo al obtener la marca CI");
				return data;
			}
		} else {
			data = true;
		}

		if (MarcaCX.equals("SI")) {
			if (marcaCronicidad.isSelected()) {
				data = true;
			} else {
				data = false;
				Log.info("Fallo al obtener la marca CI");
				return data;
			}
		} else {
			data = true;
		}

		if (MarcaPMI.equals("SI")) {
			if (marcaPMI.isSelected()) {
				data = true;
			} else {
				data = false;
				Log.info("Fallo al obtener la marca CI");
				return data;
			}
		} else {
			data = true;
		}

		return data;
	}

	public Boolean verificarCamposNoEditables() {
		Boolean dato = false;
		try {
			if (comboPlan.isEnabled() == true) {
				Log.info("Error al verificar el campo plan desactivado");
				return false;
			} else {
				dato = true;
			}

			if (comboMesaOperativa.isEnabled() == true) {
				Log.info("Error al verificar el campo mesa");
				return false;
			} else {
				dato = true;
			}

			if (campoReenvioMotivo.isEnabled() == true) {
				Log.info("Error al verificar el campo motivo");
				return false;
			} else {
				dato = true;
			}

			if (campoReenvioNroSocio.isEnabled() == true) {
				Log.info("Error al verificar el campo nro socio");
				return false;
			} else {
				dato = true;
			}

			if (campIdServicio.isEnabled() == true) {
				Log.info("Se verifica read only del campo id servicio");
				String readonly = campIdServicio.getAttribute("readonly");
				if (readonly != null) {
					dato = true;
				} else {
					Log.info("error al verificar read only del campo id servicio");
					return false;
				}
			} else {
				dato = true;
			}

			if (checkPediatria.isEnabled() == true) {
				Log.info("Error al verificar el campo pediatria");
				return false;
			} else {
				dato = true;
			}

			if (checkClinica.isEnabled() == true) {
				Log.info("Error al verificar el campo clinico");
				return false;
			} else {
				dato = true;
			}

		} catch (Exception e) {
			Log.info("Fallo al obtener los datos deshabilitados");
			e.printStackTrace();
		}
		return dato;
	}

	public String obtenerErrorReenvioLabelEmail() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(lblMsjErrorEmail));
			msjError = lblMsjErrorEmail.getText();
			Log.info("Se obtuvo el label de error del campo email");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo email");
			e.printStackTrace();
		}
		return msjError;
	}

	public void cargarEmailReenvio(String email) {
		try {
			campEmail.click();
			campEmail.clear();
			campEmail.sendKeys(email);
		} catch (Exception e) {
			Log.info("Fallo al cargar el campo email");
			e.printStackTrace();
		}
	}

	public void cargarTelefonoReenvio(String telefono) {
		try {
			campNTelefono.click();
			campNTelefono.clear();
			campNTelefono.sendKeys(telefono);
		} catch (Exception e) {
			Log.info("Fallo al cargar el campo telefono");
			e.printStackTrace();
		}
	}

	public String obtenerErrorReenvioLabelTelefono() {
		String msjError = null;
		try {
			campoReenvioMotivo.click();
			wait.until(ExpectedConditions.visibilityOf(lblMsjErrorTelefono));
			msjError = lblMsjErrorTelefono.getText();
			Log.info("Se obtuvo el label de error del campo telefono");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo telefono");
			e.printStackTrace();
		}
		return msjError;
	}

	public Boolean estaHabilitadoBtnReenviar() {
		Boolean estaHabilitado = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(formReenvio));
			estaHabilitado = formModalBtnReenviar.isEnabled();
			Log.info("Se obtuvo el elemento btnEnviarInvitacion");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnEnviarInvitacion");
		}
		return estaHabilitado;
	}

	public Boolean esVisibleBtnReenvioSalir() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnReenvioSalir));
			esVisible = btnReenvioSalir.isDisplayed();
			Log.info("Se obtuvo el elemento btnReenvioSalir");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnReenvioSalir");
		}
		return esVisible;
	}

	public void clicBotonReenvioSalir() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnReenvioSalir));
			btnReenvioSalir.click();
			Log.info("Se realizo clic en el elemento btnReenvioSalir");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento btnReenvioSalir");
		}
	}

	public Boolean esVisibleBtnReenvioCerrar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnReenvioCerrarPopup));
			esVisible = btnReenvioCerrarPopup.isDisplayed();
			Log.info("Se obtuvo el elemento btnReenvioCerrarPopup");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnReenvioCerrarPopup");
		}
		return esVisible;
	}

	public void clicBotonReenvioCerrar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnReenvioCerrarPopup));
			btnReenvioCerrarPopup.click();
			Log.info("Se realizo clic en el elemento btnReenvioCerrarPopup");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento btnReenvioCerrarPopup");
		}
	}

	public boolean existeInvitacionEnGrillaInvitaciones(String socio) {
		try {
			PageHelper.WaitForPageLoading();
			PageHelper.ScrollToTheTop();
			esperaCargaGrilla();
			List<WebElement> elementos = panelInvitaciones
					.findElements(By.xpath("//div/div[1]/div/div[2]/table/tbody/tr"));
			for (WebElement element : elementos) {
				String attribute = element.getAttribute("innerText");
				if (attribute.contains(socio)) {
					Log.info("El socio se encuentra en el panel de invitaciones");
					return true;
				}

			}
		} catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("El socio no se encuentra en el panel de invitaciones");
		}
		return false;
	}

	public Boolean socioEnSalaEspera(String socio) {
		Boolean socioSalaEspera = false;
		try {
			while (existeInvitacionEnGrillaInvitaciones(socio)) {
				waitFluent.until(ExpectedConditions.invisibilityOfAllElements(existeNroSocioEnInvitacionsPanel(socio)));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			Log.info("Falla verificar si el socio estpa en sala de espera");
		}
		return socioSalaEspera;
	}
	
	// Metodos para los casos de Grilla de invitaciones

	public Boolean esVisibleCheckGrillaInvitaciones() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(grillaInvitacionesCheckActivas));
			esVisible = grillaInvitacionesCheckActivas.isDisplayed();
			Log.info("Se obtuvo el elemento grillaInvitacionesCheckActivas");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento grillaInvitacionesCheckActivas");
		}
		return esVisible;
	}

	public Boolean esVisibleExportarGrillaInvitaciones() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(grillaInvitacionesCheckActivas));
			esVisible = grillaInvitacionesCheckActivas.isDisplayed();
			Log.info("Se obtuvo el elemento grillaInvitacionesCheckActivas");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento grillaInvitacionesCheckActivas");
		}
		return esVisible;
	}

	public Boolean esVisibleHoraActualizacionGrillaInvitaciones() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(grillaInvitacionesHoraActualizacion));
			esVisible = grillaInvitacionesHoraActualizacion.isDisplayed();
			Log.info("Se obtuvo el elemento grillaInvitacionesHoraActualizacion");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento grillaInvitacionesHoraActualizacion");
		}
		return esVisible;
	}

	public String recuperarCantidadInvGrillaInvitaciones() {
		String texto;
		try {
			actualizarGrillaInvitaciones();
			PageHelper.WaitForPageLoading();
			wait.until(ExpectedConditions.elementToBeClickable(grillaInvitacionesTitulo));
			texto = grillaInvitacionesTitulo.getAttribute("outerText").toString();
			texto = texto.substring(0, 30);
			Log.info("Se recupero el texto del elemento grillaInvitacionesTitulo");
			return texto;
		} catch (Exception e) {
			texto = null;
			Log.info(e.getMessage());
			Log.info("Fallo el recuperar el texto del elemento grillaInvitacionesTitulo");
		}

		return texto;

	}

	public String recuperarFechaActualizacionGrillaInvitaciones() {
		String texto;
		try {
			esperaCargaGrilla();
			wait.until(ExpectedConditions.elementToBeClickable(grillaInvitacionesHoraActualizacion));
			texto = grillaInvitacionesHoraActualizacion.getAttribute("outerText").toString();
			Log.info("Se recupero el texto del elemento grillaInvitacionesHoraActualizacion");
			return texto;
		} catch (Exception e) {
			texto = null;
			Log.info(e.getMessage());
			Log.info("Fallo el recuperar el texto del elemento grillaInvitacionesHoraActualizacion");
		}

		return texto;

	}

	public String recuperarTextoGrillaInvitaciones() {
		String texto;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(grillaInvitaciones));
			texto = grillaInvitaciones.getAttribute("outerText").toString();
			Log.info("Se recupero el texto del elemento grillaInvitaciones");
			return texto;
		} catch (Exception e) {
			Log.info(e.getMessage());
			texto = null;
			Log.info("Fallo el recuperar el texto del elemento grillaInvitaciones");
		}

		return texto;

	}

	public String recuperarColumnasGrillaInvitaciones() {
		String texto;
		try {
			WebElement columnasGrilla = panelInvitaciones
					.findElement(By.xpath("//div/div[1]/div/div[2]/table/tbody/tr"));
			texto = columnasGrilla.getAttribute("outerText").toString();
			Log.info("Se recuperan las columnas de la grilla de invitaciones correctamente");
			return texto;
		} catch (Exception e) {
			Log.info(e.getMessage());
			texto = null;
			Log.info("Error al recuperar las columnas de la grilla de invitaciones");
		}
		return texto;
	}

	// Metodos para los casos de anular

	public Boolean esVisibleBtnAnularSocio(String socio) {
		Boolean esVisible = false;
		try {
			btnAnular = existeNroSocioEnInvitacionsPanel(socio).findElement(By.xpath("./td[last()]/a[2]"));
			wait.until(ExpectedConditions.elementToBeClickable(btnAnular));
			esVisible = btnAnular.isDisplayed();
			Log.info("Se obtuvo el elemento btnSalirPopUpAnular");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnSalirPopUpAnular");
		}
		return esVisible;
	}

	public Boolean esVisibleAnularTxtMotivo() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(txtDetalleMotivo));
			esVisible = txtDetalleMotivo.isDisplayed();
			Log.info("Se obtuvo el elemento txtDetalleMotivo");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento txtDetalleMotivo");
		}
		return esVisible;
	}

	public Boolean esVisibleAnularBtnAnular() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAnularPopUp));
			esVisible = btnAnularPopUp.isDisplayed();
			Log.info("Se obtuvo el elemento btnAnularPopUp");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnAnularPopUp");
		}
		return esVisible;
	}

	public Boolean esVisibleBtnAnularSalir() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSalirPopUpAnular));
			esVisible = btnSalirPopUpAnular.isDisplayed();
			Log.info("Se obtuvo el elemento btnSalirPopUpAnular");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnSalirPopUpAnular");
		}
		return esVisible;
	}

	public Boolean esVisibleBtnAnularCerrar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnCerrarPopUpAnular));
			esVisible = btnCerrarPopUpAnular.isDisplayed();
			Log.info("Se obtuvo el elemento btnCerrarPopUpAnular");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnCerrarPopUpAnular");
		}
		return esVisible;
	}

	public Boolean estaHabilitadoBtnAnularPopUp() {
		Boolean estaHabilitado = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnAnularPopUp));
			estaHabilitado = btnAnularPopUp.isEnabled();
			Log.info("Se obtuvo el elemento btnAnularPopUp");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnAnularPopUp");
		}
		return estaHabilitado;
	}

	public boolean clicBotonAnular(String socio) {
		boolean anularOk = false;
		try {
			PageHelper.ScrollToTheTop();
			PageHelper.waitImplicit();
			btnAnular = existeNroSocioEnInvitacionsPanel(socio).findElement(By.xpath("./td[last()]/a[2]"));
			btnAnular.click();
			wait.until(ExpectedConditions.elementToBeClickable(txtDetalleMotivo));
			txtDetalleMotivo.click();
			Log.info("Se realizo clic en el elemento btnAnular");
			anularOk = true;
			formReenvio.click();
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fallo al hacer clic en el elemento btnAnular");
		}
		return anularOk;
	}

	public void clicBotonAnularSalir() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSalirPopUpAnular));
			btnSalirPopUpAnular.click();
			Log.info("Se realizo clic en el elemento btnSalirPopUpAnular");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento btnSalirPopUpAnular");
		}
	}

	public void clicBotonAnularCerrar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnCerrarPopUpAnular));
			btnCerrarPopUpAnular.click();
			Log.info("Se realizo clic en el elemento btnCerrarPopUpAnular");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento btnCerrarPopUpAnular");
		}
	}

	public void cargarMotivoAnular(String motivoAnular) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(txtDetalleMotivo));
			txtDetalleMotivo.click();
			txtDetalleMotivo.sendKeys(motivoAnular);
			Log.info("Se cargo el campo motivo anular");
		} catch (Exception e) {
			Log.info("Fallo al cargar el campo motivo anular");
			e.printStackTrace();
		}
	}

	// Metodos para probar check de invitaciones activas

	public void clicCheckInvitacionesActivas() {
		try {
			PageHelper.ScrollToTheTop();
			wait.until(ExpectedConditions.elementToBeClickable(grillaInvitacionesCheckActivas));
			grillaInvitacionesCheckActivas.click();
			Log.info("Se realizo clic en el elemento grillaInvitacionesCheckActivas");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento grillaInvitacionesCheckActivas");
			e.printStackTrace();
		}
	}

	public boolean existenInvitacionesEnGrilla() {
		Boolean existenInvitaciones = false;
		try {
			if (recuperarFechaActualizacionGrillaInvitaciones().contains("actualizado")) {
				wait.until(ExpectedConditions.visibilityOf(hayInvitacionesEnGrilla));
				existenInvitaciones = hayInvitacionesEnGrilla.isDisplayed();
				Log.info("Se muestran invitaciones en la grilla");
			}
		} catch (Exception e) {
			Log.info("No se muestran invitaciones en la grilla");
		}
		return existenInvitaciones;

	}

	// Metodo para actualizar la grilla de invitaciones

	public void actualizarGrillaInvitaciones() {
		try {
			quitarMensajesToast();
			PageHelper.ScrollToTheTop();
			wait.until(ExpectedConditions.elementToBeClickable(grillaInvitacionesHoraActualizacion));
			grillaInvitacionesHoraActualizacion.click();
			wait.until(ExpectedConditions.textToBePresentInElement(grillaInvitacionesHoraActualizacion, "actualizado"));
			Log.info("Se realizo clic en el elemento grillaInvitacionesHoraActualizacion");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento grillaInvitacionesHoraActualizacion");
			e.printStackTrace();
		}
	}

	// Metodo para los casos de exportar la grilla de invitaciones

	public void clicBtnExpotarGrillaInvitaciones() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(grillaInvitacionesBtnExportar));
			grillaInvitacionesBtnExportar.click();
			Log.info("Se realizo clic en el elemento grillaInvitacionesBtnExportar");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento grillaInvitacionesBtnExportar");
			e.printStackTrace();
		}
	}

	public Boolean esVisiblePopUpExportar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(popUpExportar));
			esVisible = popUpExportar.isDisplayed();
			Log.info("Se obtuvo el elemento popUpExportar");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento popUpExportar");
		}
		return esVisible;
	}

	public Boolean esVisibleFDesdePopUpExportar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(exportarPopUpFechaDesde));
			esVisible = exportarPopUpFechaDesde.isDisplayed();
			Log.info("Se obtuvo el elemento exportarPopUpFechaDesde");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento exportarPopUpFechaDesde");
		}
		return esVisible;
	}

	public Boolean esVisibleFHastaPopUpExportar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(exportarPopUpFechaHasta));
			esVisible = exportarPopUpFechaHasta.isDisplayed();
			Log.info("Se obtuvo el elemento exportarPopUpFechaHasta");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento exportarPopUpFechaHasta");
		}
		return esVisible;
	}

	public Boolean esVisibleBtnExportarPopUpExportar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(exportarPopUpBtnExportar));
			esVisible = exportarPopUpBtnExportar.isDisplayed();
			Log.info("Se obtuvo el elemento exportarPopUpBtnExportar");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento exportarPopUpBtnExportar");
		}
		return esVisible;
	}

	public Boolean esVisibleBtnSalirPopUpExportar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(exportarPopUpBtnSalir));
			esVisible = exportarPopUpBtnSalir.isDisplayed();
			Log.info("Se obtuvo el elemento exportarPopUpBtnSalir");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento exportarPopUpBtnSalir");
		}
		return esVisible;
	}

	public void clicBtnExpotarPopUpExportar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(exportarPopUpBtnExportar));
			exportarPopUpBtnExportar.click();
			Log.info("Se realizo clic en el elemento exportarPopUpBtnExportar");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento exportarPopUpBtnExportar");
			e.printStackTrace();
		}
	}
	
	public String recuperarMensajeToast() {
		String txtToast = null;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(toastMessage));
			txtToast = toastMessage.getText();
		}catch (Exception e) {
			Log.info("No se pudo recuperar el mensaje del toast");
		}
		return txtToast;
	}
	

	public void clicBtnSalirPopUpExportar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(exportarPopUpBtnSalir));
			exportarPopUpBtnSalir.click();
			Log.info("Se realizo clic en el elemento exportarPopUpBtnSalir");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el elemento exportarPopUpBtnSalir");
			e.printStackTrace();
		}
	}

	public void cargarFechaDesdePopUpExportar(String fechaDesde) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(exportarPopUpFechaDesde));
			exportarPopUpFechaDesde.click();
			exportarPopUpFechaDesde.clear();
			exportarPopUpFechaDesde.sendKeys(fechaDesde);
			Log.info("Se cargo el campo fecha desde");
		} catch (Exception e) {
			Log.info("Fallo al cargar el campo fecha desde");
			e.printStackTrace();
		}
	}

	public void cargarFechaHastaPopUpExportar(String fechaHasta) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(exportarPopUpFechaHasta));
			exportarPopUpFechaHasta.click();
			exportarPopUpFechaHasta.clear();
			exportarPopUpFechaHasta.sendKeys(fechaHasta);
			Log.info("Se cargo el campo fecha hasta");
		} catch (Exception e) {
			Log.info("Fallo al cargar el campo fecha hasta");
			e.printStackTrace();
		}
	}

	// Metodos para verificar estado de la invitacion

	public boolean invitacionVencida(String Socio) {
		boolean estaVencida = false;
		try {
			WebElement invitacion = existeNroSocioEnInvitacionsPanel(Socio);
			String propiedadEstiloInv = invitacion.getAttribute("Style").toString();
			if (propiedadEstiloInv.contains("background-color: black")) {
				estaVencida = true;
				Log.info("Se verifica que la invitacion se encuentra vencida");
			}

		} catch (Exception e) {
			Log.info("Fallo el verificar si la invitacion esta vencida");
			e.printStackTrace();
		}
		return estaVencida;
	}

	public boolean invitacion15MinutosEnGrilla(String Socio) {
		boolean estaRemarcada = false;
		try {
			WebElement invitacion = existeNroSocioEnInvitacionsPanel(Socio);
			String propiedadEstiloInv = invitacion.getAttribute("Style").toString();
			if (propiedadEstiloInv.contains("background-color: red")) {
				estaRemarcada = true;
				Log.info("Se verifica que la invitacion se encuentra remarcada en rojo");
			}

		} catch (Exception e) {
			Log.info("Fallo el verificar si la invitacion se encuentra remarcada en rojo");
			e.printStackTrace();
		}
		return estaRemarcada;
	}

	public boolean invitacion10MinutosEnGrilla(String Socio) {
		boolean estaRemarcada = false;
		try {
			WebElement invitacion = existeNroSocioEnInvitacionsPanel(Socio);
			String propiedadEstiloInv = invitacion.getAttribute("Style").toString();
			if (propiedadEstiloInv.contains("background-color: SandyBrown")) {
				estaRemarcada = true;
				Log.info("Se verifica que la invitacion se encuentra remarcada en naranja");
			}

		} catch (Exception e) {
			Log.info("Fallo el verificar si la invitacion se encuentra remarcada en naranja");
			e.printStackTrace();
		}
		return estaRemarcada;
	}

	public String recuperarFechaLecturaInvitacion(String socio) {
		String fechaLectura = null;
		try {
			WebElement invitacion = existeNroSocioEnInvitacionsPanel(socio);
			fechaLectura = invitacion.getText().substring(115, 130);
			int existeFechaLectura = fechaLectura.length();
			if (existeFechaLectura == 0) {
				fechaLectura = null;
			}
			Log.info("Se recupera la fecha de lectura de la invitacion");
		} catch (Exception e) {
			Log.info("Fallo al recuperar la fecha de lectura de la invitacion");
		}
		return fechaLectura;
	}

	public void quitarMensajesToast() {
		try {
			wait.until(ExpectedConditions.visibilityOf(toastMessage));
			while (PageHelper.elementStillPresent(toastMessage)) {
				toastMessage.click();
			}
			Log.info("No se muestran mas toastMessage");
		} catch (Exception e) {
			Log.info("No se muestra toastMessage");
		}
	}
	
	public void esperarActualizacionAutomatica() {
		try {
			wait.withTimeout(Duration.ofMinutes(1));
			Log.info("Se cumplio la espera para la actualizacion automatica");
		}catch (Exception e) {
			Log.info("Fallo la espera de la actualizacion");
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
