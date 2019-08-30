package steps;

import static config.DataSetter.configuration;

import java.io.IOException;

import org.testng.Assert;

import base.BaseStep;
import context.Invitaciones;
import context.Usuario;
import helpers.ExcelHelper;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_Envio_InvitacionesPage;
import pages.D_HomePage;
import pages.D_LoginPage;

public class D_SeccionInvitacion_MostrarActivas_DestildarStep extends BaseStep {

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
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "3_Se verifica que se muestre el boton Mostrar solo activas";
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCheckGrillaInvitaciones());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "4_Se anulan todas las invitaciones creadas";
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			CurrentPage.As(D_Envio_InvitacionesPage.class).eliminarTodasLasInvitaciones();
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "5_Se verifica que no se muestren invitaciones activas";
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			Assert.assertFalse(CurrentPage.As(D_Envio_InvitacionesPage.class).existenInvitacionesEnGrilla());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "6_Se destilda la opcion Mostrar solo invitaciones activas";
			CurrentPage.As(D_Envio_InvitacionesPage.class).clicCheckInvitacionesActivas();
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "7_Se verifica que se muestren las invitaciones inactivas";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).existenInvitacionesEnGrilla());	
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
