package steps;

import static config.DataSetter.configuration;

import base.BaseStep;
import helpers.PageHelper;
import helpers.StepHelper;
import junit.framework.Assert;
import pages.M_LoginPage;
import pages.M_RecuperarContraseniaPage;

public class M_Login_Recuperar_ContraseniaStep extends BaseStep {
	
	
	public static void Run(String testName) {
		
		String nombrePaso = "";
		try {
			
			log.Log.startTestCase(testName);
			
			PageHelper.deleteAllCookies(driver);
			
			nombrePaso = "1_Se verifica la visualización del botón para recuperar contraseña";
			NavigateToSite(configuration.getUrlMedico());
			CurrentPage = (new M_LoginPage().GetInstance(M_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			
			Assert.assertTrue(CurrentPage.As(M_LoginPage.class).esVisibleBtnRecuperarContrasenia());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "2_Se ingresa a recuperar contraseña";
			CurrentPage.As(M_LoginPage.class).clicBtnRecuperarContrasenia();
			log.Log.SuccessStep(nombrePaso);
			StepHelper.takeScreenShot(testName);

			nombrePaso = "3_Se verifica la visualización del campo usuario";
			CurrentPage = (new M_RecuperarContraseniaPage().GetInstance(M_RecuperarContraseniaPage.class));
			Assert.assertTrue(CurrentPage.As(M_RecuperarContraseniaPage.class).esVisibleCampoUsuario());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "4_Se verifica la visualización del campo recaptcha";
			Assert.assertTrue(CurrentPage.As(M_RecuperarContraseniaPage.class).esVisibleCaptcha());
			log.Log.SuccessStep(nombrePaso);
			StepHelper.takeScreenShot(testName);
	
		} catch (AssertionError ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(nombrePaso);
			Assert.fail("Fallo test - " + testName + " - Step: " + nombrePaso);
		}
		log.Log.endTestCase(testName);	
	}
}
