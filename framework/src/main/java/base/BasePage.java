package base;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Base {

	public static WebDriverWait wait;
	public static Actions action;
	public static Select select;
	public static Wait<WebDriver> waitFluent;

	public  BasePage() {
		wait = new WebDriverWait(driver, 5);
		action = new Actions(driver);
		waitFluent = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(300))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
	}
	
	 public <TPage extends BasePage> TPage GetInstance(Class<TPage> page) {
	        Object obj = PageFactory.initElements(driver, page);
	        return page.cast(obj);
	    }

	    @SuppressWarnings("unchecked")
		public <TPage extends BasePage> TPage As(Class<TPage> instancia) {
	        try {
	            return (TPage) this;
	        } catch (Exception ex) {
	            ex.getStackTrace();
	        }
	        return null;
	    }
	
}
