package steps;

import static config.DataSetter.configuration;

import java.io.IOException;

import org.testng.Assert;

import base.BaseStep;
import context.Invitaciones;
import context.Usuario;
import delivery.EmailSenderConfiguration;
import helpers.ExcelHelper;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_Envio_InvitacionesPage;
import pages.D_HomePage;
import pages.D_LoginPage;
import pages.M_AtenderVideoconsultasPage;
import pages.M_HomePage;
import pages.M_LoginPage;
import pages.M_PrevisualizacionPacientePage;
import pages.M_VideoconsultasPage;
import pages.S_GmailPage;
import pages.S_SalaEsperaPage;
import pages.S_TerminosYCondicionesPage;
import pages.S_VideoconsultaPage;

public class VC_Videoconsultas_RealizarVCStep extends BaseStep {

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
			CurrentPage.As(D_LoginPage.class).ingresarContrasenia(usr.getPassword());
			CurrentPage.As(D_LoginPage.class).clicBtnIngresar();
			StepHelper.takeScreenShot(testName);
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "02_Se ingresa al modulo invitaciones";
			CurrentPage = (new D_HomePage().GetInstance(D_HomePage.class));
			CurrentPage.As(D_HomePage.class).ingresarModuloInvitaciones();
			CurrentPage.As(D_HomePage.class).esVisibleAlertaLogin();
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "03_Se verifica la visualizacion del boton enviar invitacion";
			CurrentPage = (new D_Envio_InvitacionesPage().GetInstance(D_Envio_InvitacionesPage.class));
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).estaHabilitadoBtnInvitaciones());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "04_Se verifica la visualizacion del formulario de envio de invitacion";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).abrirFormInvitaciones());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "05_Se verifica el mensaje de Invitacion Enviada";
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class).generarInvitacion(inv.getNroSocio(),
					inv.getNroCelular(), inv.getEmail(), inv.getEspecialidad(), inv.getDetalleConsulta(),
					inv.getNombre(), inv.getApellido(), inv.getFechaNacimiento(), inv.getIdServicio(),
					inv.getMesaOperativa(), inv.getPlan(), inv.getProvincia(), inv.getLocalidad(), inv.getBarrio(),
					inv.getMarcaCI(), inv.getMarcaDiscapacidad(), inv.getMarcaID(), inv.getMarcaCX(),
					inv.getMarcaPMI()));
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "06_Se verifica que se muestre la invitacion en la grilla";
			Assert.assertTrue(
					CurrentPage.As(D_Envio_InvitacionesPage.class).esVisibleHoraActualizacionGrillaInvitaciones());
			Assert.assertTrue(CurrentPage.As(D_Envio_InvitacionesPage.class)
					.existeInvitacionEnGrillaInvitaciones(inv.getNroSocio()));
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "07_Se ingresa como socio al Gmail";
			openNewTab(configuration.getCorreo());
			CurrentPage = (new S_GmailPage().GetInstance(S_GmailPage.class));
			CurrentPage.As(S_GmailPage.class).loginGmail(EmailSenderConfiguration.getUser(),
					EmailSenderConfiguration.getPassword());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "08_Se ingresa al link de la invitacion";
			CurrentPage.As(S_GmailPage.class).abrirCorreo("te damos la bienvenida");
			CurrentPage.As(S_GmailPage.class).ingresarLink();
			Assert.assertTrue(CurrentPage.As(S_GmailPage.class).verificarIngresoAlLink());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "09_Se ingresa a sala de espera";
			switchToTab(configuration.getUrlSocio());
			CurrentPage = (new S_TerminosYCondicionesPage().GetInstance(S_TerminosYCondicionesPage.class));
			Assert.assertTrue(CurrentPage.As(S_TerminosYCondicionesPage.class).esVisibleCheckAceptarInvitacion());
			CurrentPage.As(S_TerminosYCondicionesPage.class).AceptarTerminos();
			CurrentPage = (new S_SalaEsperaPage().GetInstance(S_SalaEsperaPage.class));
			Assert.assertTrue(CurrentPage.As(S_SalaEsperaPage.class).esVisibleBtnTiempoEspera());
			CurrentPage.As(S_SalaEsperaPage.class).aceptarAlertaTiempoEpera();
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "10_Se ingresa como Medico ";
			openNewTab(configuration.getUrlMedico());
			CurrentPage = (new M_LoginPage().GetInstance(M_LoginPage.class));
			CurrentPage.As(M_LoginPage.class).ingresarEmail(usr.getEmail());
			CurrentPage.As(M_LoginPage.class).ingresarContrasenia(usr.getPassword());
			CurrentPage.As(M_LoginPage.class).clicBtnIngresar();

			CurrentPage = (new M_HomePage().GetInstance(M_HomePage.class));
			Assert.assertTrue(CurrentPage.As(M_HomePage.class).esVisibleMenuAtenderVideoconsultas());
			CurrentPage.As(M_HomePage.class).ingresarModuloAtenderVideoconsultas();
			CurrentPage = (new M_AtenderVideoconsultasPage().GetInstance(M_AtenderVideoconsultasPage.class));
			Assert.assertTrue(CurrentPage.As(M_AtenderVideoconsultasPage.class).esVisiblePanelInformacion());
			Assert.assertTrue(CurrentPage.As(M_AtenderVideoconsultasPage.class).esVisibleBotonSalirGuardia());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "10_Se ingresa a la previsualizacion del paciente";
			Assert.assertTrue(CurrentPage.As(M_AtenderVideoconsultasPage.class).estaHabilitadoBotonVerProximoPaciente());
			CurrentPage.As(M_AtenderVideoconsultasPage.class).clicBtnVerProxPaciente();
			CurrentPage = (new M_PrevisualizacionPacientePage().GetInstance(M_PrevisualizacionPacientePage.class));
			Assert.assertTrue(CurrentPage.As(M_PrevisualizacionPacientePage.class).esVisibleBtnAtender());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "11_Se llama al socio a la videoconsulta";
			CurrentPage.As(M_PrevisualizacionPacientePage.class).clicBtnAtender();
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "12_Como socio se acepta la consulta";
			switchToTab(configuration.getUrlSocio());
			CurrentPage = (new S_SalaEsperaPage().GetInstance(S_SalaEsperaPage.class));
			CurrentPage.As(S_SalaEsperaPage.class).aceptarConsulta();
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "13_Se verifica que se haya establecido la videconsulta";
			CurrentPage = (new S_VideoconsultaPage().GetInstance(S_VideoconsultaPage.class));
			Assert.assertTrue(CurrentPage.As(S_VideoconsultaPage.class).esVisibleBtnFinalizar());
			Assert.assertTrue(CurrentPage.As(S_VideoconsultaPage.class).esVisibleBtnChat());
			Assert.assertTrue(CurrentPage.As(S_VideoconsultaPage.class).esVisibleBtnAdjunto());
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "14_Se finaliza la videoconsulta";
			CurrentPage.As(S_VideoconsultaPage.class).clicBtnFinalizar();
			Assert.assertTrue(CurrentPage.As(S_VideoconsultaPage.class).esVisibleBtnConfirmarFinalizar());
			CurrentPage.As(S_VideoconsultaPage.class).clicBtnConfirmarFinalizar();
			log.Log.SuccessStep(nombrePaso);

			nombrePaso = "15_Medico completa el registro";
			switchToTab(configuration.getUrlMedico());
			CurrentPage = (new M_VideoconsultasPage().GetInstance(M_VideoconsultasPage.class));
			Assert.assertTrue(CurrentPage.As(M_VideoconsultasPage.class).esVisibleFormRegistroMedico());
			CurrentPage.As(M_VideoconsultasPage.class).completarRegistro(inv.getMotivoExtendido(),
					inv.getEnfermedadActual(), inv.getDiagnostico(), inv.getIndicaciones(), inv.getReposo(),
					inv.getSignos());
			log.Log.SuccessStep(nombrePaso);
			
			nombrePaso = "16_Cerrar Tabs";
			PageHelper.closeTabs();
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
