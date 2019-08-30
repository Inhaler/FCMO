package steps;

import static config.DataSetter.configuration;

import base.BaseStep;
import helpers.PageHelper;
import helpers.StepHelper;
import junit.framework.Assert;
import pages.M_LoginPage;

public class M_Login_VisualizacionStep extends BaseStep {
	
	
	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			
			log.Log.startTestCase(testName);
			
			PageHelper.deleteAllCookies(driver);
			
			nombrePaso = "1_Se verifica la visualización campo Email";
			NavigateToSite(configuration.getUrlMedico());
			CurrentPage = (new M_LoginPage().GetInstance(M_LoginPage.class));
			StepHelper.takeScreenShot(testName);

			Assert.assertTrue(CurrentPage.As(M_LoginPage.class).esVisibleCampoEmail());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "2_Se verifica la visualización campo contraseña";
			Assert.assertTrue(CurrentPage.As(M_LoginPage.class).esVisibleCampoContrasenia());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "3_Se verifica la visualización del botón ingresa deshabilitado";
			Assert.assertFalse(CurrentPage.As(M_LoginPage.class).estaHabilitadoBotonIngresar());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "4_Se verifica la visualización del botón para recuperar contraseña";
			Assert.assertTrue(CurrentPage.As(M_LoginPage.class).esVisibleBtnRecuperarContrasenia());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "5_Se verifica la visualización Footer";
			Assert.assertTrue(CurrentPage.As(M_LoginPage.class).esVisibleLabelFooter());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "6_Se verifica el Texto del Footer";
			Assert.assertTrue((CurrentPage.As(M_LoginPage.class).obtenerLabelFooter()).contains(
					"© OSDE 2019 - Todos los derechos reservados"));
			log.Log.SuccessStep(nombrePaso);			
			
		} catch (AssertionError ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(nombrePaso);
			Assert.fail("Fallo test - " + testName + " - Step: " + nombrePaso);
		}
		log.Log.endTestCase(testName);	
	}
}
