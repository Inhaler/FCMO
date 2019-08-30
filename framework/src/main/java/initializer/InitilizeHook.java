package initializer;

import base.Base;
import config.DataSetter;
import static config.DataSetter.configuration;
import static delivery.EmailSender.InitializeEmailDeliveryConfiguration;
import static delivery.EmailSender.exitDelivery;

import helpers.PageHelper;
import helpers.XMLHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import log.Log;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import report.ReportConfiguration;

public class InitilizeHook extends Base {

	public static void OpenDelivery() {
		InitializeEmailDeliveryConfiguration();
	}

	public static void OpenReport(String testName) {
		ReportConfiguration.getReportConfig(testName);
	}

	public static void CloseReport() {
		ReportConfiguration.exitReport();
	}

	public static void CloseDelivery() {
		exitDelivery();
	}

	public static void OpenConfiguration() {
		DataSetter.getConfiguration();
	}

	public static void CloseConfiguration() {
		DataSetter.dispose();
	}

	public static void OpenContextData(String testName) throws FileNotFoundException, IOException {

		XMLHelper.leerXml(testName);
		// ExcelHelper.leerExcelCargado(testName);
	}

	public static void CloseContextData(String testName) {
		XMLHelper.guardarXml(testName);
	}

	public static void DeleteSessionsData() {
		PageHelper.deleteAllCookies(driver);
		PageHelper.deleteLocalStorage();
		PageHelper.deleteSessionStorage();

	}

	public static void CloseAllTabs() {
		PageHelper.closeTabs();
	}

	public static void OpenLogger() {
		Log.intilizedLogger();
	}

	public static void CloseBrowser() {
		driver.close();
		driver.quit();
	}

	public static void CreateFolder() {
		File imagePath = new File(configuration.getImageRepository());
		if (!imagePath.exists()) {
			imagePath.mkdirs();
		}
	}

	public static void OpenBrowser() {
		String tipoDeBrowser = configuration.getBrowser();
		String pruebaRemota = configuration.getPruebaRemota();
		
		if (pruebaRemota.equals("NO")) {
			switch (tipoDeBrowser) {
				case "Chrome": {
					System.setProperty("webdriver.chrome.driver", configuration.getDriverPath());
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					options.addArguments("--disable-extensions");
					options.addArguments("--enable-notifications");
					options.addArguments("use-fake-ui-for-media-stream");					
					
					setDriver(new ChromeDriver(options));
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
					break;
				}
				case "Internet Explorer": {
					System.setProperty("webdriver.ie.driver", configuration.getDriverPath());
					// InternetExplorerOptions IEOptions = new InternetExplorerOptions();
					setDriver(new InternetExplorerDriver());
					break;
				}
	
				default: {
					System.setProperty("webdriver.chrome.driver", configuration.getDriverPath());
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					options.addArguments("--disable-extensions");
					setDriver(new ChromeDriver(options));
					break;
				}
			}
		} else {
			String URLremoteWebDriver = configuration.getUrlDriver();
			try {
				URL urlServer = new URL(URLremoteWebDriver);
				ChromeOptions options = new ChromeOptions();
				setDriver(new RemoteWebDriver(urlServer, options));
				driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
				Log.debug(e.getMessage());
			}
		}
	}
}
