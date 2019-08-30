package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import base.BaseStep;
import context.Usuario;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.M_HomePage;
import pages.M_LoginPage;

public class M_Home_VisualizacionStep extends BaseStep {
	
	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
				
			PageHelper.deleteAllCookies(driver);
			NavigateToSite(configuration.getUrlMedico());
			CurrentPage = (new M_LoginPage().GetInstance(M_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			nombrePaso = "1_Se loguea el medico";
			Assert.assertTrue(CurrentPage.As(M_LoginPage.class).esVisibleCampoEmail());
			CurrentPage.As(M_LoginPage.class).ingresarEmail(usr.getEmail());
			CurrentPage.As(M_LoginPage.class).ingresarContrasenia(usr.getPassword());
			CurrentPage.As(M_LoginPage.class).clicBtnIngresar();
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "2_Se verifica la visualización campo labelUsuario";
			CurrentPage = (new M_HomePage().GetInstance(M_HomePage.class));
			Assert.assertTrue(CurrentPage.As(M_HomePage.class).esVisibleUsuarioLogueado());
			log.Log.SuccessStep(nombrePaso);
			nombrePaso = "3_Se verifica la visualización modulo Atender Videoconsultas";
			Assert.assertTrue(CurrentPage.As(M_HomePage.class).esVisibleMenuAtenderVideoconsultas());
			log.Log.SuccessStep(nombrePaso);
			nombrePaso = "4_Se verifica la visualización campo btnSalir";
			Assert.assertTrue(CurrentPage.As(M_HomePage.class).esVisibleBotonSalir());
			log.Log.SuccessStep(nombrePaso);
			nombrePaso = "5_Se verifica la visualización campo btnToolBox";
			Assert.assertTrue(CurrentPage.As(M_HomePage.class).esVisibleBotonToolBox());
			log.Log.SuccessStep(nombrePaso);
			nombrePaso = "6_Se verifica la visualización campo btnMiPerfil";
			Assert.assertTrue(CurrentPage.As(M_HomePage.class).esVisibleBotonMiPerfil());
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
