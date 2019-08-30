package PagesAdicional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import helpers.StepHelper;
import log.Log;

public class S_CallToTheOfficePage extends BasePage {

	@FindBy(xpath = "//button[@ng-click='verMedicoIngresarConsultorioCtrl.ingresarConsultorio()']")
	private WebElement btnEnter;

	@FindBy(xpath = "//button[@ng-click='verMedicoIngresarConsultorioCtrl.fireConfirmCancelarConsultaModal()']")
	private WebElement btnCancel;

	@FindBy(xpath = "//button[@ng-click='close()']")
	private WebElement btnAcceptWait;

	@FindBy(xpath = "//button[@ng-click='cancel()']")
	private WebElement btnCancelPopUp;

	@FindBy(xpath = "//button[@ng-click='cancelarConsulta()']")
	private WebElement btnAceptPopUp;

	public void enterCMO() {
		try {
			waitAlert();
//			wait.until(ExpectedConditions.elementToBeClickable(btnEnter));
			PageHelper.waitImplicit();
			btnEnter.click();
			Log.info("Se logro ingresar a la CMO correctamente");
		} catch (Exception e) {
			StepHelper.takeScreenShot("ErrorIngresarCMO");;
			Log.info(e.getMessage());
			Log.info("Falló el ingreso a la CMO");
		}
	}

	private void waitAlert() {
		try {
			if (btnAcceptWait.isEnabled()) {
				btnAcceptWait.click();
			}
		} catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("No se encontró el alerta de tiempo de espera");
		}
	}

}
