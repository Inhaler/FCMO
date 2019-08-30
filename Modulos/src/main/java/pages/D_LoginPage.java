package pages;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class D_LoginPage extends BasePage {

	@FindBy(name = "user")
	private WebElement campoUsuario;

	@FindBy(name = "password")
	private WebElement campoContrasenia;

	@FindBy(css = "#main > div > div > div > div > div:nth-child(2) > div > div.panel-body > form > button")
	private WebElement btnIngresar;
	
	@FindBy(css = "#main > div > div > div > div > div:nth-child(2) > div > div.panel-body > form > div:nth-child(1) > div > p")
	private WebElement labelMsjErrorUsuario;
	
	@FindBy(css = "#main > div > div > div > div > div:nth-child(2) > div > div.panel-body > form > div:nth-child(3) > div > p")
	private WebElement labelMsjErrorContrasenia;

	@FindBy(className = "toast-message")
	private WebElement alertaMensajeLogin;
		
	@FindBy(className = "toast-title")
	private WebElement alertaTituloLogin;
	
	@FindBy(css = "#full-footer-end > div")
	private WebElement labelFooter;
	
		

	public void loginUsser(String user, String password) {
		try {
			campoUsuario.sendKeys(user);
			campoContrasenia.sendKeys(password);
			btnIngresar.click();
			Log.info("Se inicio sesion correctamente");
		} catch (Exception e) {
			Log.info("Fallo el inicio de sesion, usuario o password incorrecta");
			e.printStackTrace();
		}
	}

	public void getUrl() {
		driver.getCurrentUrl();
	}
	
	public void ingresarUsuario(String user) {
		try {
			campoUsuario.sendKeys(user);
			Log.info("Se ingreso el usuario");
		} catch (Exception e) {
			Log.info("Fallo al ingresar usuario");
			e.printStackTrace();
		}
	}
	
	public void ingresarContrasenia(String pass) {
		try {
			campoContrasenia.sendKeys(pass);
			Log.info("Se ingreso la contrasenia");
		} catch (Exception e) {
			Log.info("Fallo al ingresar contrasenia");
			e.printStackTrace();
		}
	}
	
	public void borrarCampoContrasenia() {
		try {
			campoContrasenia.clear();
			Log.info("Se borro el campo contrasenia");
		} catch (Exception e) {
			Log.info("Fallo al borrar el campo contrasenia");
			e.printStackTrace();
		}
	}
	
	public void borrarCampoUsuario() {
		try {
			campoUsuario.clear();
			Log.info("Se borro el campo usuario");
		} catch (Exception e) {
			Log.info("Fallo al borrar el campo usuario");
			e.printStackTrace();
		}
	}
	
	public void clickCampoUsuario() {
		try {
			campoUsuario.click();
			Log.info("Se hizo click en el campo usuario");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el campo usuario");
			e.printStackTrace();
		}
		
	}
	
	public void clickCampoContrasenia() {
		try {
			campoContrasenia.click();
			Log.info("Se hizo click en el campo contrasenia");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el campo contrasenia");
			e.printStackTrace();
		}
		
	}
	
	public void clicBtnIngresar() {
		try {
			btnIngresar.click();
			Log.info("Se hizo click en el boton Ingresar");
		} catch (Exception e) {
			Log.info("Fallo al hacer clic en el boton Ingresar");
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
	
	public String obtenerErrorLabelUsuario() {
		
		String msjError = null;
		
		try {
			wait.until(ExpectedConditions.visibilityOf(labelMsjErrorUsuario));
			msjError = labelMsjErrorUsuario.getText();
			Log.info("Se obtuvo el label de error del campo usuario");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo usuario");
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

	
	public Boolean esVisibleCampoUsuario() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoUsuario));	
			esVisible = campoUsuario.isDisplayed();
			Log.info("Se obtuvo el elemento campoUsuario");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campoUsuario");
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
