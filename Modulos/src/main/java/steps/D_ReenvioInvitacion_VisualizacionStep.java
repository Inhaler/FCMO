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

public class D_ReenvioInvitacion_VisualizacionStep extends BaseStep {

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
			
			nombrePaso = "05_Se verifica el mensaje de Invitación Enviada";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).generarInvitacion(inv.getNroSocio(),inv.getNroCelular(), inv.getEmail(), inv.getEspecialidad(),
					inv.getDetalleConsulta(), inv.getNombre(), inv.getApellido(), inv.getFechaNacimiento(), inv.getIdServicio(), inv.getMesaOperativa(), inv.getPlan(), inv.getProvincia(), inv.getLocalidad(), inv.getBarrio(),
					inv.getMarcaCI(), inv.getMarcaDiscapacidad(), inv.getMarcaID(), inv.getMarcaCX(), inv.getMarcaPMI()));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "06_Se hace clik en reenviar invitacion";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).abrirFormReenviarInvitacion(inv.getNroSocio()));	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "07_Se verifica el nro de socio";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoReenvioNroSocio(),inv.getNroSocio());	
			log.Log.SuccessStep(nombrePaso);	
			
			nombrePaso = "08_Se verifica el email";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoEmail(),inv.getEmail());	
			log.Log.SuccessStep(nombrePaso);	
			
			nombrePaso = "09_Se verifica el nro de telefono";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoCelular(),inv.getNroCelular());	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "10_Se verifica el Nombre";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoReenvioNombre(),inv.getNombre());	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "11_Se verifica el Apellido";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoReenvioApellido(),inv.getApellido());	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "12_Se verifica el ID_Sevicio";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoReenvioIDServicio(),inv.getIdServicio());	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "13_Se verifica la fecha Nacimiento";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoReenvioFecha(),inv.getFechaNacimiento());	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "14_Se verifica la especialidad";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seEncuentraSeleccionadoDatoReenvioEspecialidad(inv.getEspecialidad()));	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "15_Se verifica la mesa";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoReenvioMesa(),inv.getMesaOperativa());	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "16_Se verifica el Motivo";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoReenvioMotivo(),inv.getDetalleConsulta());	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "17_Se verifica la provincia";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoReenvioProvincia(),"Provincia: " +inv.getProvincia());	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "18_Se verifica la localidad";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoReenvioLocalidad(),"Localidad: " + inv.getLocalidad());	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "19_Se verifica el barrio";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoReenvioBarrio(),"Barrio: " + inv.getBarrio());	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "20_Se verifica las Marcas PMI-CI-DISC-ID-CX";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).validarMarcasReenvio(inv.getMarcaCI(), inv.getMarcaDiscapacidad(), inv.getMarcaID(), inv.getMarcaCX(), inv.getMarcaPMI()));	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "21_Se verifica el plan";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoReenvioPlan(),inv.getPlan());	
			log.Log.SuccessStep(nombrePaso);
			
			
			nombrePaso = "09_Se verifica los campos deshabilitados";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).verificarCamposNoEditables());	
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
