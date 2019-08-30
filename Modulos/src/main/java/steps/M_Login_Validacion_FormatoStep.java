package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import base.BaseStep;
import context.Usuario;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.M_LoginPage;

public class M_Login_Validacion_FormatoStep extends BaseStep {
	
	
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
			
			nombrePaso = "2_Se valida el formato del correo";
			CurrentPage.As(M_LoginPage.class).ingresarEmail(usr.getEmail());
			CurrentPage.As(M_LoginPage.class).clickCampoContrasenia();
			
			Assert.assertEquals(CurrentPage.As(M_LoginPage.class).obtenerErrorLabelEmail(),
					"El campo debe ser un email válido");
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
