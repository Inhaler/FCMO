package base;

import org.openqa.selenium.WebDriver;

public class Base {

	public static WebDriver driver;
	public static BasePage CurrentPage;
	
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		Base.driver = driver;
	}
	
}
