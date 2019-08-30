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

public class D_SeccionInvitacion_ActualizacionAutomaticaStep extends BaseStep {

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
		
			nombrePaso = "3_Se verifica que se visualice la fecha de actualizacion";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleHoraActualizacionGrillaInvitaciones());	
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "4_Se recupera la hora de actualizacion de la grilla";
			String horaActual = CurrentPage.As(D_Envio_InvitacionesPage.class).recuperarFechaActualizacionGrillaInvitaciones();
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "5_Se espera un minuto";
			CurrentPage.As(D_Envio_InvitacionesPage.class).esperarActualizacionAutomatica();	
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "6_Se verifica que se actualizo la grilla";
			Assert.assertNotSame(CurrentPage.As(D_Envio_InvitacionesPage.class).recuperarFechaActualizacionGrillaInvitaciones(), horaActual);
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
