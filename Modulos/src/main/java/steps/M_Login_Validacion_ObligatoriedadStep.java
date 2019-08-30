package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import base.BaseStep;
import context.Usuario;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.M_LoginPage;

public class M_Login_Validacion_ObligatoriedadStep extends BaseStep {

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
			
			nombrePaso = "2_Se verifica la visualización deshabilitada del botón Ingresar";
			CurrentPage.As(M_LoginPage.class).ingresarEmail(usr.getEmail());
			CurrentPage.As(M_LoginPage.class).borrarCampoEmail();
			CurrentPage.As(M_LoginPage.class).ingresarContrasenia( usr.getPassword());
			CurrentPage.As(M_LoginPage.class).borrarCampoContrasenia();
			CurrentPage.As(M_LoginPage.class).clickCampoEmail();
			Assert.assertFalse(CurrentPage.As(M_LoginPage.class).estaHabilitadoBotonIngresar());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "3_Se verifica texto error de campos Obligatorios";
			Assert.assertEquals(CurrentPage.As(M_LoginPage.class).obtenerErrorLabelContrasenia(),"El campo es requerido");	
			Assert.assertEquals(CurrentPage.As(M_LoginPage.class).obtenerErrorLabelEmail(),"El campo es requerido");	
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
