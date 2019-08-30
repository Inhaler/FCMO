package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import log.Log;

public class M_RecuperarContraseniaPage extends BasePage {
	
	@FindBy (name = "email")
	private WebElement campoUsuario;

	@FindBy (className = "reCaptcha")
	private WebElement cuadroReCaptcha;
	
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
	
	public Boolean esVisibleCaptcha() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(cuadroReCaptcha));	
			esVisible = cuadroReCaptcha.isDisplayed();
			Log.info("Se obtuvo el elemento cuadroReCaptcha");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento cuadroReCaptcha");
		}		
		return esVisible;
	}
}

