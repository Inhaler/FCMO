package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class D_CambiarContraseniaPage extends BasePage {

	@FindBy(id = "newPassword")
	WebElement campoNuevaContrasenia;

	@FindBy(id = "repeatNewPassword")
	WebElement campoReingresarContrasenia;
	
	@FindBy (id = "full-bar")
	WebElement labelCambiarContrasenia;

	@FindBy(xpath = "//div[@id='main']/div/div[2]/footer/div/div/div/div[2]/button")
	WebElement btnCambiar;

	@FindBy(xpath = "//div[@id='main']/div/div[2]/footer/div/div/div/div[1]/button")
	WebElement btnCancelar;

	@FindBy(className = "toast-message")
	WebElement toastMessage;

	@FindBy(name = "changePasswordForm")
	WebElement formChangePassword;

	@FindBy(css = "#main > div > div.container-fluid.main-full > div > div > form > div:nth-child(1) > div > div.help-block.ng-active")
	WebElement mensajeValidacion;


	@FindBy(css = "#main > div > div.container-fluid.main-full > div > div > form > div:nth-child(2) > div > div.help-block.ng-active")
	WebElement mensajeValidacionReingreso;

	
	public void cancelarCambio() {
		wait.until(ExpectedConditions.elementToBeClickable(btnCancelar));
		btnCancelar.click();

	}
	
	public void ingresarNuevaContrasenia(String contrasenia) {
		try {
			campoNuevaContrasenia.click();
			campoNuevaContrasenia.sendKeys(contrasenia);
			Log.info("Se ingreso el campo nueva contraseña");
		} catch (Exception e) {
			Log.info("Fallo al ingresar el campo nueva contraseña");
			e.printStackTrace();
		}
	} 
	
	public void ingresarReingresarContrasenia(String contrasenia) {
		try {
			campoReingresarContrasenia.click();
			campoReingresarContrasenia.sendKeys(contrasenia);
			Log.info("Se ingreso el campo reingresar contraseña");
		} catch (Exception e) {
			Log.info("Fallo al ingresar el campo reingresar contraseña");
			e.printStackTrace();
		}
	} 
	
	public void clickCampoNuevaContrasenia() {
		try {
			campoNuevaContrasenia.click();
			Log.info("Se hizo click en el campo nueva contraseña");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el campo nueva contraseña");
			e.printStackTrace();
		}
		
	}
	
	public void clickCampoReingresarContrasenia() {
		try {
			campoReingresarContrasenia.click();
			Log.info("Se hizo click en el campo reingresar contraseña");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el campo reingresar contraseña");
			e.printStackTrace();
		}
		
	}
	
	public void clicBtnCambiar() {
		try {
			btnCambiar.click();
			Log.info("Se hizo click en el boton Cambiar");
		} catch (Exception e) {
			Log.info("Fallo al ingresar Cambiar");
			e.printStackTrace();
		}
	}
	
	public String obtenerErrorLabelNuevaContrasenia() {
		
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(mensajeValidacion));
			msjError = mensajeValidacion.getText();
			Log.info("Se obtuvo el label de error del campo nueva contraseña");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo nueva contraseña");
			e.printStackTrace();
		}
		return msjError;

	}
	
	public String obtenerErrorLabelReingresarContrasenia() {
		String msjError = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(mensajeValidacionReingreso));
			msjError = mensajeValidacionReingreso.getText();
			Log.info("Se obtuvo el label de error del campo reingresar contraseña");
		} catch (Exception e) {
			Log.info("Fallo al obtener el label de error del campo reingresar contraseña");
			e.printStackTrace();
		}
		return msjError;
	}
	
	
	
	public Boolean esVisibleCampoNuevaContrasenia() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoNuevaContrasenia));	
			esVisible = campoNuevaContrasenia.isDisplayed();
			Log.info("Se obtuvo el elemento campoNuevaContrasenia");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campoNuevaContrasenia");
		}		
		return esVisible;
	}
	
	
	public Boolean esVisibleCampoReingresarContrasenia() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(campoReingresarContrasenia));	
			esVisible = campoReingresarContrasenia.isDisplayed();
			Log.info("Se obtuvo el elemento campoReingresarContrasenia");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento campoReingresarContrasenia");
		}		
		return esVisible;
	}
	
	
	public Boolean esVisibleTituloCambiarContrasenia() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(labelCambiarContrasenia));	
			esVisible = labelCambiarContrasenia.isDisplayed();
			Log.info("Se obtuvo el elemento labelCambiarContrasenia");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento labelCambiarContrasenia");
		}		
		return esVisible;
	}	
	
	public String recuperarTituloCambiarContrasenia() {
		return labelCambiarContrasenia.getText();
	}
	
	
	public Boolean esVisibleBotonCambiar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(btnCambiar));	
			esVisible = btnCambiar.isDisplayed();
			Log.info("Se obtuvo el elemento btnCambiar");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnCambiar");
		}		
		return esVisible;
	}
	
	public String validateMessage() {
		return toastMessage.getText();
		
	}
	
	public void borrarCampoNuevaContrasenia() {
		try {
			campoNuevaContrasenia.clear();
			Log.info("Se borro el campo nueva contraseña");
		} catch (Exception e) {
			Log.info("Fallo al borrar el campo nueva contraseña");
			e.printStackTrace();
		}
	}
	
	public void borrarCampoReingresarContrasenia() {
		try {
			campoReingresarContrasenia.clear();
			Log.info("Se borro el campo reingresar contraseña");
		} catch (Exception e) {
			Log.info("Fallo al borrar el campo reingresar contraseña");
			e.printStackTrace();
		}
	}
	
}
