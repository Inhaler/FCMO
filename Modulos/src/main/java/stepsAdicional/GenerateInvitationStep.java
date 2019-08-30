package stepsAdicional;

import static config.DataSetter.configuration;
import PagesAdicional.A_LoginPage;
import PagesAdicional.M_EndCMOPage;
import PagesAdicional.M_GuardPage;
import PagesAdicional.M_PreviewPage;
import PagesAdicional.M_VideoCallPage;
import PagesAdicional.S_CallToTheOfficePage;
import PagesAdicional.S_EmailPage;
import PagesAdicional.S_TermsPage;
import PagesAdicional.S_VideoCallPage;
import base.BaseStep;
import context.Invitaciones;
import context.Usuario;
import delivery.EmailSenderConfiguration;
import helpers.ExcelHelper;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_CambiarContraseniaPage;
import pages.M_HomePage;
import pages.M_LoginPage;
import pages.D_HomePage;
import PagesAdicional.D_InvitacionPage;
import pages.D_LoginPage;

public class GenerateInvitationStep extends BaseStep {
	
	public static void Run(String testName) {
/*		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
			Invitaciones inv = ExcelHelper.objectExcel.getInvitacion();
			PageHelper.deleteAllCookies(driver);
			NavigateToSite(configuration.getUrlMedico());
			CurrentPage = (new M_LoginPage().GetInstance(M_LoginPage.class));
			//CurrentPage.As(M_LoginPage.class).loginUsser(usr.getEmail(), usr.getPassword());
			PageHelper.WaitForPageLoading();
			CurrentPage = (new M_HomePage().GetInstance(M_HomePage.class));
			CurrentPage.As(M_HomePage.class).enterAttentions();
			PageHelper.WaitForPageLoading();
			CurrentPage = (new M_GuardPage().GetInstance(M_GuardPage.class));
			CurrentPage.As(M_GuardPage.class).getPatientInformation();
			CurrentPage.As(M_GuardPage.class).enterGuard();
			PageHelper.WaitForPageLoading();
			openNewTab(configuration.getUrlPrestadores());
			CurrentPage = (new D_LoginPage().GetInstance(D_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			CurrentPage.As(D_LoginPage.class).loginUsser(usr.getEmail(), usr.getPassword());
			PageHelper.WaitForPageLoading();
			CurrentPage = (new D_HomePage().GetInstance(D_HomePage.class));
			PageHelper.WaitForPageLoading();
			CurrentPage = (new D_InvitationPage().GetInstance(D_InvitationPage.class));
			CurrentPage.As(D_InvitationPage.class).openInvitationForm();
			CurrentPage.As(D_InvitationPage.class).generateInvitation(inv.getNroSocio(),inv.getNroCelular(), inv.getEmail(), inv.getEspecialidad(),
					inv.getDetalleConsulta(), inv.getNombre(), inv.getApellido(), inv.getFechaNacimiento(), inv.getIdServicio(), inv.getMesaOperativa(), inv.getPlan(), inv.getProvincia(), inv.getLocalidad(), inv.getBarrio(),
					inv.getMarcaCI(), inv.getMarcaDiscapacidad(), inv.getMarcaID(), inv.getMarcaCX(), inv.getMarcaPMI());
//			CurrentPage.As(P_InvitationPage.class).resendInvitation(inv.getNroSocio());
//			CurrentPage.As(P_InvitationPage.class).cancelInvitation(inv.getNroSocio());
			PageHelper.WaitForPageLoading();
			openNewTab(configuration.getCorreo());
			CurrentPage = (new S_EmailPage().GetInstance(S_EmailPage.class));
			CurrentPage.As(S_EmailPage.class).loginGmail(EmailSenderConfiguration.getUser(), EmailSenderConfiguration.getPassword());
			PageHelper.waitImplicit();
			CurrentPage.As(S_EmailPage.class).openEmail();
			PageHelper.waitImplicit();
			CurrentPage.As(S_EmailPage.class).goToTheLink();
			PageHelper.waitImplicit();
			switchToTab(configuration.geturlSocio());
			CurrentPage = (new S_TermsPage().GetInstance(S_TermsPage.class));
			CurrentPage.As(S_TermsPage.class).EnterTerms();			
			switchToTab(configuration.getUrlMedico());
			CurrentPage = (new M_GuardPage().GetInstance(M_GuardPage.class));
			CurrentPage.As(M_GuardPage.class).attendPatient();
			CurrentPage = (new M_PreviewPage().GetInstance(M_PreviewPage.class));
			CurrentPage.As(M_PreviewPage.class).callPatient();
			PageHelper.waitImplicit();
			switchToTab(configuration.geturlSocio());
			CurrentPage = (new S_CallToTheOfficePage().GetInstance(S_CallToTheOfficePage.class));
			CurrentPage.As(S_CallToTheOfficePage.class).enterCMO();
			CurrentPage = (new S_VideoCallPage().GetInstance(S_VideoCallPage.class));
			CurrentPage.As(S_VideoCallPage.class).sendChat("PRUEBA");
			CurrentPage.As(S_VideoCallPage.class).closeVideoCall();
			PageHelper.waitImplicit();
			switchToTab(configuration.getUrlMedico());
			CurrentPage = (new M_VideoCallPage().GetInstance(M_VideoCallPage.class));
			CurrentPage.As(M_VideoCallPage.class).completeRecord(inv.getMotivoExtendido(), inv.getEnfermedadActual(),
					inv.getDiagnostico(), inv.getIndicaciones(), inv.getReposo(), inv.getSignos());
			PageHelper.WaitForPageLoading();
			CurrentPage = (new M_EndCMOPage().GetInstance(M_EndCMOPage.class));	
			CurrentPage.As(M_EndCMOPage.class).continueAttending();
			PageHelper.WaitForPageLoading();
			CurrentPage = (new M_GuardPage().GetInstance(M_GuardPage.class));
			CurrentPage.As(M_GuardPage.class).singOffGuard();
			PageHelper.WaitForPageLoading();
//			CurrentPage.As(M_VideoCallPage.class).
//			CurrentPage = (new A_LoginPage().GetInstance(A_LoginPage.class));
//			CurrentPage.As(A_LoginPage.class).loginUsser(usr.getEmail(), usr.getPassword());
			log.Log.SuccessStep(testName);
			
		} catch (Exception ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(testName);
		}
		log.Log.endTestCase(testName);	*/

	}	

}
