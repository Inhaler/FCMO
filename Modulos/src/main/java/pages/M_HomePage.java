package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class M_HomePage extends BasePage {

	@FindBy(xpath = "//button[@ng-click='homeCtrl.guardiaAccederGo()']")
	private WebElement moduloAtenderVideoconsultas;

	@FindBy(xpath = "//a[@id='btSalir']")
	private WebElement btnSalir;

	@FindBy(xpath = "//*[@id='navbar']/ul/li[3]")
	private WebElement btnToolBox;

	@FindBy(xpath = "//*[@id='navbar']/ul/li[2]")
	private WebElement btnMiPerfil;

	@FindBy(xpath = "//*[@id='navbar']/ul/li[1]")
	private WebElement labelUsuario;

	@FindBy(className = "toast-message")
	private WebElement alertaMensajeLogin;

	public boolean esVisibleMenuAtenderVideoconsultas() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(moduloAtenderVideoconsultas));
			esVisible = moduloAtenderVideoconsultas.isDisplayed();
			Log.info("Se obtuvo el elemento moduloAtenerVideoconsultas");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento moduloAtenerVideoconsultas");
		}
		return esVisible;
	}

	public void ingresarModuloAtenderVideoconsultas() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(moduloAtenderVideoconsultas));
			moduloAtenderVideoconsultas.click();
			Log.info("Se ingresa al modulo de Atender Videconsultas");
		} catch (Exception e) {
			Log.info("Fallo al ingresar al modulo de Atender Videconsultas");
			e.printStackTrace();
		}
	}

	public void clicBtnSalir() {
		try {
			esVisibleAlertaLogin();
			PageHelper.waitImplicit();
			wait.until(ExpectedConditions.elementToBeClickable(btnSalir));
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

	public void clicBtnToolBox() {
		try {
			esVisibleAlertaLogin();
			wait.until(ExpectedConditions.elementToBeClickable(btnToolBox));
			PageHelper.waitImplicit();
			action.moveToElement(btnToolBox).click().build().perform();
			Log.info("Se hizo click en el boton toolbox");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton toolbox");
			e.printStackTrace();
		}
	}

	public void clicBtnMiPerfil() {
		try {
			esVisibleAlertaLogin();
			wait.until(ExpectedConditions.elementToBeClickable(btnMiPerfil));
			PageHelper.waitImplicit();
			action.moveToElement(btnMiPerfil).click().build().perform();
			Log.info("Se hizo click en el elemento btnMiPerfil");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnMiPerfil");
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
			wait.until(ExpectedConditions.visibilityOf(btnSalir));
			esVisible = btnSalir.isDisplayed();
			Log.info("Se obtuvo el elemento btnSalir");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnSalir");
		}
		return esVisible;
	}

	public Boolean esVisibleBotonToolBox() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnToolBox));
			esVisible = btnToolBox.isDisplayed();
			Log.info("Se obtuvo el elemento btnToolBox");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnToolBox");
		}
		return esVisible;
	}

	public Boolean esVisibleBotonMiPerfil() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnMiPerfil));
			esVisible = btnMiPerfil.isDisplayed();
			Log.info("Se obtuvo el elemento btnMiPerfil");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnMiPerfil");
		}
		return esVisible;
	}

	public void esVisibleAlertaLogin() {
		try {
			if (alertaMensajeLogin.isDisplayed()) {
				alertaMensajeLogin.click();
				ExpectedConditions.not(ExpectedConditions.visibilityOf(alertaMensajeLogin));
				Log.info("Se cerro la alerta de login correctamente");
			}
		} catch (Exception e) {
			Log.info("No se encuentra visible el mensaje de alerta");

		}
	}

}
