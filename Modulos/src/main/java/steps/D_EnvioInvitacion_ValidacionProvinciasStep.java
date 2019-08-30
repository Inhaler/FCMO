package steps;

import static config.DataSetter.configuration;

import org.testng.Assert;

import base.BaseStep;
import context.Usuario;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_Envio_InvitacionesPage;
import pages.D_HomePage;
import pages.D_LoginPage;

public class D_EnvioInvitacion_ValidacionProvinciasStep extends BaseStep {

	public static void Run(String testName) {
		String nombrePaso = "";
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
			
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
					
			nombrePaso = "05_Se selecciona la Provincia: BS As ";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("BUENOS AIRES"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "06_Se selecciona la Provincia: Cap Fed";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("CAPITAL FEDERAL"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "07_Se selecciona la Provincia: Catamarca";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("CATAMARCA"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "08_Se selecciona la Provincia: Chaco";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("CHACO"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "09_Se selecciona la Provincia: Chubut";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("CHUBUT"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "10_Se selecciona la Provincia: Cordoba";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("CORDOBA"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "11_Se selecciona la Provincia: Corrientes";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("CORRIENTES"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "12_Se selecciona la Provincia: Entre Rios";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("ENTRE RIOS"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "13_Se selecciona la Provincia: Formosa";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("FORMOSA"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "14_Se selecciona la Provincia: Jujuy";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("JUJUY"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "15_Se selecciona la Provincia: La Pampa";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("LA PAMPA"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "16_Se selecciona la Provincia: La Rioja";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("LA RIOJA"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "17_Se selecciona la Provincia: Mendoza";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("MENDOZA"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "18_Se selecciona la Provincia: Misiones";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("MISIONES"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "19_Se selecciona la Provincia: Neuquen";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("NEUQUEN"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "20_Se selecciona la Provincia: Rio Negro";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("RIO NEGRO"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "21_Se selecciona la Provincia: Salta";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("SALTA"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "22_Se selecciona la Provincia: San Juan";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("SAN JUAN"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "23_Se selecciona la Provincia: San Luis";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("SAN LUIS"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "24_Se selecciona la Provincia: Santa Cruz";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("SANTA CRUZ"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "25_Se selecciona la Provincia: Santa Fe";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("SANTA FE"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "26_Se selecciona la Provincia: Santiago del Estero";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("SANTIAGO DEL ESTERO"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "27_Se selecciona la Provincia: Tierra Del Fuego";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("TIERRA DEL FUEGO"));
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "28_Se selecciona la Provincia: Tucuman";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).seleccionarProvincia("TUCUMAN"));
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
