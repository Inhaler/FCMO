package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import base.BaseStep;
import context.MesasOperativas;
import context.Usuario;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_Envio_InvitacionesPage;
import pages.D_HomePage;
import pages.D_LoginPage;

public class D_EnvioInvitacion_ValidacionMesasOperativasStep extends BaseStep {

	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
			MesasOperativas mesas = XMLHelper.object.getMesasOperativas();
			

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
					
			nombrePaso = "05_Se selecciona la mesa MDQ";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarMesaOperativa(mesas.getMesa1()));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "06_Se selecciona la mesa MZA";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarMesaOperativa(mesas.getMesa2()));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "07_Se selecciona la mesa MET";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarMesaOperativa(mesas.getMesa3()));
			log.Log.SuccessStep(nombrePaso);
			nombrePaso = "08_Se selecciona la mesa NEU";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarMesaOperativa(mesas.getMesa4()));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "09_Se selecciona la mesa ROS";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarMesaOperativa(mesas.getMesa5()));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "10_Se selecciona la mesa TUC";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarMesaOperativa(mesas.getMesa6()));
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
