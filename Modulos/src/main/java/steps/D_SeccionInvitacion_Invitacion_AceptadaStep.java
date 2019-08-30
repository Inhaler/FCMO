package steps;

import static config.DataSetter.configuration;

import java.io.IOException;

import org.testng.Assert;

import base.BaseStep;
import context.Invitaciones;
import context.Usuario;
import delivery.EmailSenderConfiguration;
import helpers.ExcelHelper;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_Envio_InvitacionesPage;
import pages.D_HomePage;
import pages.D_LoginPage;
import pages.S_GmailPage;
import pages.S_TerminosYCondicionesPage;

public class D_SeccionInvitacion_Invitacion_AceptadaStep extends BaseStep {

	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
			try {
				ExcelHelper.leerExcelCargado(testName);
			} catch (IOException e) {
				log.Log.info(e.getMessage());
				log.Log.FailStep("error al leer el excel");
				Assert.fail("Fallo test - " + testName + " - Step: " + "Carga de datos");
			}
			Invitaciones inv = ExcelHelper.objectExcel.getInvitacion();
			PageHelper.deleteAllCookies(driver);
			
			NavigateToSite(configuration.getUrlPrestadores());
			CurrentPage = (new D_LoginPage().GetInstance(D_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			
			nombrePaso = "01_Se ingresa a Login Despacho";
			CurrentPage.As(D_LoginPage.class).ingresarUsuario(usr.getEmail());
			CurrentPage.As(D_LoginPage.class).ingresarContrasenia( usr.getPassword());
			CurrentPage.As(D_LoginPage.class).clicBtnIngresar();
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "02_Se ingresa al modulo invitaciones";
			CurrentPage = (new D_HomePage().GetInstance(D_HomePage.class));
			CurrentPage.As(D_HomePage.class).ingresarModuloInvitaciones();
			CurrentPage.As(D_HomePage.class).esVisibleAlertaLogin();
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "03_Se verifica la visualizacion del botón enviar invitacion";
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).estaHabilitadoBtnInvitaciones());
			log.Log.SuccessStep(nombrePaso);
		
			nombrePaso = "04_Se verifica la visualizacion del formulario de envio de invitacion";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).abrirFormInvitaciones());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "05_Se verifica el mensaje de Invitacion Enviada";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).generarInvitacion(inv.getNroSocio(),inv.getNroCelular(), inv.getEmail(), inv.getEspecialidad(),
					inv.getDetalleConsulta(), inv.getNombre(), inv.getApellido(), inv.getFechaNacimiento(), inv.getIdServicio(), inv.getMesaOperativa(), inv.getPlan(), inv.getProvincia(), inv.getLocalidad(), inv.getBarrio(),
					inv.getMarcaCI(), inv.getMarcaDiscapacidad(), inv.getMarcaID(), inv.getMarcaCX(), inv.getMarcaPMI()));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "06_Se verifica que se muestre la invitacion en la grilla";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleHoraActualizacionGrillaInvitaciones());
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).existeInvitacionEnGrillaInvitaciones(inv.getNroSocio()));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "07_Se verifica que la invitacion no tenga fecha de lectura";
			Assert.assertNull(CurrentPage.As(D_Envio_InvitacionesPage.class).recuperarFechaLecturaInvitacion(inv.getNroSocio()));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "08_Se ingresa como socio al Gmail";
			openNewTab(configuration.getCorreo());
			CurrentPage = (new S_GmailPage().GetInstance(S_GmailPage.class));
			CurrentPage.As(S_GmailPage.class).loginGmail(EmailSenderConfiguration.getUser(), EmailSenderConfiguration.getPassword());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "09_Se ingresa al link de la invitacion";
			CurrentPage.As(S_GmailPage.class).abrirCorreo("te damos la bienvenida");
			CurrentPage.As(S_GmailPage.class).ingresarLink();
			Assert.assertTrue(CurrentPage.As(S_GmailPage.class).verificarIngresoAlLink());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "10_Se aceptan los terminos y condiciones";
			switchToTab(configuration.getUrlSocio());
			CurrentPage = (new S_TerminosYCondicionesPage().GetInstance(S_TerminosYCondicionesPage.class));
			Assert.assertTrue(CurrentPage.As(S_TerminosYCondicionesPage.class).esVisibleCheckAceptarInvitacion());
			CurrentPage.As(S_TerminosYCondicionesPage.class).AceptarTerminos();
			log.Log.SuccessStep(nombrePaso);
		
			nombrePaso = "11_Se actualiza la grilla de invitaciones en despacho";
			switchToTab(configuration.getUrlPrestadores());
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleGrillaInvitaciones());
			CurrentPage.As(D_Envio_InvitacionesPage.class).actualizarGrillaInvitaciones();
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleHoraActualizacionGrillaInvitaciones());
			CurrentPage.As(D_Envio_InvitacionesPage.class).esperaCargaGrilla();
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "12_Se verifica que la invitacion no se muestre en la grilla de invitaciones";
			Assert.assertFalse(CurrentPage.As(D_Envio_InvitacionesPage.class).existeInvitacionEnGrillaInvitaciones(inv.getNroSocio()));
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
