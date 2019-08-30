package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import helpers.PageHelper;
import helpers.StepHelper;
import pages.D_LoginPage;
import base.BaseStep;

public class D_Login_VisualizacionStep extends BaseStep {
	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			nombrePaso = "1_Se ingresa a Login Despacho";
			PageHelper.deleteAllCookies(driver);
			NavigateToSite(configuration.getUrlPrestadores());
			CurrentPage = (new D_LoginPage().GetInstance(D_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			
			log.Log.SuccessStep(nombrePaso);
			nombrePaso = "2_Se verifica la visualización campoUsuario";
			Assert.assertTrue(CurrentPage.As(D_LoginPage.class).esVisibleCampoUsuario());
			log.Log.SuccessStep(nombrePaso);
			nombrePaso = "3_Se verifica la visualización campoContrasenia";
			Assert.assertTrue(CurrentPage.As(D_LoginPage.class).esVisibleCampoContrasenia());
			log.Log.SuccessStep(nombrePaso);
			nombrePaso = "4_Se verifica la visualizacion deshabilitada del botón Ingresar";
			Assert.assertFalse(CurrentPage.As(D_LoginPage.class).estaHabilitadoBotonIngresar());
			log.Log.SuccessStep(nombrePaso);
			nombrePaso = "5_Se verifica la visualización Footer";
			Assert.assertTrue(CurrentPage.As(D_LoginPage.class).esVisibleLabelFooter());
			log.Log.SuccessStep(nombrePaso);
			nombrePaso = "6_Se verifica el Texto del Footer";
			Assert.assertTrue((CurrentPage.As(D_LoginPage.class).obtenerLabelFooter()).contains(
					"© OSDE 2019 - Todos los derechos reservados"));
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
