package PagesAdicional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class S_TermsPage extends BasePage {

	@FindBy(xpath = "//input[@ng-click='linkSharedGuestCtrl.enableNoSleep()']")
	private WebElement checkAcept;

	@FindBy(xpath = "//a[@ng-click='linkSharedGuestCtrl.fireTerminos()']")
	private WebElement readTerms;

	@FindBy(xpath = "//div[@class='btn-block']")
	private WebElement btnEnter;

	public void EnterTerms() {
		try {
			checkAcept.click();
			wait.until(ExpectedConditions.elementToBeClickable(btnEnter));
			btnEnter.click();
			PageHelper.WaitForPageLoading();
			Log.info("Se ingreso correctamente a los términos y condiciones");
		} catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("Fallo enviar los términos y condiciones");
		}
	}
	
	public void validateTerms() {
		
	}

}
