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

public class D_SeccionInvitacion_SinInvitacionesStep extends BaseStep {

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
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleGrillaInvitaciones());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "3_Se verifica el titulo de la grilla";
			CurrentPage.As(D_Envio_InvitacionesPage.class).eliminarTodasLasInvitaciones();
			Assert.assertNotNull(CurrentPage.As(D_Envio_InvitacionesPage.class).recuperarFechaActualizacionGrillaInvitaciones());
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).recuperarCantidadInvGrillaInvitaciones(), "0 Invitaciones (últimas 12hs) ");	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "4_Se verifica el texto de la grilla";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).recuperarTextoGrillaInvitaciones(), "No hay invitaciones registradas..");	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "5_Se verifica que se visualice el check activas";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCheckGrillaInvitaciones());	
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "6_Se verifica que se visualice el boton exportar";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleExportarGrillaInvitaciones());	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "7_Se verifica que se visualice la fecha de actualizacion";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleHoraActualizacionGrillaInvitaciones());	
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
