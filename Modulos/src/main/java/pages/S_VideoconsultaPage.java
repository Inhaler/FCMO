package pages;

import base.BasePage;
import helpers.PageHelper;
import helpers.StepHelper;
import log.Log;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class S_VideoconsultaPage extends BasePage {
	@FindBy(xpath = "//button[@ng-click='verMedicoVideoConsultaCtrl.fireConfirmCancelarConsultaModal()']")
	private WebElement btnFinalizar;

	@FindBy(xpath = "//button[@ng-click='cancelarConsulta()']")
	private WebElement btnConfirmarFinalizar;

	@FindBy(xpath = "//button[@ng-click='cancel()']")
	private WebElement btnCancelarFinalizar;

	@FindBy(xpath = "//button[@ng-click='verMedicoVideoConsultaCtrl.toggleVideoChat()']")
	private WebElement btnChat;

	@FindBy(xpath = "//button[@ng-click='verMedicoVideoConsultaCtrl.toggleAttachFiles()']")
	private WebElement btnAdjunto;

	@FindBy(xpath = "//div[@class='video-chat__input__container']")
	private WebElement containerChat;

	@FindBy(xpath = "//input[@ng-model= 'verMedicoVideoConsultaCtrl.inputChatMsg']")
	private WebElement inputChat;

	@FindBy(xpath = "//form[@ng-submit='verMedicoVideoConsultaCtrl.sendChatMsg()']/input[2]")
	private WebElement btnEnviarChat;

	@FindBy(id = "file-archivo-adjunto")
	private WebElement btnSeleccionarArchivo;

	@FindBy(name = "descripcionAdjunto")
	private WebElement inputDescripcionArchivo;

	@FindBy(xpath = "//button[@ng-click='verMedicoVideoConsultaCtrl.uploadAdjunto()']")
	private WebElement btnSubirArchivo;
	
	@FindBy(id = "loading-bar")
	WebElement cargandoGrilla;

	public void clicBtnFinalizar() {
		try {
			esperaCargaGrilla();
			wait.until(ExpectedConditions.elementToBeClickable(btnFinalizar));
			btnFinalizar.click();
			Log.info("Se hizo click en el elemento btnFinalizar");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnFinalizar");
			e.printStackTrace();
		}
	}

	public void clicBtnConfirmarFinalizar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnConfirmarFinalizar));
			btnConfirmarFinalizar.click();
			esperaCargaGrilla();
			wait.until(ExpectedConditions.urlContains("ver-medico/video-consulta-calificacion"));
			Log.info("Se hizo click en el elemento btnConfirmarFinalizar");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnConfirmarFinalizar");
			e.printStackTrace();
		}
	}

	public void clicBtnCancelarFinalizar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnCancelarFinalizar));
			btnCancelarFinalizar.click();
			Log.info("Se hizo click en el elemento btnCancelarFinalizar");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnCancelarFinalizar");
			e.printStackTrace();
		}
	}

	public void clicBtnChat() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnChat));
			btnChat.click();
			Log.info("Se hizo click en el elemento btnChat");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnChat");
			e.printStackTrace();
		}
	}

	public void clicBtnAdjunto() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAdjunto));
			btnAdjunto.click();
			Log.info("Se hizo click en el elemento btnAdjunto");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnAdjunto");
			e.printStackTrace();
		}
	}

	public void clicBtnEnviarChat() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnEnviarChat));
			btnEnviarChat.click();
			Log.info("Se hizo click en el elemento btnEnviarChat");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnEnviarChat");
			e.printStackTrace();
		}
	}

	public void clicBtnSeleccionarArchivo() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSeleccionarArchivo));
			btnSeleccionarArchivo.click();
			Log.info("Se hizo click en el elemento btnSeleccionarArchivo");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnSeleccionarArchivo");
			e.printStackTrace();
		}
	}

	public void clicBtnSubirArchivo() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSubirArchivo));
			btnSubirArchivo.click();
			Log.info("Se hizo click en el elemento btnSubirArchivo");
		} catch (Exception e) {
			Log.info("Fallo el hacer click en el elemento btnSubirArchivo");
			e.printStackTrace();
		}
	}

	public Boolean esVisibleBtnFinalizar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnFinalizar));
			esVisible = btnFinalizar.isDisplayed();
			Log.info("Se obtuvo el elemento btnFinalizar");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnFinalizar");
		}
		return esVisible;
	}

	public Boolean esVisibleBtnConfirmarFinalizar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnConfirmarFinalizar));
			esVisible = btnConfirmarFinalizar.isDisplayed();
			Log.info("Se obtuvo el elemento btnConfirmarFinalizar");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnConfirmarFinalizar");
		}
		return esVisible;
	}

	public Boolean esVisibleBtnCancelarFinalizar() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnCancelarFinalizar));
			esVisible = btnCancelarFinalizar.isDisplayed();
			Log.info("Se obtuvo el elemento btnCancelarFinalizar");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnCancelarFinalizar");
		}
		return esVisible;
	}

	public Boolean esVisibleBtnChat() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnChat));
			esVisible = btnChat.isDisplayed();
			Log.info("Se obtuvo el elemento btnChat");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnChat");
		}
		return esVisible;
	}

	public Boolean esVisibleBtnAdjunto() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnAdjunto));
			esVisible = btnAdjunto.isDisplayed();
			Log.info("Se obtuvo el elemento btnAdjunto");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnAdjunto");
		}
		return esVisible;
	}

	public Boolean esVisibleFormChat() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(containerChat));
			esVisible = containerChat.isDisplayed();
			Log.info("Se obtuvo el elemento containerChat");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento containerChat");
		}
		return esVisible;
	}

	public Boolean esVisibleInputChat() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(inputChat));
			esVisible = inputChat.isDisplayed();
			Log.info("Se obtuvo el elemento inputChat");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento inputChat");
		}
		return esVisible;
	}

	public Boolean estaHabilitadoInputChat() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(inputChat));
			esVisible = inputChat.isEnabled();
			Log.info("Se obtuvo el elemento inputChat");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento inputChat");
		}
		return esVisible;
	}

	public Boolean esVisibleBtnEnviarChat() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnEnviarChat));
			esVisible = btnEnviarChat.isDisplayed();
			Log.info("Se obtuvo el elemento btnEnviarChat");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnEnviarChat");
		}
		return esVisible;
	}

	public Boolean esVisibleBtnSeleccionarArchivo() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSeleccionarArchivo));
			esVisible = btnSeleccionarArchivo.isDisplayed();
			Log.info("Se obtuvo el elemento btnSeleccionarArchivo");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnSeleccionarArchivo");
		}
		return esVisible;
	}

	public Boolean esVisibleInputDescripcionArchivo() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(inputDescripcionArchivo));
			esVisible = inputDescripcionArchivo.isDisplayed();
			Log.info("Se obtuvo el elemento inputDescripcionArchivo");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento inputDescripcionArchivo");
		}
		return esVisible;
	}

	public Boolean esVisibleBtnSubirArchivo() {
		Boolean esVisible = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSubirArchivo));
			esVisible = btnSubirArchivo.isDisplayed();
			Log.info("Se obtuvo el elemento btnSubirArchivo");
		} catch (Exception e) {
			Log.info("Fallo al obtener el elemento btnSubirArchivo");
		}
		return esVisible;
	}

	public void finalizarVideoconsulta() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnFinalizar));
			btnFinalizar.click();

			while (!PageHelper.elementStillPresent(btnConfirmarFinalizar)) {
				PageHelper.WaitForPageLoading();
			}
			btnConfirmarFinalizar.click();
			Log.info("Se finaliza correctamente la VC");
		} catch (InterruptedException e) {
			e.printStackTrace();
			Log.info("Falla el finalizar la VC");
		}

	}

	public void enviarChat(String texto) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnChat));
			btnChat.click();
			wait.until(ExpectedConditions.visibilityOf(containerChat));
			wait.until(ExpectedConditions.elementToBeClickable(inputChat));
			inputChat.sendKeys(texto);
			btnEnviarChat.click();
			esperaCargaGrilla();
			btnChat.click();
			Log.info("Se envio correctamente el chat");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Falla el enviar un chat");
		}
	}
	
	public void esperaCargaGrilla() {
		try {
			wait.until(ExpectedConditions.visibilityOf(cargandoGrilla));
			while (PageHelper.elementStillPresent(cargandoGrilla)) {
				wait.until(ExpectedConditions.stalenessOf(cargandoGrilla));
			}
			Log.info("Se espera que se cargue la grilla");
		} catch (Exception e) {
			Log.info("No se muestra la barra de carga de grilla");
		}
	}

	
}
