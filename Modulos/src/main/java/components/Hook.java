package components;

import initializer.InitilizeHook;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import helpers.StepHelper;
import helpers.XMLHelper;

public class Hook extends InitilizeHook {
	
	 String testName;
    
    
	public Hook() {
	}
	
	@BeforeTest
	public static void setUpClass() {
		OpenConfiguration();
		OpenLogger();
		OpenDelivery();
		OpenReport("Reporte.pdf");
		OpenBrowser();
		CreateFolder();

	}
	
	@BeforeMethod
	public void setUp(Method method) throws FileNotFoundException, IOException {
		testName = method.getName();
		OpenContextData(testName);
		
	}
	
	@AfterMethod 
	public void stepFail(ITestResult testResult) { 
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			String pathImgScreen = StepHelper.takeScreenShot("FALLA_" + testName);
			XMLHelper.object.setImgFalla(pathImgScreen);
		} 
	}
	
	@AfterMethod
	public void tearDown() {
		CloseAllTabs();
		DeleteSessionsData();
		CloseContextData(testName);
	}

	@AfterTest
	public static void tearDownClass() {
		CloseBrowser();
		CloseReport();
		CloseDelivery();
		CloseConfiguration();
	}
	

}
