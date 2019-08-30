package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import base.BaseStep;
import context.Contrasenias;
import context.Usuario;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_CambiarContraseniaPage;
import pages.D_HomePage;
import pages.D_LoginPage;

public class D_CambiarContrasenia_ObligatoriedadStep extends BaseStep {
	
	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
			Contrasenias pass = XMLHelper.object.getContrasenia();

			NavigateToSite(configuration.getUrlPrestadores());
			CurrentPage = (new D_LoginPage().GetInstance(D_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			
			nombrePaso = "1_Se ingresa a Login Despacho";
			CurrentPage.As(D_LoginPage.class).ingresarUsuario(usr.getEmail());
			CurrentPage.As(D_LoginPage.class).ingresarContrasenia( usr.getPassword());
			CurrentPage.As(D_LoginPage.class).clicBtnIngresar();
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "2_Se verifica la visualización del botón para cambiar contraseña";
			CurrentPage = (new D_HomePage().GetInstance(D_HomePage.class));
			Assert.assertTrue(CurrentPage.As(D_HomePage.class).esVisibleBotonCambiarContrasenia());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "3_Se ingresa a la pantalla cambiar contraseña";
			CurrentPage.As(D_HomePage.class).clicBtnCambiarContrasenia();
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);
		
			nombrePaso = "4_Se verifica la validación de la obligatoriedad de la contraseña -  Nueva Contraseña";
			CurrentPage = (new D_CambiarContraseniaPage().GetInstance(D_CambiarContraseniaPage.class));
			CurrentPage.As(D_CambiarContraseniaPage.class).ingresarNuevaContrasenia(pass.getContraseniaObligatoriedad());
			CurrentPage.As(D_CambiarContraseniaPage.class).borrarCampoNuevaContrasenia();
			CurrentPage.As(D_CambiarContraseniaPage.class).ingresarReingresarContrasenia(pass.getContraseniaObligatoriedad());
			CurrentPage.As(D_CambiarContraseniaPage.class).borrarCampoReingresarContrasenia();
			CurrentPage.As(D_CambiarContraseniaPage.class).clickCampoNuevaContrasenia();
			
			Assert.assertEquals(CurrentPage.As(D_CambiarContraseniaPage.class).obtenerErrorLabelNuevaContrasenia(),"El campo es requerido");
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "5_Se verifica la validación de la obligatoriedad de la contraseña - Reingrese Contraseña";
			Assert.assertEquals(CurrentPage.As(D_CambiarContraseniaPage.class).obtenerErrorLabelReingresarContrasenia(), "El campo es requerido");
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
