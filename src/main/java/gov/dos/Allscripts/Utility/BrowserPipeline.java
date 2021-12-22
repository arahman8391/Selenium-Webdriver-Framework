package gov.dos.Allscripts.Utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserPipeline {
	
	public static WebDriver driver;
	
	public static WebDriver GetBrowser(String browserName) {
		
		String buildPipeline = System.getProperty("build.pipeline");
		browserName = browserName.toLowerCase();
		
		if(buildPipeline != null && buildPipeline.equals("true")) {
			
			URL url;  
			
			try {
				url = new URL("http://localhost:4444/wd/hub/");
			}
			catch(MalformedURLException e) {
				e.printStackTrace();
				return null;
			}
			
			return browserName.contains("chrome") ?
					createRemoteDriver(url, new ChromeOptions()):
						new RemoteWebDriver(url, new ChromeOptions());
		}
		
		if(browserName.equals("chrome"))
			driver = getChromeInstance();
	
		return driver;
	}
	
	private static ChromeDriver getChromeInstance() 
	{
		ChromeOptions chromeOptions = new ChromeOptions(); 
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("----disable-gpu");
		chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		return driver; 
	}
	
	private static WebDriver createRemoteDriver(URL url, ChromeOptions chromeOptions) {
		
		RemoteWebDriver driver = null;
		HashMap <String, Object> chromePrefs = new HashMap <String, Object>();	
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("src/main/resources/text-execution-documents", System.getProperty("user.dir"));
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("-headless");
		chromeOptions.addArguments("----disable-gpu");
		chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

		Proxy proxy = new Proxy();
		//proxy.setProxyAutoconfigUrl("");
		chromeOptions.setCapability("proxy", proxy);

		try {
			driver = new RemoteWebDriver(url, chromeOptions);
		}
		catch(IllegalStateException e) {
			e.printStackTrace();
		}
		return driver;	
	}
}
