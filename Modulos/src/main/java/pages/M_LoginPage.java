package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import log.Log;

public class M_LoginPage extends BasePage {

	@FindBy (id = "email")
	private WebElement campoEmail;
	
	@FindBy (id = "password")
	private WebElement campoContrasenia;
	
	@FindBy (id = "submit")
	private WebElement btnIngresar;
	
	@FindBy(className = "toast-message")
	private WebElement alertaMensajeLogin;
		
	@FindBy(className = "toast-title")
	private WebElement alertaTituloLogin;
	
	@FindBy(css = "#main > div > footer")
	private WebElement labelFooter;
	
	@FindBy(css = "#main > div > div.jumbotron.jumbotron--login > div > div > div > form > div.form-group.has-feedback.has-error > div > p")
	private WebElement labelMsjErrorEmail;
	
	@FindBy(css = "#main > div > div.jumbotron.jumbotron--login > div > div > div > form > div:nth-child(3) > div > p")
	private WebElement labelMsjErrorContrasenia;
	
	@FindBy (xpath = "//a[@ui-sref='reset_password']")
	private WebElement btnRecuperarContrasenia;
	
	public void getUrl() {
		driver.getCurrentUrl();
	}
	
	public void ingresarEmail(String email) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoEmail));
			campoEmail.sendKeys(email);
			Log.info("Se ingreso el correo");
		} catch (Exception e) {
			Log.info("Fallo al ingresar el correo");
			e.printStackTrace();
		}
	}
	
	public void ingresarContrasenia(String pass) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoContrasenia));
			campoContrasenia.sendKeys(pass);
			Log.info("Se ingreso la contrasenia");
		} catch (Exception e) {
			Log.info("Fallo al ingresar contrasenia");
			e.printStackTrace();
		}
	}
	
	public void borrarCampoContrasenia() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoContrasenia));
			campoContrasenia.clear();
			Log.info("Se borro el campo contrasenia");
		} catch (Exception e) {
			Log.info("Fallo al borrar el campo contrasenia");
			e.printStackTrace();
		}
	}
	
	public void borrarCampoEmail() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoEmail));
			campoEmail.clear();
			Log.info("Se borro el correo");
		} catch (Exception e) {
			Log.info("Fallo al borrar el  correo");
			e.printStackTrace();
		}
	}
	
	public void clickCampoEmail() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoEmail));
			campoEmail.click();
			Log.info("Se hizo click en el campo Email");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el campo Email");
			e.printStackTrace();
		}
		
	}
	
	public void clickCampoContrasenia() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoContrasenia));
			campoContrasenia.click();
			Log.info("Se hizo click en el campo contraseña");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el campo contraseña");
			e.printStackTrace();
		}
		
	}
	
	public void clicBtnIngresar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnIngresar));
			btnIngresar.click();
			Log.info("Se hizo click en el boton Ingresar");
		} catch (Exception e) {
			Log.info("Fallo al ingresar contrasenia");
			e.printStackTrace();
		}
	}
	
	
	public void clicBtnRecuperarContrasenia() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnRecuperarContrasenia));
			btnRecuperarContrasenia.click();
			Log.info("Se hizo click en el boton para recuperar contraseña");
		} catch (Exception e) {
			Log.info("Fallo al ingresar a recuperar contraseña");
			e.printStackTrace();
		}
	}
	
	
	public Boolean obtenerMensajeAlertaLogin(String msj) {
		
		Boolean mensaje = false;
		
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(alertaMensajeLogin, msj));
			mensaje = true;
			Log.info("Se obtuvo el mensaje de alerta");
		} catch (Exception e) {
			Log.info("Fallo al obtener mensaje de alerta");
		}
		
		return mensaje;

	}
	
	public Boolean obtenerTituloAlertaLogin(String msj) {
		
		Boolean titulo = false;
		
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(alertaTituloLogin, msj));
			titulo = true;
			Log.info("Se obtuvo el titulo del alerta");
		} catch (Exception e) {
			Log.info("Fallo al obtener titulo del alerta");
		}
		
		return titulo;

	}
	
	public String obtenerErrorLabelEmail() {
		
		String msjError = null;
		
		try {
			wait.until(ExpectedConditions.visibilityOf(labelMsjErrorEmail));
			msjError = labelMsjErrorEmail.getText();
			Log.info("Se obtuvo el label de error del campo Email");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo Email");
			e.printStackTrace();
		}
		
		return msjError;

	}
	
	public String obtenerErrorLabelContrasenia() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(labelMsjErrorContrasenia));
			msjError = labelMsjErrorContrasenia.getText();
			Log.info("Se obtuvo el label de error del campo contrasenia");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo contrasenia");
			e.printStackTrace();
		}
		return msjError;
	}
	
	public String obtenerLabelFooter() {
		
		String mensaje = null;
		
		try {
			mensaje = labelFooter.getText();
			Log.info("Se obtuvo el mensaje del footer");
		} catch (Exception e) {
			e.getStackTrace();
			Log.info("Fallo al obtener mensaje de footer");
		}
		
		return mensaje;

	}
	
	public Boolean esVisibleLabelFooter() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(labelFooter));	
			esVisible = labelFooter.isDisplayed();
			Log.info("Se obtuvo el elemento footer");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento footer");
		}		
		return esVisible;
	}

	
	public Boolean esVisibleCampoEmail() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoEmail));	
			esVisible = campoEmail.isDisplayed();
			Log.info("Se obtuvo el elemento campoEmail");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campoEmail");
		}		
		return esVisible;
	}
	
	public Boolean esVisibleCampoContrasenia() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoContrasenia));	
			esVisible = campoContrasenia.isDisplayed();
			Log.info("Se obtuvo el elemento campoContrasenia");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campoContrasenia");
		}		
		return esVisible;
	}
	
	
	public Boolean esVisibleBtnRecuperarContrasenia() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnRecuperarContrasenia));	
			esVisible = btnRecuperarContrasenia.isDisplayed();
			Log.info("Se obtuvo el elemento btnOlvidoContrasenia");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnOlvidoContrasenia");
		}		
		return esVisible;
	}
	
	public Boolean estaHabilitadoBotonIngresar() {
		Boolean esVisible = false;
		try {
			esVisible = btnIngresar.isEnabled();
			Log.info("Se obtuvo el elemento boton Ingresar");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento boton Ingresar");
		}		
		return esVisible;
	}

	
	
}
