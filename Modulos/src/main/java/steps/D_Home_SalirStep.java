package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_HomePage;
import pages.D_LoginPage;
import context.Usuario;
import base.BaseStep;

public class D_Home_SalirStep extends BaseStep {
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

			nombrePaso = "2_Se verifica la visualización campo btnSalir";
			CurrentPage = (new D_HomePage().GetInstance(D_HomePage.class));
			Assert.assertTrue(CurrentPage.As(D_HomePage.class).esVisibleBotonSalir());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "3_Se hace clic en el botón Salir de la sesión del prestador";
			CurrentPage.As(D_HomePage.class).clicBtnSalir();
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "4_Se verifica la visualización del campo usuario del login";
			CurrentPage = (new D_LoginPage().GetInstance(D_LoginPage.class));
			Assert.assertTrue(CurrentPage.As(D_LoginPage.class).esVisibleCampoUsuario());
			log.Log.SuccessStep(nombrePaso);
			
		} catch (AssertionError ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(nombrePaso);
			Assert.fail("Fallo test - " + testName + " - Step: " + nombrePaso);
		}
		log.Log.endTestCase(testName);	
	}

}
