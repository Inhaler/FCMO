package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import base.BaseStep;
import context.Usuario;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_Envio_InvitacionesPage;
import pages.D_HomePage;
import pages.D_LoginPage;

public class D_EnvioInvitacion_ObligatoriedadStep extends BaseStep {

	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
			
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
			CurrentPage.As(D_HomePage.class).esVisibleAlertaLogin();
			CurrentPage.As(D_HomePage.class).ingresarModuloInvitaciones();
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "03_Se verifica la visualización del botón enviar invitación";
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).estaHabilitadoBtnInvitaciones());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "04_Se verifica la visualización del formulario de envio de invitación";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).abrirFormInvitaciones());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "05_Se Envia formulario sin completar campos obligatorios";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).clicBotonEnviar());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "06_Se Verifica texto error de campos Obligatorios - nroSocio";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelNroSocio(),"El campo es requerido");	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "07_Se verifica texto error de campos Obligatorios - nroTel";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelTelefono(),"El campo es requerido");	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "08_Se verifica texto error de campos Obligatorios - Email";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelEmail(),"El campo es requerido");	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "09_Se verifica texto error de campos Obligatorios - Especialidad";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelEspecialidad(),"El campo es requerido");	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "10_Se verifica texto error de campos Obligatorios - Motivo";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelDetalleMotivo(),"El campo es requerido");	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "11_Se verifica texto error de campos Obligatorios - Nombre";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelNombre(),"El campo es requerido");	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "12_Se verifica texto error de campos Obligatorios - Apellido";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelApellido(),"El campo es requerido");	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "13_Se verifica texto error de campos Obligatorios - IDServicio";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelIDServicio(),"El campo es requerido");	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "14_Se verifica texto error de campos Obligatorios - Plan";
			Assert.assertEquals(CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerErrorLabelPlan(),"El campo es requerido");	
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
