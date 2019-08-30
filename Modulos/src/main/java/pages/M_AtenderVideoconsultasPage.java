package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import log.Log;

public class M_AtenderVideoconsultasPage extends BasePage {
	
	@FindBy(xpath = "//button[@ng-click='atenderVideoConsultaCtrl.ingresarGuardia()']")
	private WebElement btnEntrarGuardia;

	@FindBy(xpath = "//button[@ng-click='atenderVideoConsultaCtrl.goToProximoPaciente()']")
	private WebElement btnVerProxPaciente;

	@FindBy(xpath = "//button[@ng-click='atenderVideoConsultaCtrl.salirGuardia()']")
	private WebElement btnSalirGuardia;

	@FindBy(className = "consultorio-info")
	private WebElement panelInformacion;
	
	
	
	public Boolean esVisiblePanelInformacion() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(panelInformacion));
			esVisible = panelInformacion.isDisplayed();
			Log.info("Se obtuvo el elemento panelInformacion");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento panelInformacion");
		}
		return esVisible;
	}
	
	
	public Boolean esVisibleBotonEntrarGuardia() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnEntrarGuardia));
			esVisible = btnEntrarGuardia.isDisplayed();
			Log.info("Se obtuvo el elemento btnEntrarGuardia");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnEntrarGuardia");
		}
		return esVisible;
	}
	
	
	public Boolean esVisibleBotonSalirGuardia() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSalirGuardia));
			esVisible = btnSalirGuardia.isDisplayed();
			Log.info("Se obtuvo el elemento btnSalirGuardia");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnSalirGuardia");
		}
		return esVisible;
	}

	
	public Boolean estaHabilitadoBotonVerProximoPaciente() {
		Boolean esVisible = false;
		try {
			waitFluent.until(ExpectedConditions.elementToBeClickable(btnVerProxPaciente));
			esVisible = btnVerProxPaciente.isEnabled();
			Log.info("Se obtuvo el elemento btnVerProxPaciente");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnVerProxPaciente");
		}
		return esVisible;
	}
	
	
	public void clicBtnIngresarGuardia() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnEntrarGuardia));
			action.moveToElement(btnEntrarGuardia).click().build().perform();
			Log.info("Se hizo click en el boton para entrar a la guardia");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton para entrar a la guardia");
			e.printStackTrace();
		}
	}
	
	public void clicBtnSalirGuardia() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSalirGuardia));
			action.moveToElement(btnSalirGuardia).click().build().perform();
			Log.info("Se hizo click en el boton para salir de la guardia");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton para salir de la guardia");
			e.printStackTrace();
		}
	}
	
	
	public void clicBtnVerProxPaciente() {
		try {
			waitFluent.until(ExpectedConditions.elementToBeClickable(btnVerProxPaciente));
			action.moveToElement(btnVerProxPaciente).click().build().perform();
			wait.until(ExpectedConditions.urlContains("guardia/atender-videoconsulta/proximo-paciente"));
			Log.info("Se hizo click en el boton para ver proximo paciente");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton para ver proximo paciente");
			e.printStackTrace();
		}
	}
	
	
	
	
}
