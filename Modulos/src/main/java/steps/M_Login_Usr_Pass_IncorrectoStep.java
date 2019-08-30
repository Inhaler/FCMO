package steps;

import static config.DataSetter.configuration;

import base.BaseStep;
import context.Usuario;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import junit.framework.Assert;
import pages.M_LoginPage;

public class M_Login_Usr_Pass_IncorrectoStep extends BaseStep {
	
	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
					
			PageHelper.deleteAllCookies(driver);
			
			nombrePaso = "1_Se ingresa al Login";
			NavigateToSite(configuration.getUrlMedico());
			CurrentPage = (new M_LoginPage().GetInstance(M_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "2_Se verifica mensaje de Alerta";
			Assert.assertTrue(CurrentPage.As(M_LoginPage.class).esVisibleCampoEmail());
			CurrentPage.As(M_LoginPage.class).ingresarEmail(usr.getEmail());
			CurrentPage.As(M_LoginPage.class).ingresarContrasenia(usr.getPassword());
			CurrentPage.As(M_LoginPage.class).clicBtnIngresar();

			Assert.assertTrue(CurrentPage.As(M_LoginPage.class).obtenerTituloAlertaLogin("Error"));	
			Assert.assertTrue(CurrentPage.As(M_LoginPage.class).obtenerMensajeAlertaLogin("Usuario o contraseña incorrectos o cuenta no activada"));
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);
			
		} catch (AssertionError ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(nombrePaso);
			Assert.fail("Fallo test - " + testName + " - Step: " + nombrePaso);
		}
		log.Log.endTestCase(testName);	
	}
}
