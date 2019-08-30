package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_LoginPage;
import context.Usuario;
import base.BaseStep;

public class D_Login_Validacion_Usr_Pass_IncorrectoStep extends BaseStep {
	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
		
			nombrePaso = "1_Se ingresa a Login Despacho";
			NavigateToSite(configuration.getUrlPrestadores());
			CurrentPage = (new D_LoginPage().GetInstance(D_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "2_Se verifica el mensaje de Alerta";
			CurrentPage.As(D_LoginPage.class).ingresarUsuario(usr.getEmail());
			CurrentPage.As(D_LoginPage.class).ingresarContrasenia( usr.getPassword());
			CurrentPage.As(D_LoginPage.class).clicBtnIngresar();
			
			Assert.assertTrue(CurrentPage.As(D_LoginPage.class).obtenerTituloAlertaLogin("Error"));	
			Assert.assertTrue(CurrentPage.As(D_LoginPage.class).obtenerMensajeAlertaLogin("Usuario o contraseña incorrectos o cuenta no activada"));
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
