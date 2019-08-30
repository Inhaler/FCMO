package stepsAdicional;

import static config.DataSetter.configuration;

import base.BaseStep;
import context.Invitaciones;
import context.Usuario;
import helpers.ExcelHelper;
import helpers.PageHelper;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.D_HomePage;
import PagesAdicional.D_InvitacionPage;
import pages.D_LoginPage;

public class VcReturnStep extends BaseStep {

	public static void Run(String testName) {
		try {
			log.Log.startTestCase(testName);
			Usuario usr = XMLHelper.object.getUsuario();
			Invitaciones inv = ExcelHelper.objectExcel.getInvitacion();
			PageHelper.deleteAllCookies(driver);
			NavigateToSite(configuration.getUrlPrestadores());
			CurrentPage = (new D_LoginPage().GetInstance(D_LoginPage.class));
			StepHelper.takeScreenShot(testName);
			CurrentPage.As(D_LoginPage.class).loginUsser(usr.getEmail(), usr.getPassword());
			PageHelper.WaitForPageLoading();
			CurrentPage = (new D_HomePage().GetInstance(D_HomePage.class));
			PageHelper.WaitForPageLoading();
			CurrentPage = (new D_InvitacionPage().GetInstance(D_InvitacionPage.class));
			CurrentPage.As(D_InvitacionPage.class).returnToTheAssociate(inv.getNroSocio(),inv.getNroCelular(), inv.email);	
			CurrentPage.As(D_InvitacionPage.class).returnToTheAssociatePriority(inv.getNroSocio(),inv.getNroCelular(), inv.email);
			log.Log.SuccessStep(testName);
		} catch (Exception ex) {
			log.Log.info(ex.getMessage());
			log.Log.FailStep(testName);
		}
		log.Log.endTestCase(testName);	

	}	
}
