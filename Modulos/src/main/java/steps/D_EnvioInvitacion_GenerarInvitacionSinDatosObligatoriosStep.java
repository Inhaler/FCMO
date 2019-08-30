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

public class D_EnvioInvitacion_GenerarInvitacionSinDatosObligatoriosStep extends BaseStep {

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

			nombrePaso = "3_Se verifica la visualización del botón enviar invitación";
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).estaHabilitadoBtnInvitaciones());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "4_Se verifica la visualización del formulario de envio de invitación";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).abrirFormInvitaciones());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "5_Se cargan los datos del formulario";
			CurrentPage.As(D_Envio_InvitacionesPage.class).cargarDatos(inv.getNroSocio(),inv.getNroCelular(), inv.getEmail(), inv.getEspecialidad(),
					inv.getDetalleConsulta(), inv.getNombre(), inv.getApellido(), inv.getFechaNacimiento(), inv.getIdServicio(), inv.getMesaOperativa(), inv.getPlan(), inv.getProvincia(), inv.getLocalidad(), inv.getBarrio(),
					inv.getMarcaCI(), inv.getMarcaDiscapacidad(), inv.getMarcaID(), inv.getMarcaCX(), inv.getMarcaPMI());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "6_Se Envia formulario sin completar algunos campos obligatorios";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).clicBotonEnviar());
			log.Log.SuccessStep(nombrePaso);

			if (inv.getEspecialidad().isEmpty()) {
				nombrePaso = "7_Se verifica texto error de campos Obligatorios - Especialidad";
				Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelEspecialidad(),"El campo es requerido");	
				log.Log.SuccessStep(nombrePaso);
			}

			if (inv.getIdServicio().isEmpty()) {
				nombrePaso = "7_Se verifica texto error de campos Obligatorios - IDServicio";
				Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelIDServicio(),"El campo es requerido");	
				log.Log.SuccessStep(nombrePaso);
			}

			if (inv.getPlan().isEmpty()) {
				nombrePaso = "7_Se verifica texto error de campos Obligatorios - Plan";
				Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelPlan(),"El campo es requerido");	
				log.Log.SuccessStep(nombrePaso);
			}
			
			if (inv.getNroSocio().isEmpty()) {
				nombrePaso = "7_Se verifica texto error de campos Obligatorios - nro Socio";
				Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelNroSocio(),"El campo es requerido");	
				log.Log.SuccessStep(nombrePaso);
			}
			
			if (inv.getDetalleConsulta().isEmpty()) {
				nombrePaso = "7_Se verifica texto error de campos Obligatorios - Detalle Motivo";
				Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelDetalleMotivo(),"El campo es requerido");	
				log.Log.SuccessStep(nombrePaso);
			}
			
			if (inv.getNombre().isEmpty()) {
				nombrePaso = "7_Se verifica texto error de campos Obligatorios - Nombre";
				Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelNombre(),"El campo es requerido");	
				log.Log.SuccessStep(nombrePaso);
			}
			
			if (inv.getApellido().isEmpty()) {
				nombrePaso = "7_Se verifica texto error de campos Obligatorios - Apellido";
				Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelApellido(),"El campo es requerido");	
				log.Log.SuccessStep(nombrePaso);
			}
			
			if (inv.getEmail().isEmpty() && inv.getNroCelular().isEmpty()) {
				nombrePaso = "7_Se verifica texto error de campos Obligatorios - Email";
				Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelEmail(),"El campo es requerido");	
				log.Log.SuccessStep(nombrePaso);
			}
			
			if (inv.getEmail().isEmpty() && inv.getNroCelular().isEmpty()) {
				nombrePaso = "7_Se verifica texto error de campos Obligatorios - Nro Celular";
				Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelTelefono(),"El campo es requerido");	
				log.Log.SuccessStep(nombrePaso);
			}
			
			StepHelper.takeScreenShot(testName);

		} catch (AssertionError ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(nombrePaso);
			Assert.fail("Fallo test - " + testName + " - Step: " + nombrePaso);
		}

		log.Log.endTestCase(testName);	
	}


}
