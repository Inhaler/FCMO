package PagesAdicional;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import helpers.PageHelper;
import base.BasePage;
import log.Log;

public class D_InvitacionPage extends BasePage {

	@FindBy(css = "#main > div > div > div > div > div.col-lg-12.text-right > button")
	WebElement btnEnviarInvitacion;

	@FindBy(className = "panel-heading")
	WebElement divInvitacion;

	@FindBy(css = "#enviarInvitacionForm > div > div > div.form-group.form-group-sm.has-feedback.has-error > div.row > div.col-md-8 > div > input")
	WebElement campNSocio;

	
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

	@FindBy(css = "#enviarInvitacionForm > div > footer > div > div > div > div:nth-child(2) > button")
	WebElement btnEnviar;

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

	@FindBy(id="phone")
	WebElement campoTelPopUp;
	
	@FindBy(id="email")
	WebElement campoEmailPopUp;	
	
	
	
	public void openInvitationForm() {
		if (isInvitationButtonDisplayed()) {
			btnEnviarInvitacion.click();
			wait.until(ExpectedConditions.elementToBeClickable(divInvitacion));
		} else {
			Log.info("Invitaciones manuales deshabilitadas");
		}
	}

	public boolean isInvitationButtonDisplayed() {
		wait.until(ExpectedConditions.elementToBeClickable(panelInvitaciones));
		if (btnEnviarInvitacion.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public void generateInvitation(String NSocio, String NTelefono, String Email, String Especialidad,
			String DetalleMotivo, String Nombre, String Apellido, String FechaNacimiento, String idServicio,
			String MesaOperativa, String Plan, String Provincia, String Localidad, String Barrio, String MarcaCI,
			String MarcaDiscapacidad, String MarcaID, String MarcaCX, String MarcaPMI) {
		try {
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

			Select selectPlan = new Select(comboPlan);
			selectPlan.selectByVisibleText(Plan);

			Select selectMesaOperativa = new Select(comboMesaOperativa);
			selectMesaOperativa.selectByVisibleText(MesaOperativa);

			campIdServicio.click();
			campIdServicio.sendKeys(idServicio);

			Select selectProvincia = new Select(comboProvincia);
			selectProvincia.selectByVisibleText(Provincia);

			// List <WebElement> options = selectProvincia.getOptions();
			// for (WebElement op : options) {
			// System.out.println(op.getAttribute("value"));
			// }

			Select selectLocalidad = new Select(comboLocalidad);
			selectLocalidad.selectByVisibleText(Localidad);

			// List <WebElement> localidades = selectLocalidad.getOptions();
			// for (WebElement op : localidades) {
			// System.out.println(op.getAttribute("value"));
			// }
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
			wait.until(ExpectedConditions.textToBePresentInElement(toastMessage, "Invitación enviada."));
			Log.info("Invitacion enviada correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cancelInvitation(String socio) {
		try {
			Log.info("Comienza la anulacion de la invitacion");
			PageHelper.waitImplicit();
			btnAnular = isElementInInvitationsPanel(socio).findElement(By.xpath("./td[last()]/a[2]"));
			wait.until(ExpectedConditions.elementToBeClickable(btnAnular));
			btnAnular.click();
			wait.until(ExpectedConditions.elementToBeClickable(txtDetalleMotivo));
			txtDetalleMotivo.sendKeys(socio);
			wait.until(ExpectedConditions.elementToBeClickable(btnAnularPopUp));
			btnAnularPopUp.click();
			PageHelper.WaitForPageLoading();
			Log.info(toastMessage.getText());
			// wait.until(ExpectedConditions.textToBePresentInElement(toastMessage,
			// "Invitación anulada exitosamente"));
			Log.info("Finaliza la anulacion de la invitacion");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void resendInvitation(String socio) {
		try {
			Log.info("Comienza el reenvio de la invitacion");
			PageHelper.ScrollToTheTop();
			PageHelper.waitImplicit();
			btnReenviar = isElementInInvitationsPanel(socio).findElement(By.xpath("./td[last()]/a"));
			btnReenviar.click();
			PageHelper.ScrollingToElement(formModalBtnReenviar);
			formModalBtnReenviar.click();
			PageHelper.WaitForPageLoading();
			Log.info("Finaliza el reenvio de la invitacion");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public WebElement isElementInInvitationsPanel(String socio) {
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
		}
		return null;
	}

	public WebElement isElementInVideoconsultasPanel(String socio) {
		try {
			List<WebElement> elementos = panelVideoconsultas.findElements(By.xpath("./tbody/tr"));
			for (WebElement element : elementos) {
				String attribute = element.getAttribute("innerText");
				if (attribute.contains(socio)) {
					Log.info("El socio se encuentra en el panel de videoconsultas");
					return element;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void viewAttentionDetail(String socio) {
		try {
			PageHelper.waitImplicit();
			WebElement row = isElementInVideoconsultasPanel(socio);
			row.click();
			PageHelper.waitImplicit();
			Log.info(modalDetail.getAttribute("textContent"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void returnToTheDoctor(String Socio, String tel, String email) {
		try {
			viewAttentionDetail(Socio);
			btnDevolverMed.click();
			PageHelper.waitImplicit();
			checkEditar.click();
			campoTelPopUp.clear();
			campoTelPopUp.click();
			campoTelPopUp.sendKeys(tel);
			campoEmailPopUp.click();
			campoEmailPopUp.clear();
			campoEmailPopUp.sendKeys(email);
			btnContinuarPopUp.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void returnToTheAssociate(String Socio, String tel, String email) {
		try {
			viewAttentionDetail(Socio);
			btnDevolverSocio.click();
			PageHelper.waitImplicit();
			checkEditar.click();
			campoTelPopUp.clear();
			campoTelPopUp.click();
			campoTelPopUp.sendKeys(tel);
			campoEmailPopUp.click();
			campoEmailPopUp.clear();
			campoEmailPopUp.sendKeys(email);
			btnContinuarPopUp.click();
			PageHelper.WaitForPageLoading();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void returnToTheAssociatePriority(String Socio, String tel, String email) {
		try {
			viewAttentionDetail(Socio);
			btnDevolverSocioPrioridad.click();
			PageHelper.waitImplicit();
			checkEditar.click();
			campoTelPopUp.clear();
			campoTelPopUp.click();
			campoTelPopUp.sendKeys(tel);
			campoEmailPopUp.click();
			campoEmailPopUp.clear();
			campoEmailPopUp.sendKeys(email);
			btnContinuarPopUp.click();
			PageHelper.WaitForPageLoading();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
