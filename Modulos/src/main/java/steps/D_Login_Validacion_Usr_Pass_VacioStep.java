package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_LoginPage;
import context.Usuario;
import base.BaseStep;

public class D_Login_Validacion_Usr_Pass_VacioStep extends BaseStep {
	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
		
			PageHelper.deleteAllCookies(driver);
		
			nombrePaso = "1_Se ingresa a Login";
			NavigateToSite(configuration.getUrlPrestadores());
			CurrentPage = (new D_LoginPage().GetInstance(D_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "2_Se verifica la visualización deshabilitada del botón Ingresar";
			CurrentPage.As(D_LoginPage.class).ingresarUsuario(usr.getEmail());
			CurrentPage.As(D_LoginPage.class).borrarCampoUsuario();
			CurrentPage.As(D_LoginPage.class).ingresarContrasenia( usr.getPassword());
			CurrentPage.As(D_LoginPage.class).borrarCampoContrasenia();
			CurrentPage.As(D_LoginPage.class).clickCampoUsuario();
			Assert.assertFalse(CurrentPage.As(D_LoginPage.class).estaHabilitadoBotonIngresar());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "3_Se verifica el texto de error de campos Obligatorios";
			Assert.assertEquals(CurrentPage.As(D_LoginPage.class).obtenerErrorLabelContrasenia(),"El campo es requerido");	
			Assert.assertEquals(CurrentPage.As(D_LoginPage.class).obtenerErrorLabelUsuario(),"El campo es requerido");	
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
