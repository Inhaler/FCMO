package PagesAdicional;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class S_EmailPage extends BasePage {

	@FindBy(id = "identifierId")
	private WebElement inputEmail;

	@FindBy(id = "identifierNext")
	private WebElement btnNext;

	@FindBy(name = "password")
	private WebElement inputPassword;

	@FindBy(id = "passwordNext")
	private WebElement btnPassword;

	@FindBy(xpath = "//div[@class='Cp']/div/table/tbody")
	private WebElement emails;

	@FindBy(xpath = "//a[contains (@href, 'https://bpr3.test-app.link/')]")
	private WebElement linkInvitation;

	@FindBy(xpath = "//div[@data-tooltip='Mostrar contenido acortado']")
	private WebElement btnDots;

	public void loginGmail(String email, String password) {
		try {
			inputEmail.click();
			inputEmail.sendKeys(email);
			btnNext.click();
			wait.until(ExpectedConditions.elementToBeClickable(inputPassword));
			PageHelper.waitImplicit();
			inputPassword.click();
			inputPassword.sendKeys(password);
			btnPassword.click();
			Log.info("Se inicio correctamente la sesión");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info("Falló el login en el correo");
		}

	}

	public void openEmail() {
		try {
			findEmail().click();
			Log.info("Se encontró el correo de invitación");
		} catch (Exception e) {
			System.out.print(e.getMessage());
			Log.info("Falla el ingreso al correo de invitación");
		}
	}

	private WebElement findEmail() {
		try {
			List<WebElement> tr = emails.findElements(By.tagName("tr"));
			for (WebElement tds : tr) {
				WebElement td = tds.findElement(By.xpath("./td[5]"));
				if (td.getAttribute("textContent").contains("Invitación a Consulta Médica OnLine")) {
					return td;
				}
			}
			return null;
		} catch (Exception e) {
			Log.info(e.getMessage());
			Log.info("No se encontró el correo de invitación");
			return null;
		}
	}

	public void goToTheLink() {
		try {
			PageHelper.ScrollToTheBottom();
			if (btnDots.isEnabled()) {
				btnDots.click();
				wait.until(ExpectedConditions.elementToBeClickable(linkInvitation));
				PageHelper.ScrollToTheBottom();
				linkInvitation.click();
			}
			Log.info("Se logro ingresar al link");
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(linkInvitation));
			linkInvitation.click();
			Log.info(e.getMessage());
			Log.info("Se logro ingresar al link");
		}
	}

}
