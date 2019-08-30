package PagesAdicional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class M_GuardPage extends BasePage {

	@FindBy(xpath = "//button[@ng-click='atenderVideoConsultaCtrl.ingresarGuardia()']")
	private WebElement btnEnterGuard;

	@FindBy(xpath = "//button[@ng-click='atenderVideoConsultaCtrl.goToProximoPaciente()']")
	private WebElement btnSeeNext;

	@FindBy(xpath = "//button[@ng-click='atenderVideoConsultaCtrl.salirGuardia()']")
	private WebElement btnSignOffGuard;

	@FindBy(className = "consultorio-info")
	private WebElement infoPanel;

	public void enterGuard() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnEnterGuard));
			btnEnterGuard.click();
			Log.info("Se ingreso a la gurdia correctamente");
		} catch (Exception e) {
			Log.info("Falló el ingreso a la guardia");
			System.out.println(e.getStackTrace());
		}

	}

	public void singOffGuard() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSignOffGuard));
			btnSignOffGuard.click();
			PageHelper.waitImplicit();
			Log.info("Se salio de la gurdia correctamente");
		} catch (Exception e) {
			Log.info("Falló la salida de la guardia");
			System.out.println(e.getStackTrace());
		}

	}

	public void attendPatient() {
		try {
			while (!btnSeeNext.isEnabled()) {
				wait.until(ExpectedConditions.elementToBeClickable(btnSeeNext));
			}
			btnSeeNext.click();
			PageHelper.WaitForPageLoading();
		} catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("Falla atender al paciente");
		}
	}

	public void getPatientInformation() {
		wait.until(ExpectedConditions.visibilityOfAllElements(infoPanel));
		Log.info(infoPanel.getAttribute("textContent"));
	}

}
