package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import base.BaseStep;
import context.Fechas;
import context.Usuario;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_Envio_InvitacionesPage;
import pages.D_HomePage;
import pages.D_LoginPage;

public class D_SeccionInvitacion_Exportar_ExportarGrillaStep extends BaseStep {

	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
			Fechas fecha = XMLHelper.object.getFechas();
			
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
			CurrentPage.As(D_HomePage.class).esVisibleAlertaLogin();
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).estaHabilitadoBtnInvitaciones());
			log.Log.SuccessStep(nombrePaso);
		
			nombrePaso = "3_Se verifica que se visualice el boton exportar";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleExportarGrillaInvitaciones());	
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "4_Se hace clic en el boton exportar";
			CurrentPage.As(D_Envio_InvitacionesPage.class).clicBtnExpotarGrillaInvitaciones();
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "5_Se carga una fecha desde";
			CurrentPage.As(D_Envio_InvitacionesPage.class).cargarFechaDesdePopUpExportar(fecha.getFechaDesde());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "6_Se carga fecha hasta";
			CurrentPage.As(D_Envio_InvitacionesPage.class).cargarFechaHastaPopUpExportar(fecha.getFechaHasta());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "7_Se hace clic en exportar del popUp";
			CurrentPage.As(D_Envio_InvitacionesPage.class).clicBtnExpotarPopUpExportar();
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "8_Se valida que el archivo se descargo correctamente";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).recuperarMensajeToast(), "El archivo fue descargado por su navegador.");
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
