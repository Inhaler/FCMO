package pages;

import base.BasePage;
import helpers.PageHelper;
import helpers.StepHelper;
import log.Log;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class S_SalaEsperaPage extends BasePage {

	@FindBy(xpath = "//button[@ng-click='verMedicoIngresarConsultorioCtrl.ingresarConsultorio()']")
	private WebElement btnEntrar;

	@FindBy(xpath = "//button[@ng-click='verMedicoIngresarConsultorioCtrl.fireConfirmCancelarConsultaModal()']")
	private WebElement btnCancelar;

	@FindBy(xpath = "//button[@ng-click='close()']")
	private WebElement btnAceptarEspera;

	@FindBy(xpath = "//a[@ng-click='verMedicoSalaEsperaCtrl.fireConfirmCancelarConsultaModal()']")
	private WebElement btnCancelarSalaEspera;
	
	@FindBy(xpath = "//button[@ng-click='cancel()']")
	private WebElement btnCancelarPopUp;

	@FindBy(xpath = "//button[@ng-click='cancelarConsulta()']")
	private WebElement btnAceptarPopUp;
	
	@FindBy(id = "loading-bar")
	WebElement cargandoGrilla;

	public void aceptarConsulta() {
		try {
			aceptarAlertaTiempoEpera();
			while (!PageHelper.elementStillPresent(btnEntrar)) {
				esperaCargaGrilla();
			}
			btnEntrar.click();
			wait.until(ExpectedConditions.urlContains("/ver-medico/video-consulta/"));
			Log.info("Se logro ingresar a la CMO correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Falla el ingreso a la CMO");
		}
	}
	
	public void rechazarConsulta() {
		try {
			aceptarAlertaTiempoEpera();
			while (!PageHelper.elementStillPresent(btnCancelar)) {
				esperaCargaGrilla();
			}
			btnCancelar.click();
			Log.info("Se logro rechazar la consulta");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Falla el rechazo a la consulta");
		}
	}
	

	public void aceptarAlertaTiempoEpera() {
		try {
			wait.until(ExpectedConditions.visibilityOf(btnAceptarEspera));
			if (btnAceptarEspera.isEnabled()) {
				btnAceptarEspera.click();
				Log.info("Se quita el alerta de tiempo de espera");
			}
		} catch (Exception e) {
			Log.info("No se muestra el alerta de tiempo de espera");
		}
	}
	
	
	public void clicBtnCancelarSalaEspera() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnCancelarSalaEspera));
			btnCancelarSalaEspera.click();
			Log.info("Se hizo click en el elemento btnCancelarSalaEspera");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnCancelarSalaEspera");
			e.printStackTrace();
		}
	}
	
	public void clicBtnAceptarCancelacion() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAceptarPopUp));
			btnAceptarPopUp.click();
			Log.info("Se hizo click en el elemento btnAceptarPopUp");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnAceptarPopUp");
			e.printStackTrace();
		}
	}
	
	public void clicBtnCancelarCancelacion() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnCancelarPopUp));
			btnCancelarPopUp.click();
			Log.info("Se hizo click en el elemento btnCancelarPopUp");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnCancelarPopUp");
			e.printStackTrace();
		}
	}
	
	
	public Boolean esVisibleBotonAceptarConsulta() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnEntrar));
			esVisible = btnEntrar.isDisplayed();
			Log.info("Se obtuvo el elemento btnEntrar");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnEntrar");
		}
		return esVisible;
	}
	
	public Boolean esVisibleBotonRechazarConsulta() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnCancelar));
			esVisible = btnCancelar.isDisplayed();
			Log.info("Se obtuvo el elemento btnCancelar");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnCancelar");
		}
		return esVisible;
	}
	
	public Boolean esVisibleBotonCancelarPopUp() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnCancelarPopUp));
			esVisible = btnCancelarPopUp.isDisplayed();
			Log.info("Se obtuvo el elemento btnCancelarPopUp");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnCancelarPopUp");
		}
		return esVisible;
	}
	
	public Boolean esVisibleBotonAceptarPopUp() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAceptarPopUp));
			esVisible = btnAceptarPopUp.isDisplayed();
			Log.info("Se obtuvo el elemento btnAceptarPopUp");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnAceptarPopUp");
		}
		return esVisible;
	}
	
	public Boolean esVisibleBotonCancelarSalaEspera() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnCancelarSalaEspera));
			esVisible = btnCancelarSalaEspera.isDisplayed();
			Log.info("Se obtuvo el elemento btnCancelarSalaEspera");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnCancelarSalaEspera");
		}
		return esVisible;
	}
	
	public Boolean esVisibleBtnTiempoEspera() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAceptarEspera));
			esVisible = btnAceptarEspera.isDisplayed();
			Log.info("Se obtuvo el elemento btnAceptarEspera");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnAceptarEspera");
		}
		return esVisible;
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
