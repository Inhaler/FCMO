package PagesAdicional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import log.Log;

public class M_EndCMOPage extends BasePage {

	@FindBy(xpath = "//button[@ng-click='atenderVideoConsultaCalificacionCtrl.seguirAtendiendo()']")
	private WebElement btnSeguirAtendiendo;

	public void continueAttending() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSeguirAtendiendo));
			btnSeguirAtendiendo.click();
			Log.info("Se continua atendiendo exitosamente");
		} catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("Falló seguir atendiendo");
		}
	}

}
