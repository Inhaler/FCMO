package PagesAdicional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import helpers.PageHelper;
import log.Log;

public class S_VideoCallPage extends BasePage {

	@FindBy (xpath ="//button[@ng-click='verMedicoVideoConsultaCtrl.fireConfirmCancelarConsultaModal()']")
	private WebElement btnFinalizar;
	
	@FindBy (xpath = "//button[@ng-click='cancelarConsulta()']")
	private WebElement btnConfirmarFinalizar;
	
	@FindBy (xpath = "//button[@ng-click='cancel()']")
	private WebElement btnCancelarFinalizar;

	@FindBy (xpath ="//button[@ng-click='verMedicoVideoConsultaCtrl.toggleVideoChat()']")
	private WebElement btnChat;

	@FindBy (xpath ="//button[@ng-click='verMedicoVideoConsultaCtrl.toggleAttachFiles()']")
	private WebElement btnAdjunto;
	
	@FindBy (xpath = "//div[@class='video-chat__input__container']")
	private WebElement containerChat;

	@FindBy (xpath = "//input[@ng-model= 'verMedicoVideoConsultaCtrl.inputChatMsg']")
	private WebElement inputChat;
	
	@FindBy (xpath = "//form[@ng-submit='verMedicoVideoConsultaCtrl.sendChatMsg()']/input[2]")
	private WebElement btnEnviarChat;
	
	@FindBy (id = "file-archivo-adjunto")
	private WebElement btnSeleccionarArchivo;
	
	@FindBy (name = "descripcionAdjunto")
	private WebElement btnDescripcionArchivo;
	
	@FindBy (xpath ="//button[@ng-click='verMedicoVideoConsultaCtrl.uploadAdjunto()']")
	private WebElement btnSubirArhcivo;
	
	
	public void closeVideoCall() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnFinalizar));
			btnFinalizar.click();
			//wait.until(ExpectedConditions.visibilityOf(btnConfirmarFinalizar));
			PageHelper.waitImplicit();
			btnConfirmarFinalizar.click();
			PageHelper.WaitForPageLoading();
			Log.info("Se finalizó correctamente la VC");			
		} catch (InterruptedException e) {
			e.printStackTrace();
			Log.info("Falló el finalizar la VC");
		}
		
	}
	
	public void sendChat(String texto) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnChat));
			btnChat.click();
			wait.until(ExpectedConditions.elementToBeClickable(containerChat));
			inputChat.sendKeys(texto);
			btnEnviarChat.click();
			PageHelper.WaitForPageLoading();
			btnChat.click();
			Log.info("Se envio correctamente el chat");			
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Falló el enviar un chat");
		}
	}
	
}
