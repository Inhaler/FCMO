package PagesAdicional;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class M_PreviewPage extends BasePage {
	
	@FindBy (xpath = "//button[@ng-click='atenderProxPacienteCtrl.atenderPaciente()']")
	private WebElement btnAttendPatient;
	
	@FindBy (xpath = "//button[@ng-click='atenderProxPacienteCtrl.rechazarPaciente()']")	
	private WebElement btnReturn;
	
	@FindBy (xpath = "//div[@ng-if='brand !== brands.OSDEINTERCONSULTA']")
	private WebElement infoInvitation;

	@FindBy (xpath = "//div[@ng-if='atenderProxPacienteCtrl.historialPaciente !== null && atenderProxPacienteCtrl.historialPaciente.length > 0']")
	private WebElement infoHistory;
	
	
	public void recoverInformationPreview() {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(infoHistory));
		Log.info(infoInvitation.getAttribute("textContent"));
		Log.info(infoHistory.getAttribute("textContent"));
		Log.info("Se recupera información de la preview");
		} catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("Error recuperando la información de la preview");
		}
	}
	
	
	public void callPatient() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAttendPatient));
			recoverInformationPreview();
			btnAttendPatient.click();
		}catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("Error llamando al socio");
		}
	}
}
