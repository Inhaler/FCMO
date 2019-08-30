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

public class D_EnvioInvitacion_GenerarInvitacionSeleccionarBarrioStep extends BaseStep {

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

			nombrePaso = "03_Se verifica la visualización del botón enviar invitación";
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).estaHabilitadoBtnInvitaciones());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "04_Se verifica la visualización del formulario de envio de invitación";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).abrirFormInvitaciones());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "05_Se cargan los datos del formulario";
			CurrentPage.As(D_Envio_InvitacionesPage.class).cargarDatos(inv.getNroSocio(),inv.getNroCelular(), inv.getEmail(), inv.getEspecialidad(),
					inv.getDetalleConsulta(), inv.getNombre(), inv.getApellido(), inv.getFechaNacimiento(), inv.getIdServicio(), inv.getMesaOperativa(), inv.getPlan(), inv.getProvincia(), inv.getLocalidad(), inv.getBarrio(),
					inv.getMarcaCI(), inv.getMarcaDiscapacidad(), inv.getMarcaID(), inv.getMarcaCX(), inv.getMarcaPMI());
			log.Log.SuccessStep(nombrePaso);
		
			if (inv.getProvincia().equals("BUENOS AIRES") && inv.getLocalidad().equals("LA PLATA")) {
				nombrePaso = "06_Se hace clic en el campo barrio";
				Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).clicCampoBarrio());	
				log.Log.SuccessStep(nombrePaso);
				
				nombrePaso = "07_Se verifica que se muestren los barrios cargados";
				Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleListaBarrios());	
				log.Log.SuccessStep(nombrePaso);
				
				nombrePaso = "08_Se selecciona el primer barrio";
				Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).clicItemListaBarrio());	
				log.Log.SuccessStep(nombrePaso);
			}
			
			nombrePaso = "09_Se Envia formulario ";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).clicBotonEnviar());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "10_Se verifica el mensaje de invitación enviada";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerMensajeAlertaLogin("Invitación enviada."));
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
