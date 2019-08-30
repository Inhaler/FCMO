package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import base.BaseStep;
import context.Usuario;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_HomePage;
import pages.D_LoginPage;

public class D_Home_VisualizacionStep extends BaseStep {

	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
						
			NavigateToSite(configuration.getUrlPrestadores());
			CurrentPage = (new D_LoginPage().GetInstance(D_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			
			nombrePaso = "1_Se ingresa a Login Despacho";
			CurrentPage.As(D_LoginPage.class).ingresarUsuario(usr.getEmail());
			CurrentPage.As(D_LoginPage.class).ingresarContrasenia(usr.getPassword());
			CurrentPage.As(D_LoginPage.class).clicBtnIngresar();
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);

		
			nombrePaso = "2_Se verifica la visualización campo labelUsuario";
			CurrentPage = (new D_HomePage().GetInstance(D_HomePage.class));
			Assert.assertTrue(CurrentPage.As(D_HomePage.class).esVisibleUsuarioLogueado());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "3_Se verifica la visualización campo moduloInvitaciones";
			Assert.assertTrue(CurrentPage.As(D_HomePage.class).esVisibleModuloinvitaciones());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "4_Se verifica la visualización campo btnSalir";
			Assert.assertTrue(CurrentPage.As(D_HomePage.class).esVisibleBotonSalir());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "5_Se verifica la visualización campo btnCambiarContrasenia";
			Assert.assertTrue(CurrentPage.As(D_HomePage.class).esVisibleBotonCambiarContrasenia());
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
