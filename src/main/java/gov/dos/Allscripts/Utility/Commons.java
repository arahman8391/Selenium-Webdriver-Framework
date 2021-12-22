package gov.dos.Allscripts.Utility;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("deprecation")
public class Commons {
	
	protected final Logger log = (Logger) LogManager.getLogger(this.getClass().getName());
    
	public void waitSecond(int sec) {
    	
        try {
        	
             TimeUnit.SECONDS.sleep(sec);
             
        } 
        catch (InterruptedException e) {
        	
        	log.error("Exception occured. ", e);
        	
        }
        
     }

	public boolean waitUntilVisible(WebDriver driver, By by) {
		
		boolean webElementPresence = false;

		try {
			
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(90))
					.pollingEvery(Duration.ofMillis(600))
					.ignoring(NoSuchElementException.class);
			
			fluentWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			if (driver.findElement(by).isDisplayed()) {
				
				webElementPresence= true;
				
			}
		}
		catch (TimeoutException toe) {
			
			log.error("Wait for element has timed out.", toe);
			webElementPresence = false;
			
		}
		catch (Exception e) {
			
			log.error("Error occured.", e);
			webElementPresence = false;
			
		}
		return webElementPresence;
		
	}
	
	public void waitUntilClickable(WebDriver driver, WebElement ele, int iTimeout) {
	
		WebDriverWait wait = new WebDriverWait(driver, iTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		
	}
	
	public boolean verifyText(WebDriver driver, By by, String expectedText) {
		
		boolean result;
					
		List<WebElement> elements = driver.findElements(by);
		if (!elements.isEmpty()) {
			
			String text = elements.get(0).getText();
			
			if (text.contains(expectedText)) {
				
				log.info("'" + expectedText + "' is found.");
				result = true;
				
			}
			else {
				
				log.error("'" + expectedText + "' is not found.");
				log.error("Found this text instead: '" + text + "'");
				result = false;
				
			}
		}
		else {
			
			log.error("cannot locate '" + expectedText + "'");
			result = false;
			
		}
		return result;
	}
	
	public void clickIfPresent(WebDriver driver, By by) {
		
		List<WebElement> elements = driver.findElements(by);
		if (!elements.isEmpty()) {
			
			elements.get(0).click();
		    waitSecond(1);
		    
		}
		
	}
	
	public void mouseOverElement(WebDriver driver, WebElement ele) {
		
		Actions action = new Actions(driver);
		action.moveToElement(ele);
		
	}
	
	public void scrollDown(WebDriver driver, int times) {
		
		Actions action = new Actions(driver);
		for (int i = 1; i <= times; i++)
			action.sendKeys(Keys.PAGE_DOWN).build().perform();		
		
	}
	
	public void scrollUp(WebDriver driver, int times) {
		
		Actions action = new Actions(driver);
		for (int i = 1; i <= times; i++)
			action.sendKeys(Keys.PAGE_UP).build().perform();
		
	}
	
	public void scrollIntoView(WebDriver driver, By by) {
		
		WebElement element = driver.findElement(by);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		
	}
	
	public void jsClick(WebDriver driver, By by) {
		
		WebElement element = driver.findElement(by);
		JavascriptExecutor executor = (JavascriptExecutor)driver; 
		executor.executeScript("arguments[0].click();", element);
		
	}

	public void closeModalIfPresent(WebDriver driver) {
		
		//check if any modal dialog is present and click on 'default' designated button
   	
    	waitSecond(1);
    	List<WebElement> dlgs = driver.findElements(By.cssSelector("div.modal-dialog"));
    	boolean dlgDisplayed = false;
    	WebElement dlgWanted = null;
    	for (WebElement dlg: dlgs) {
    		
    		if (dlg.isDisplayed()) {
    			
    			dlgDisplayed = true;
    			dlgWanted = dlg;
    			break;
    			
    		}
    	}
    	if (dlgDisplayed && dlgWanted != null) {
    		
    		log.info("Modal dialog displayed with following text: " + dlgWanted.getText());
    		List<WebElement> btns = dlgWanted.findElements(By.tagName("button"));
    		for (WebElement btn: btns) {
    			
    			if (btn.getAttribute("class").contains("default")) {
    				
    				System.out.println("Clicking on the button: " + btn.getText());
    				btn.click();
    				waitSecond(1);
    				break;
    				
    			}
    		}
    	}
		
	}

    public int getRandomNumberBetween(int start, int end) {
    	
        return start + (int)Math.round(Math.random() * (end - start));
        
    }

    public String getRandomAlphaString() {
    	
    	return RandomStringUtils.randomAlphabetic(getRandomNumberBetween(3, 9)).toUpperCase();
    	
    }
    
    public String getRandomAlphaNumericString() {
    	
    	return RandomStringUtils.randomAlphanumeric(getRandomNumberBetween(5, 9)).toUpperCase();
    	
    }
    
    public String getRandom8CharsNumber() {
    	
    	return RandomStringUtils.randomAlphabetic(1).toUpperCase() + 
    			RandomStringUtils.random(8, false, true);
		    	
    }
    
    public String getRandomNumber() {
    	
    	String str = getRandom8CharsNumber();
    	return str.substring(0, str.length() - 1);
    	
    }
        
}
