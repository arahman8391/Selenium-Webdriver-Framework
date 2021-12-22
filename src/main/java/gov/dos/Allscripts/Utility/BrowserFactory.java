package gov.dos.Allscripts.Utility;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.ChromeDriverManager;


public class BrowserFactory 
{
	public static WebDriver StartBrowser(String browserName, String URL)
	{
		
		if(browserName.equalsIgnoreCase("Edge"))
		{
			EdgeOptions EdgeOptions = new EdgeOptions();
			System.setProperty("webdriver.edge.driver", "src/main/resources/driver/msedgedriver.exe"); 
			WebDriver driver = new EdgeDriver(EdgeOptions);
			String currentWindow = driver.getWindowHandle(); 
			driver.switchTo().window(currentWindow);
			driver.manage().window().maximize();
			driver.get(URL);
			return driver; 
		}
		if(browserName.equalsIgnoreCase("IE"))
		{
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setCapability("ignoreZoomSetting", true);
			System.setProperty("webdriver.ie.driver", "src/main/resources/driver/IEDriverServer.exe"); 
			WebDriver driver = new InternetExplorerDriver(options);
			String currentWindow = driver.getWindowHandle(); 
			driver.switchTo().window(currentWindow);
			driver.manage().window().maximize();
			driver.get(URL);
			return driver; 
		}
		else if(browserName.equalsIgnoreCase("Chrome"))	
		{
			ChromeDriverManager.getInstance().setup();
			ChromeOptions chromeOptions = new ChromeOptions(); 
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.setAcceptInsecureCerts(true);
			chromeOptions.addArguments("--disable-dev-shm-usage");
			chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			WebDriver driver = new ChromeDriver(chromeOptions);
			String currentWindow = driver.getWindowHandle(); 
			driver.switchTo().window(currentWindow);
			driver.manage().window().maximize();
			driver.get(URL);
			return driver; 
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("marionette", true);
			firefoxOptions.addPreference("browser.tab.remote.force-enable", true);
			System.setProperty("webdriver.firefox.bin", "C:\\Users\\atareque\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			WebDriver driver = new FirefoxDriver(firefoxOptions); 
			String currentWindow = driver.getWindowHandle(); 
			driver.switchTo().window(currentWindow);
			driver.manage().window().maximize();
			driver.get(URL);
			return driver; 
		}
		return null;
		
	
	}
}

