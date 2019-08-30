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

public class D_SeccionInvitacion_ConInvitacionesStep extends BaseStep {

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

			nombrePaso = "06_Se verifica el titulo de la grilla";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).recuperarCantidadInvGrillaInvitaciones(), "1 Invitaciones (últimas 12hs) ");	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "07_Se verifica que se visualice el boton exportar";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleExportarGrillaInvitaciones());	
			log.Log.SuccessStep(nombrePaso);
		
			nombrePaso = "08_Se verifica que se visualice el check activas";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCheckGrillaInvitaciones());	
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "09_Se verifica que se visualice la fecha de actualizacion";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleHoraActualizacionGrillaInvitaciones());	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "10_Se verifican las columnas de la grilla";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).recuperarColumnasGrillaInvitaciones(), "Fecha	ID de servicio	Nº Socio	Teléfono	Email	Especialidad	Leida	Consulta	Acciones");	
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
