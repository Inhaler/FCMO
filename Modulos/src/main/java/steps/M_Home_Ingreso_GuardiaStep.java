package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import base.BaseStep;
import context.Usuario;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.M_AtenderVideoconsultasPage;
import pages.M_HomePage;
import pages.M_LoginPage;

public class M_Home_Ingreso_GuardiaStep extends BaseStep {
	
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
			
			nombrePaso = "2_Se ingresa al modulo Atender Videoconsultas";
			CurrentPage = (new M_HomePage().GetInstance(M_HomePage.class));
			CurrentPage.As(M_HomePage.class).ingresarModuloAtenderVideoconsultas();
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "3_Se verifica la visualización del panel de Información";
			CurrentPage = (new M_AtenderVideoconsultasPage().GetInstance(M_AtenderVideoconsultasPage.class));
			Assert.assertTrue(CurrentPage.As(M_AtenderVideoconsultasPage.class).esVisiblePanelInformacion());
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
