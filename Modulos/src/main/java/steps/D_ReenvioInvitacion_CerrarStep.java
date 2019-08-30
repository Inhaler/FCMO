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

public class D_ReenvioInvitacion_CerrarStep extends BaseStep {

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

			nombrePaso = "3_Se hace clik en reenviar invitacion";
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).abrirFormReenviarInvitacion(inv.getNroSocio()));	
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "4_Se modifica los campos email y telefono";
			CurrentPage.As(D_Envio_InvitacionesPage.class).cargarEmailReenvio(inv.getEmail());	
			CurrentPage.As(D_Envio_InvitacionesPage.class).cargarTelefonoReenvio(inv.getNroCelular());	
			log.Log.SuccessStep(nombrePaso);

			
			nombrePaso = "5_Se hace clic en la cruz del popUp";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleBtnReenvioSalir());
			CurrentPage.As(D_Envio_InvitacionesPage.class).clicBotonReenvioCerrar();
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "6_Se verifica que se visualice la grilla de invitaciones";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleGrillaInvitaciones());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "7_Se verifica que se visualiza el socio en la grilla de invitaciones";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).existeInvitacionEnGrillaInvitaciones(inv.getNroSocio()));
			log.Log.SuccessStep(nombrePaso);
			
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).abrirFormReenviarInvitacion(inv.getNroSocio()));
			
			if (!CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoEmail().equals(inv.getEmail())) {
				nombrePaso = "8_Se verifica que no se guardo el cambio de correo";
				log.Log.SuccessStep(nombrePaso);

			}
			
			if (!CurrentPage.As(D_Envio_InvitacionesPage.class).obtenerDatoCelular().equals(inv.getNroCelular())) {
				nombrePaso = "9_Se verifica que no se guardo el cambio de celular";
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
