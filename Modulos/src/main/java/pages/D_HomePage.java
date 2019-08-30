package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class D_HomePage extends BasePage {

	@FindBy(css = "#main > div > div > div.container-fluid.main-full > div > div > div.col-xs-12.col-md-5 > div > div > div > button")
	private WebElement moduloInvitaciones;

	@FindBy(id = "btSalir")
	private WebElement btnSalir;

	@FindBy(xpath = "//div[@id='navbar']/ul/li[2]")
	private WebElement btnCambiarContrasenia;

	@FindBy(xpath = "//*[@id='navbar']/ul/li[1]")
	private WebElement labelUsuario;

	@FindBy(className = "toast-message")
	private WebElement alertaMensajeLogin;

	public void ingresarModuloInvitaciones() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(moduloInvitaciones));
			moduloInvitaciones.click();
			Log.info("Se ingresa al modulo de invitaciones");
		} catch (Exception e) {
			Log.info("Fallo al ingresar al modulo de invitaciones");
			e.printStackTrace();
		}
	}

	public void clicBtnSalir() {
		try {
			esVisibleAlertaLogin();
			wait.until(ExpectedConditions.elementToBeClickable(btnSalir));
			PageHelper.waitImplicit();
			while (PageHelper.elementStillPresent(btnSalir)) {
				btnSalir.click();
				PageHelper.WaitForPageLoading();
			}
			Log.info("Se hizo click en el boton Salir");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton Salir");
			e.printStackTrace();
		}
	}

	public void clicBtnCambiarContrasenia() {
		try {
			esVisibleAlertaLogin();
			wait.until(ExpectedConditions.elementToBeClickable(btnCambiarContrasenia));
			PageHelper.waitImplicit();
			action.moveToElement(btnCambiarContrasenia).click().build().perform();
			Log.info("Se hizo click en el elemento btnCambiarContrasenia");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnCambiarContrasenia");
			e.printStackTrace();
		}
	}

	public Boolean esVisibleUsuarioLogueado() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(labelUsuario));
			esVisible = labelUsuario.isDisplayed();
			Log.info("Se obtuvo el elemento campoUsuario");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campoUsuario");
		}
		return esVisible;
	}

	public Boolean esVisibleBotonSalir() {
		Boolean esVisible = false;
		try {
			esVisibleAlertaLogin();
			wait.until(ExpectedConditions.elementToBeClickable(btnSalir));
			esVisible = btnSalir.isDisplayed();
			Log.info("Se obtuvo el elemento btnSalir");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnSalir");
		}
		return esVisible;
	}

	public Boolean esVisibleBotonCambiarContrasenia() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnCambiarContrasenia));
			esVisible = btnCambiarContrasenia.isDisplayed();
			Log.info("Se obtuvo el elemento btnCambiarContrasenia");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnCambiarContrasenia");
		}
		return esVisible;
	}

	public Boolean esVisibleModuloinvitaciones() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(moduloInvitaciones));
			esVisible = moduloInvitaciones.isDisplayed();
			Log.info("Se obtuvo el elemento moduloInvitaciones");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento moduloInvitaciones");
		}
		return esVisible;
	}

	public void esVisibleAlertaLogin() {
		try {
			if (alertaMensajeLogin.isDisplayed()) {
				alertaMensajeLogin.click();
				ExpectedConditions.not(ExpectedConditions.visibilityOf(alertaMensajeLogin));
				Log.info("Se cerró la alerta de login correctamente");
			}
		} catch (Exception e) {
			Log.info("No se encuentra visible el mensaje de alerta");

		}
	}
}
