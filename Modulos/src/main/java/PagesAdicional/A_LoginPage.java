package PagesAdicional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import log.Log;

public class A_LoginPage extends BasePage {

	@FindBy(name = "user")
	private WebElement fieldUsser;

	@FindBy(name = "password")
	private WebElement fieldPass;

	@FindBy(css = "#main > div > div > div > div > div:nth-child(2) > div > div.panel-body > form > button")
	private WebElement btnIngresar;

	public void loginUsser(String usser, String password) {
		try {
			fieldUsser.sendKeys(usser);
			fieldPass.sendKeys(password);
			btnIngresar.click();
			Log.info("Se inicio sesión correctamente");
		} catch (Exception e) {
			Log.info("Fallo el inicio de sesión, usuario o contraseña incorrecta");
			e.printStackTrace();
		}

	}

	public void getUrl() {
		driver.getCurrentUrl();
	}
}
