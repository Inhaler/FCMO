package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_LoginPage;
import context.Usuario;
import base.BaseStep;

public class D_Login_IngresoStep extends BaseStep {
	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
		
			PageHelper.deleteAllCookies(driver);
			nombrePaso = "1_Se ingresa a Login Despacho";
			NavigateToSite(configuration.getUrlPrestadores());
			CurrentPage = (new D_LoginPage().GetInstance(D_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);
			CurrentPage.As(D_LoginPage.class).ingresarUsuario(usr.getEmail());
			CurrentPage.As(D_LoginPage.class).ingresarContrasenia( usr.getPassword());
			CurrentPage.As(D_LoginPage.class).clicBtnIngresar();
			nombrePaso = "2_Se verifica el mensaje de Bienvenida";
			Assert.assertTrue(CurrentPage.As(D_LoginPage.class).obtenerMensajeAlertaLogin("Bienvenido!"));
			log.Log.SuccessStep(nombrePaso);
			StepHelper.takeScreenShot(testName);			
		} catch (AssertionError ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(nombrePaso);
			StepHelper.takeScreenShot(testName);
			Assert.fail("Fallo test - " + testName + " - Step: " + nombrePaso);
		}
		log.Log.endTestCase(testName);	
	}

}
