package pages;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class S_TerminosYCondicionesPage extends BasePage {

	@FindBy(xpath = "//input[@ng-model='linkSharedGuestCtrl.formData.terminos']")
	private WebElement checkAceptar;

	@FindBy(xpath = "//a[@ng-click='linkSharedGuestCtrl.fireTerminos()']")
	private WebElement btnLeerTerminos;

	@FindBy(xpath = "//div[@class='btn-block']")
	private WebElement btnEntrar;


	public void AceptarTerminos() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(checkAceptar));
			checkAceptar.click();
			wait.until(ExpectedConditions.elementToBeClickable(btnEntrar));
			btnEntrar.click();
			PageHelper.WaitForPageLoading();
			wait.until(ExpectedConditions.urlContains("ver-medico/sala-espera/"));
			Log.info("Se aceptaron los terminos y condiciones");
		} catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("Fallo aceptar los terminos y condiciones");
		}
	}
	
	public Boolean esVisibleCheckAceptarInvitacion() {
		Boolean esVisible = false;
		try {
			PageHelper.WaitForPageLoading();
			wait.until(ExpectedConditions.elementToBeClickable(checkAceptar));
			esVisible = checkAceptar.isDisplayed();
			Log.info("Se obtuvo el elemento checkAceptar");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento checkAceptar");
		}
		return esVisible;
	}
	
	
	public Boolean esVisibleBtnLeerTerminos() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnLeerTerminos));
			esVisible = btnLeerTerminos.isDisplayed();
			Log.info("Se obtuvo el elemento btnLeerTerminos");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnLeerTerminos");
		}
		return esVisible;
	}
	
	public void clicLeerTerminosYCondiciones() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnLeerTerminos));
			btnLeerTerminos.click();
			Log.info("Se hizo click en el boton btnLeerTerminos");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el boton btnLeerTerminos");
			e.printStackTrace();
		}
	}
	
	
}
