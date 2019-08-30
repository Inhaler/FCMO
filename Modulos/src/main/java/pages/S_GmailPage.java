package pages;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class S_GmailPage extends BasePage {

	@FindBy(id = "identifierId")
	private WebElement inputEmail;

	@FindBy(id = "identifierNext")
	private WebElement btnSiguiente;

	@FindBy(name = "password")
	private WebElement inputPassword;

	@FindBy(id = "passwordNext")
	private WebElement btnPassword;

	@FindBy(xpath = "//div[@class='Cp']/div/table/tbody")
	private WebElement emails;

	@FindBy(xpath = "//a[contains (@href, 'https://bpr3.test-app.link/')]")
	private WebElement linkInvitacion;
	
	@FindBy(xpath = "//table[contains (@outerText, 'te damos la bienvenida.')][1]")
	private WebElement textoCorreo;

	@FindBy(xpath = "//div[@data-tooltip='Mostrar contenido reducido'][last()]")
	private WebElement btnVerMasCorreos;
	
	@FindBy(xpath = "//div[@data-tooltip='Mostrar contenido acortado'][last()]")
	private WebElement btnVerMasCorreos2;

	@FindBy(xpath = "//table[@role='presentation']")
	private WebElement presentacionCorreo;
	
	@FindBy(xpath = "//span[contains (@outerText, 'osdeconsultamedicaonline@osde.com.ar')]")
	private WebElement remitenteCorreo;

	@FindBy(xpath = "//div[@data-tooltip='Seleccionar']")
	private WebElement btnSeleccionarEmails;

	public void loginGmail(String email, String password) {
		try {
			PageHelper.WaitForPageLoading();
			if (!verificarSesionIniciada()) {
				inputEmail.click();
				inputEmail.sendKeys(email);
				btnSiguiente.click();
				wait.until(ExpectedConditions.elementToBeClickable(inputPassword));
				PageHelper.WaitForPageLoading();
				inputPassword.click();
				inputPassword.sendKeys(password);
				btnPassword.click();
				PageHelper.WaitForPageLoading();
				Log.info("Se inicia correctamente la sesion");
			}
		} catch (Exception e) {
			Log.info("Fallo el login en el correo");
			e.printStackTrace();
		}

	}

	
	public boolean verificarSesionIniciada() {
		boolean sesionIniciada = true;
		try {
			if (inputEmail.isDisplayed()) {
				sesionIniciada = false;
				Log.info("La sesion no se encuentra iniciada");
			}
		} catch (Exception e) {
			Log.info("La sesion se encuentra iniciada");
		}
		return sesionIniciada;
	}
	public WebElement encontrarCorreo(String asunto) {
		WebElement correo = null;
		try {
			PageHelper.WaitForPageLoading();
			wait.until(ExpectedConditions.elementToBeClickable(btnSeleccionarEmails));
			List<WebElement> tr = emails.findElements(By.tagName("tr"));
			for (WebElement tds : tr) {
				WebElement td = tds.findElement(By.xpath("./td[6]"));
				String textoContenido = td.getAttribute("textContent");
				if (textoContenido.contains(asunto)) {
					correo = tds;
					break;
				}
			}
		} catch (Exception e) {
			Log.info("Fallo al encontrar el correo");
			e.printStackTrace();
		}
		return correo;
	}

	public void abrirCorreo(String asuntoCorreo) {
		try {
			WebElement correo = encontrarCorreo(asuntoCorreo);
			wait.until(ExpectedConditions.elementToBeClickable(correo));
			correo.click();
			Log.info("Se logro abrir el correo");
		} catch (Exception e) {
			WebElement correoNuevo = encontrarCorreo(asuntoCorreo);
			correoNuevo.click();
			Log.info("Se volvio a localizar el correo y se abrio correctamente");
		}

	}

	public void ingresarLink() {
		try {
			PageHelper.ScrollToTheBottom();
			wait.until(ExpectedConditions.titleContains("Invitación a Consulta Médica OnLine"));
			wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(presentacionCorreo, By.tagName("tr")));
			PageHelper.WaitForPageLoading();
			verificarSiSeMuestraBtnVerMas();
			PageHelper.ScrollToTheBottom();
			clicInvitacion();
			Log.info("Se ingresa al link");
		} catch (Exception e) {
			Log.info("Fallo ingresar al link");
			e.printStackTrace();
		}
	}

	
	public void clicInvitacion() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(linkInvitacion));
			linkInvitacion.click();
			Log.info("Se hace clic en el link de la invitacion");
		}catch (Exception e) {
			WebElement linkInv = driver.findElement(By.partialLinkText("aqu"));
			wait.until(ExpectedConditions.elementToBeClickable(linkInv));
			linkInv.click();
			Log.info("Se vuelve a encontrar el link de la invitacion y se hace clic");
		}
	}
	public boolean verificarIngresoAlLink() {
		boolean correctoIngreso = false;
		try {
			if (PageHelper.countTabs() == 3) {
				correctoIngreso = true;
				Log.info("Se ingreso correctamente al link");
			} else {
				Log.info("No se abrio la ventana del link");
			}
		} catch (Exception e) {
			Log.info("Fallo el ingresar al link de la invitacion");
		}
		return correctoIngreso;
	}
	
	public void verificarSiSeMuestraBtnVerMas() {
		try {
			PageHelper.ScrollToTheBottom();
			for (int y=0; y<5000; y++) {
				if (PageHelper.elementStillPresent(btnVerMasCorreos)){ 
					btnVerMasCorreos.click();
					Log.info("Se muestra el boton para visualizar mas correos");
					break;
				} else if (PageHelper.elementStillPresent(btnVerMasCorreos2)) {
					btnVerMasCorreos2.click();
					Log.info("Se muestra el boton para visualizar mas correos");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("No se muestra boton para ver mas correos");
		}
		Log.info("Se verifica boton para ver mas correos");
	}

}
