package steps;

import static config.DataSetter.configuration;

import java.io.IOException;

import base.BaseStep;
import context.Invitaciones;
import context.Usuario;
import helpers.ExcelHelper;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import junit.framework.Assert;
import pages.M_AtenderVideoconsultasPage;
import pages.M_HomePage;
import pages.M_LoginPage;
import pages.M_PrevisualizacionPacientePage;
import pages.M_VideoconsultasPage;

public class M_Mobile_AtenderStep extends BaseStep {
	
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
				
			PageHelper.deleteAllCookies(driver);
			nombrePaso = "1_Se loguea el medico";
			NavigateToSite(configuration.getUrlMedico());
			CurrentPage = (new M_LoginPage().GetInstance(M_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			
			CurrentPage.As(M_LoginPage.class).ingresarEmail(usr.getEmail());
			CurrentPage.As(M_LoginPage.class).ingresarContrasenia(usr.getPassword());
			CurrentPage.As(M_LoginPage.class).clicBtnIngresar();
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "2_Se ingresa a la home del medico";
			CurrentPage = (new M_HomePage().GetInstance(M_HomePage.class));
			Assert.assertTrue(CurrentPage.As(M_HomePage.class).esVisibleMenuAtenderVideoconsultas());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "3_Se ingresa al modulo Atender videoconsultas";
			CurrentPage.As(M_HomePage.class).ingresarModuloAtenderVideoconsultas();
			CurrentPage = (new M_AtenderVideoconsultasPage().GetInstance(M_AtenderVideoconsultasPage.class));
			CurrentPage.As(M_AtenderVideoconsultasPage.class).esVisiblePanelInformacion();
			Assert.assertTrue(CurrentPage.As(M_AtenderVideoconsultasPage.class).esVisibleBotonSalirGuardia());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "4_Se ingresa a la previsualizacion del paciente";
			Assert.assertTrue(CurrentPage.As(M_AtenderVideoconsultasPage.class).estaHabilitadoBotonVerProximoPaciente());
			CurrentPage.As(M_AtenderVideoconsultasPage.class).clicBtnVerProxPaciente();
			CurrentPage = (new M_PrevisualizacionPacientePage().GetInstance(M_PrevisualizacionPacientePage.class));
			Assert.assertTrue(CurrentPage.As(M_PrevisualizacionPacientePage.class).estaHabilitadoBtnAtender());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "6_Se llama al socio a la videoconsulta";
			CurrentPage.As(M_PrevisualizacionPacientePage.class).clicBtnAtender();
			log.Log.SuccessStep(nombrePaso);
					
			nombrePaso = "7_Se verifica que se establecio la videoconsulta";
			CurrentPage = (new M_VideoconsultasPage().GetInstance(M_VideoconsultasPage.class));
			Assert.assertTrue(CurrentPage.As(M_VideoconsultasPage.class).esVisibleBtnFinalizar());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "8_Se completa el registro medico";
			CurrentPage = (new M_VideoconsultasPage().GetInstance(M_VideoconsultasPage.class));
			Assert.assertTrue(CurrentPage.As(M_VideoconsultasPage.class).esVisibleFormRegistroMedico());
			CurrentPage.As(M_VideoconsultasPage.class).completarRegistro(inv.getMotivoExtendido(),
					inv.getEnfermedadActual(), inv.getDiagnostico(), inv.getIndicaciones(), inv.getReposo(),
					inv.getSignos());
			log.Log.SuccessStep(nombrePaso);
			
		} catch (AssertionError ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(nombrePaso);
			Assert.fail("Fallo test - " + testName + " - Step: " + nombrePaso);
		}
		log.Log.endTestCase(testName);	
	}

}
