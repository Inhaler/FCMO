package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import log.Log;

public class M_PrevisualizacionPacientePage extends BasePage {

	@FindBy (xpath = "//button[@ng-click='atenderProxPacienteCtrl.atenderPaciente()']")
	private WebElement btnAtender;
	
	@FindBy (xpath = "//button[@ng-click='atenderProxPacienteCtrl.rechazarPaciente()']")	
	private WebElement btnVolver;
	
	@FindBy (xpath = "//div[@ng-if='brand !== brands.OSDEINTERCONSULTA']")
	private WebElement infoInvitacion;

	@FindBy (xpath = "//div[@ng-if='atenderProxPacienteCtrl.historialPaciente !== null && atenderProxPacienteCtrl.historialPaciente.length > 0']")
	private WebElement infoHistorialConsulta;

	
	public boolean esVisibleBtnAtender(){
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAtender));
			esVisible = btnAtender.isDisplayed();
			Log.info("Se obtuvo el elemento btnAtenderProximoPaciente");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnAtenderProximoPaciente");
		}
		return esVisible;
	}
	
	public boolean estaHabilitadoBtnAtender() {
		Boolean estaHabilitado = false;
		try {
			waitFluent.until(ExpectedConditions.elementToBeClickable(btnAtender));
			estaHabilitado = btnAtender.isEnabled();
			Log.info("El elemento btnAtenderProximoPaciente se encuentra habilitado");
		} catch (Exception e) {
			Log.info("Fallo al obtener el estado del elemento btnAtenderProximoPaciente");
		}
		return estaHabilitado;
	}
	
	public void clicBtnAtender() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAtender));
			btnAtender.click();
			wait.until(ExpectedConditions.urlContains("atender-videoconsulta/atender-paciente/"));
			Log.info("Se hizo click en el boton btnAtender");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton btnAtender");
			e.printStackTrace();
		}
	}

	public void clicBtnVolver() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnVolver));
			btnVolver.click();
			Log.info("Se hizo click en el boton btnVolver");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton btnVolver");
			e.printStackTrace();
		}
	}
	

	public Boolean esVisibleInformacionInvitacion() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(infoInvitacion));
			esVisible = infoInvitacion.isDisplayed();
			Log.info("Se obtuvo el elemento infoInvitacion");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento infoInvitacion");
		}
		return esVisible;
	}

	public Boolean esVisibleBotonVolver() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnVolver));
			esVisible = btnVolver.isDisplayed();
			Log.info("Se obtuvo el elemento btnVolver");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnVolver");
		}
		return esVisible;
	}

	
	public Boolean esVisibleInformacionHistorial() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(infoHistorialConsulta));
			esVisible = infoHistorialConsulta.isDisplayed();
			Log.info("Se obtuvo el elemento infoHistorialConsulta");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento infoHistorialConsulta");
		}
		return esVisible;
	}


}
