package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import base.BaseStep;
import context.Usuario;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_Envio_InvitacionesPage;
import pages.D_HomePage;
import pages.D_LoginPage;

public class D_SeccionInvitacion_Exportar_VisualizacionStep extends BaseStep {

	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
			
			PageHelper.deleteAllCookies(driver);

			NavigateToSite(configuration.getUrlPrestadores());
			CurrentPage = (new D_LoginPage().GetInstance(D_LoginPage.class));
			StepHelper.takeScreenShot(testName);

			nombrePaso = "1_Se ingresa a Login Despacho";
			CurrentPage.As(D_LoginPage.class).ingresarUsuario(usr.getEmail());
			CurrentPage.As(D_LoginPage.class).ingresarContrasenia( usr.getPassword());
			CurrentPage.As(D_LoginPage.class).clicBtnIngresar();
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "2_Se ingresa al modulo invitaciones";
			CurrentPage = (new D_HomePage().GetInstance(D_HomePage.class));
			CurrentPage.As(D_HomePage.class).ingresarModuloInvitaciones();
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).estaHabilitadoBtnInvitaciones());
			log.Log.SuccessStep(nombrePaso);
		
			nombrePaso = "3_Se verifica que se visualice el boton exportar";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleExportarGrillaInvitaciones());	
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "4_Se hace clic en el boton exportar";
			CurrentPage.As(D_Envio_InvitacionesPage.class).clicBtnExpotarGrillaInvitaciones();
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "5_Se verifica que se muestre el popUp de exportar";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisiblePopUpExportar());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "6_Se verifica que se muestre el campo fecha desde";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleFDesdePopUpExportar());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "7_Se verifica que se muestre el campo fecha hasta";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleFHastaPopUpExportar());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "8_Se verifica que se muestre el boton Exportar";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleBtnExportarPopUpExportar());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "9_Se verifica que se muestre el boton salir";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleBtnSalirPopUpExportar());
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
