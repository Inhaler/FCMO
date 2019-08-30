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

public class D_EnvioInvitacion_VisualizacionStep extends BaseStep {

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
			
			nombrePaso = "05_Se verifica la visualización del combo Socio";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleComboSocio());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "06_Se verifica la visualización del campo Nro Socio";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCampoNroSocio());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "07_Se verifica la visualización del campo Nro Telefono";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCampoNroTelefono());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "08_Se verifica la visualización del campo Email";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCampoEmail());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "09_Se verifica la visualización del RadioButton Especialidad Clinica";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleRadioButtonEspClinica());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "10_Se verifica la visualización del RadioButton Especialidad Pediatria";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleRadioButtonEspPediatria());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "11_Se verifica la visualización del campo Detalle Motivo";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCampoDetalleMotivo());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "12_Se verifica la visualización del campo Nombre";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCampoNombre());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "13_Se verifica la visualización del campo Apellido";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCampoApellido());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "14_Se verifica la visualización del campo Fecha Nacimiento";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCampoFechaNac());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "15_Se verifica la visualización del combo Mesa Operativa";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleComboMesaOperativa());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "16_Se verifica la visualización del campo Id Servicio";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCampoIdServicio());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "17_Se verifica la visualización del combo Plan";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleComboPlan());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "18_Se verifica la visualización del check Cliente Interno";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCheckMarcaClienteInterno());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "19_Se verifica la visualización del check Discapacidad";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCheckMarcaDiscapacidad());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "20_Se verifica la visualización del check Internacion Domiciliaria";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCheckMarcaID());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "21_Se verifica la visualización del check Cronicidad";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCheckMarcaCronicidad());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "22_Se verifica la visualización del check PMI";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCheckMarcaPMI());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "23_Se verifica la visualización del combo Provincia";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleComboProvincia());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "24_Se verifica la visualización del combo Localidad";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleComboLocalidad());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "25_Se verifica la visualización del campo Barrio";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleCampoBarrio());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "26_Se verifica la visualización del link Ocultar Información del formulario";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleLinkOcultarInfo());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "27_Se verifica la visualización del botón Volver";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleBotonVolver());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "27_Se verifica la visualización del botón Enviar";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleBotonEnviar());
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
