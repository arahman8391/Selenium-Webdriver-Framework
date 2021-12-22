package gov.dos.Allscripts.Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class OktaBaseTest {
	
	protected Logger log = (Logger) LogManager.getLogger(this.getClass().getName());
	
	protected static WebDriver driver;
	
	protected String FILE_PATH = "src/main/resources/test-data/TouchWorksTestAutomationData.xlsx";
	protected String TEST_ENV_SHEET_NAME = "TEST_ENV";
	protected String LOGIN_INFO_SHEET_NAME = "LOGIN_INFO";
	protected String ALL_SCRIPT_PROVIDER_NAME = "Allscripts, Provider";
	protected int USER_NAME_PASSWORD_ROW = 1;

	protected String TASK_LIST_COUNT_1 = "1";
	protected String TASK_LIST_COUNT_2 = "2";
	protected String TASK_LIST_COUNT_3 = "3";
	protected String TASK_LIST_COUNT_4 = "4";
	protected String TASK_LIST_COUNT_5 = "5";
	protected String TASK_LIST_COUNT_6 = "6";
	protected String TASK_LIST_COUNT_7 = "7";
	
	protected int Anik = 1;
	protected int FMH = 2;
	protected int Ancillary_Speech_Dietician_SocialWorker = 3;
	protected int Clinical_Staff = 4;
	protected int Medical_Provider_Co_Signature = 5;
	protected int Medical_Provider_Clinician = 6;
	protected int Offsite_Admin = 7;
	protected int Redacted_Chart_Access = 8;
	protected int Regional_Medical_Officer_RMO = 9;
	protected int Suppport_Staff = 10;
	protected int View_Only = 11;
	protected int View_and_Print_Only = 12;

	@BeforeSuite 
	public void DeleteOldScreenshots(ITestContext iTestContext) 
	{
		deleteFailedScreenshots(iTestContext);
		log.info("Successfully Deleted Previous Execution Failed Screenshots....");
		deletePassedScreenshots(iTestContext);
		log.info("Successfully Deleted Previous Execution Passed Screenshots....");
		log.info("Starting Execution of Test Suite: " + iTestContext.getSuite().getName());
	}
	
	@BeforeMethod
	public void OpenBrowserAndNavigateToOktaSignInPage() 
	{
		try { 
			String Browser = ExcelDriver.getCelldata(1,0, "TEST_ENV", "src/main/resources/test-data/TouchWorksTestAutomationData.xlsx");
			String URL = ExcelDriver.getCelldata(1,1, "TEST_ENV", "src/main/resources/test-data/TouchWorksTestAutomationData.xlsx");
			
			driver = BrowserPipeline.GetBrowser(Browser);
			driver.get(URL);
		} 
		catch (IOException e) {
			e.printStackTrace();
			log.error("Unable To Invoke Excel Driver.....");
		}		
	}
	
	@AfterMethod
	public void CaptureFailedScreenshots(ITestResult iTestResult) 
	{
		try {
			checkFailedStatus(iTestResult);
			checkPassedTestStatus(iTestResult);
		} 
		catch (Exception e) {
			e.printStackTrace();
			log.error("Unable To Invoke Screenshot Capture....");
		}
		
		if(driver.findElement(By.xpath("//*[@id=\"shellPage\"]")).isDisplayed()) {
			System.out.println("Successfully Navigated to " + driver.getCurrentUrl());
			driver.quit();
			System.out.println("Successfully Closed Browser....");
		}
		else {
			System.out.println("Unable To Start Browser & Naivgate TouchWorks Home Page....");
		}
	}
	
	@AfterSuite
	public void endingTestSuite(ITestContext iTestContext) 
	{
		try {
			log.info("Completed execution of Test Suite: " + iTestContext.getSuite().getName());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void takeScreenshot(WebDriver driver, String fileName, WebElement Element) throws InterruptedException, IOException 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(3000);

		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("src/main/resources/failed-screenshots/" + fileName + ".PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getTestName(ITestResult iTestResult) 
	{
		String testName = null;
		
		try {
			  
			testName = iTestResult.getParameters()[0].toString();
		  
		}
		catch(Exception e) {
		
			// Do nothing
		}

		if (testName == null || testName.contains("TestRunner"))			
			testName = iTestResult.getMethod().getMethodName();
		
		return testName + "_" + iTestResult.getTestClass().getName();
	}
		
	private void deleteFailedScreenshots(ITestContext iTestContext) 
	{
        File folder = new File("src/main/resources/failed-screenshots/");
        File failedscreenshotlist[] = folder.listFiles();
        for (int i = 0; i < failedscreenshotlist.length; i++) {
                      File failedscreenshots = failedscreenshotlist[i];
            if (failedscreenshots.getName().endsWith(".png")) {
                      failedscreenshots.delete();
            }
        }
	}
	
	private void deletePassedScreenshots(ITestContext iTestContext) 
	{
		File folder = new File("src/main/resources/passed-screenshots/");
		File failedscreenshotlist[] = folder.listFiles();
		for (int i = 0; i < failedscreenshotlist.length; i++) {
			File failedscreenshots = failedscreenshotlist[i];
			if (failedscreenshots.getName().endsWith(".png")) {
				failedscreenshots.delete();
			}
		}
	}
	
	public void checkFailedStatus(ITestResult testResult) 
	{
		String fileName = null;
		String result = null;

		if (testResult.getStatus() == ITestResult.FAILURE) {

			result = testResult.getStatus() == ITestResult.FAILURE ? "failed" : "passed";
			fileName = getTestName(testResult) + "_" + result;
			takeFailedScreenshot(fileName); 
			log.info("Successfully Captured Failed Testcase Screenshot....");
		}
	}
	
	public void checkPassedTestStatus(ITestResult testResult) 
	{
		String fileName = null;
		String result = null;

		if (testResult.getStatus() == ITestResult.SUCCESS) {

			result = testResult.getStatus() == ITestResult.SUCCESS ? "passed" : "failed";
			fileName = getTestName(testResult) + "_" + result;
			takePassedScreenshot(fileName); 
			log.info("Successfully Captured Passed Testcase Screenshot....");
		}
	}

	
    public void takeFailedScreenshot(String fileName) 
    {
    	//full page screenshots
    	try {
    		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportRetina(1000, 0, 0, 2)).takeScreenshot(driver);
    		ImageIO.write(screenshot.getImage(), "PNG", new File("src/main/resources/failed-screenshots/"+ fileName +".PNG"));
    		
    	}    		 
    	catch (IOException e) {
    		
    		e.printStackTrace();	
    	}
    }
    
    public void takePassedScreenshot(String fileName) 
    {
    	//full page screenshots
    	try {
    		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportRetina(1000, 0, 0, 2)).takeScreenshot(driver);
    		ImageIO.write(screenshot.getImage(), "PNG", new File("src/main/resources/passed-screenshots/"+ fileName +".PNG"));
    		
    	}    		 
    	catch (IOException e) {
    		
    		e.printStackTrace();	
    	}
    }

	public boolean waitUntilVisible(WebDriver driver, By by) 
	{

		boolean webElementPresence = false;

		try {

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(90))
					.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);

			fluentWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			if (driver.findElement(by).isDisplayed()) {

				webElementPresence = true;
			}
		} catch (TimeoutException toe) {

			log.error("Wait for element has timed out.", toe);
			webElementPresence = false;

		} catch (Exception e) {

			log.error("Error occured.", e);
			webElementPresence = false;

		}
		return webElementPresence;
	}
	
	@SuppressWarnings("deprecation")
	public static void WaitUntilVisible(WebDriver driver, By by, int iTimeout) 
	{
		WebDriverWait wait = new WebDriverWait(driver, iTimeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	@SuppressWarnings("deprecation")
	public static void WaitUntilTextToBePresentInElement(WebDriver driver, By by, int iTimeout, String textToBePresentInElementLocated) 
	{
		WebDriverWait wait = new WebDriverWait(driver, iTimeout);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(by, textToBePresentInElementLocated));
	}
	
	@SuppressWarnings("deprecation")
	public static void WaitUntilClickable(WebDriver driver, By by, int iTimeout) 
	{
		WebDriverWait wait = new WebDriverWait(driver, iTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	@SuppressWarnings("deprecation")
	public static void WaitUntilWebElementVisible(WebDriver driver, WebElement WebElement, int iTimeout) 
	{
		WebDriverWait wait = new WebDriverWait(driver, iTimeout);
		wait.until(ExpectedConditions.visibilityOf(WebElement));
	}
	
	@SuppressWarnings("deprecation")
	public static WebDriverWait WaitUntilAlert(WebDriver driver, int iTimeout) 
	{
		WebDriverWait wait = new WebDriverWait(driver, iTimeout);
		return wait;
	}
	
	public static void Wait(int Seconds)
	{
		try {

			TimeUnit.SECONDS.sleep(Seconds);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}
	}
	
	public static void SelectTab(WebDriver driver) 
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
	}
	
	public static void SelectArrowUpKey(WebDriver driver) 
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_UP).build().perform();
	}
	
	public static void MoveToElement(WebDriver driver, WebElement WebElement) 
	{
		
		Actions action = new Actions(driver);
		action.moveToElement(WebElement).build().perform();
	}
	
	public static void SelectEnterKey(WebDriver driver, WebElement WebElement) 
	{
		Actions action = new Actions(driver);
		action.moveToElement(WebElement).sendKeys(Keys.ENTER).build().perform();
	}
	
	public static void DoubleClickElement(WebDriver driver, WebElement WebElement) 
	{
		
		Actions action = new Actions(driver);
		action.doubleClick(WebElement).build().perform();
	}
	
	public void scrollDown(WebDriver driver, int times) 
	{

		Actions action = new Actions(driver);
		for (int i = 1; i <= times; i++)
			action.sendKeys(Keys.PAGE_DOWN).build().perform();				
	}
	
	public void scrollUp(WebDriver driver, int times) 
	{
		Actions action = new Actions(driver);
		for (int i = 1; i <= times; i++)
			action.sendKeys(Keys.PAGE_UP).build().perform();	
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement WebElement) throws InterruptedException 
	{	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WebElement);
	}
	
	public static void ZoomInOrOutScreenSize(WebDriver driver, String Zoom_Size_Percent) 
	{
		((JavascriptExecutor)driver).executeScript("document.body.style.zoom='"+Zoom_Size_Percent+"%';");
	}
	
	
	public static void jsClick(WebDriver driver, WebElement Element) 
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver; 
		executor.executeScript("arguments[0].click();", Element);	
	}

	public static void UploadFile(WebDriver driver, String filename) 
	{	
		String inputText = System.getProperty("user.dir") + filename;
		WebElement uploadElement = driver.findElement(By.id("fileUploadInitial"));
		((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('class')", uploadElement);
		uploadElement.sendKeys(inputText);
	}

    public int getRandomNumberBetween(int start, int end) 
    {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public String getRandomAlphaString() 
    {
    	return RandomStringUtils.randomAlphabetic(getRandomNumberBetween(3, 9)).toUpperCase();
    }
    
    public String getRandomAlphaNumericString() 
    {
    	return RandomStringUtils.randomAlphanumeric(getRandomNumberBetween(5, 9)).toUpperCase();
    }
    
    public static String getRandom10CharsNumber() 
    {
    	return RandomStringUtils.randomAlphabetic(1).toUpperCase() + 
    			RandomStringUtils.random(10, false, true);
    }
    
    public String getRandom8CharsNumber() 
    {
    	String str = getRandom8CharsNumber();
    	return str.substring(0, str.length() - 1);
    }
    
    public static void SwitchWindowHandle(WebDriver driver, String winHandleBefore) 
    {
		winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
    }
    
    public static String GroupText(WebElement Element)
    {
    	String my_string = Element.getAttribute("innerHTML");
    	String[] stringParts = my_string.split(Pattern.quote("<td>"));
    	String partA = stringParts[0];
    	String partB = stringParts[1];
    	String partC = stringParts[2];
    	String partD = stringParts[3];
    	String partE = stringParts[4];
    	String partF = stringParts[5];
    	return partA + partB + partC + partD + partE + partF;
    }
    
    public static String GetCurrentDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        Date date = new Date();
        String Date = dateFormat.format(date);
        return Date;
    }
    
    public static String GetCurrentDateUsingDayFirst()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = new Date();
        String Date = dateFormat.format(date);
        return Date;
    }
    
    public static String GetOneHourFromCurrentTime()
    {
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.HOUR_OF_DAY, 1);
    	SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    	String futureTime = sdf.format(calendar.getTime());
		return futureTime;
    }
    
    public static String GetOneDayPreviousFromCurrentDate()
    {
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DAY_OF_WEEK, -1);
    	SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
    	String futureTime = sdf.format(calendar.getTime());
		return futureTime;
    }
    
    public static String GetTwoDaysFromCurrentTime()
    {
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DAY_OF_WEEK, 2);
    	SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
    	String futureTime = sdf.format(calendar.getTime());
		return futureTime;
    }
    
    public static String Get1DaysFromCurrentTime()
    {
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DAY_OF_WEEK, 1);
    	SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
    	String futureTime = sdf.format(calendar.getTime());
		return futureTime;
    }
    
    public static String GetTwoHourFromCurrentTime()
    {
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.HOUR_OF_DAY, 2);
    	SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    	String futureTime = sdf.format(calendar.getTime());
		return futureTime;
    }
    
    public static void SelectCalendarDateByTitle(WebDriver driver, WebElement TablesBody, String SelectByColumnName) {
    
        //This is from date picker table
        WebElement dateWidgetFrom = TablesBody;
 
        //This are the rows of the from date picker table
        //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
 
        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("a"));
 
        //DatePicker is a table. Thus we can navigate to each cell2
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: columns) {
            
            //Select Date
            if (cell.getAttribute("title").equalsIgnoreCase(SelectByColumnName)) {
            	OktaBaseTest.MoveToElement(driver, cell);
            	OktaBaseTest.Wait(2);
                cell.click();
                OktaBaseTest.Wait(2);
                break;
            }
        }
    }
    
    public static void SelectTeamByTd(WebDriver driver, WebElement TablesBody, String SelectByColumnName) {
        
        //This is from date picker table
        WebElement dateWidgetFrom = TablesBody;
 
        //This are the rows of the from date picker table
        //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
 
        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
 
        //DatePicker is a table. Thus we can navigate to each cell2
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: columns) {
            
            //Select Date
            if (cell.getText().equalsIgnoreCase(SelectByColumnName)) {
            	OktaBaseTest.MoveToElement(driver, cell);
            	OktaBaseTest.Wait(2);
                cell.click();
                OktaBaseTest.Wait(2);
                break;
            }
        }
    }
    
    public static void SelectByRowNameFromTableTrTag(WebDriver driver, WebElement TablesBody, String SelectByColumnName) {
        
        //This is from date picker table
        WebElement dateWidgetFrom = TablesBody;
 
        //This are the rows of the from date picker table
        List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
 
        //This are the columns of the from date picker table
        //List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
 
        //DatePicker is a table. Thus we can navigate to each cell2
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: rows) {
            
            //Select Date
            if (cell.getText().equals(SelectByColumnName)) {
            	OktaBaseTest.MoveToElement(driver, cell);
            	OktaBaseTest.Wait(2);
                cell.click();
                OktaBaseTest.Wait(2);
                break;
            }
        }
    }
    
    public static String GetTextByColumnNameFromTableByTdTag(WebElement TablesBody, String SelectByColumnName) {
        
        //This is from date picker table
        WebElement dateWidgetFrom = TablesBody;
 
        //This are the rows of the from date picker table
        //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
 
        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
 
        //DatePicker is a table. Thus we can navigate to each cell2
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: columns) {
            
            //Select Date
            if (cell.getText().equals(SelectByColumnName)) {
            	return cell.getText();
            }
            break;
        }
        return SelectByColumnName;
    }

    public static String GetTextByColumnNameFromTableByDivTag(WebElement TablesBody, String SelectByColumnName) 
    {
        WebElement TBody = TablesBody;
        List<WebElement> columns = TBody.findElements(By.tagName("div"));
        
        for (WebElement cell: columns) {
            //Select Date
            if (cell.getText().equals(SelectByColumnName)) {
            	return cell.getText();
            }
            break;
        }
        return SelectByColumnName;
    }
    
    public static void SelectByColumnNameFromTableByDivTag(WebDriver driver, WebElement TablesBody, String SelectByColumnName) 
    {
        WebElement TBody = TablesBody;
        List<WebElement> columns = TBody.findElements(By.tagName("div"));
        
        for (WebElement cell: columns) {
            
            if (cell.getText().contains(SelectByColumnName)) {
            	OktaBaseTest.MoveToElement(driver, cell);
            	OktaBaseTest.Wait(2);
            	cell.click();
            	break;
            }
        }
    }
    
    public static WebElement SelectByColumnIndexFromTable(WebElement TablesBody, int SelectRowByIndex, int SelectByColumnByIndex) 
    {
        WebElement TBody = TablesBody;
        WebElement Row = TBody.findElements(By.tagName("tr")).get(SelectRowByIndex);
        WebElement Column = Row.findElements(By.tagName("td")).get(SelectByColumnByIndex);
        return Column;
    }
    
    public static WebElement SelectUpdatByColumnIndexFromTable(WebElement TablesBody, int SelectRowByIndex, int SelectColumnByIndex) 
    {
        WebElement TBody = TablesBody;
        WebElement Row = TBody.findElements(By.tagName("tr")).get(SelectRowByIndex);
        WebElement Column = Row.findElements(By.tagName("td")).get(SelectColumnByIndex);
        WebElement UpdateButton = Column.findElements(By.tagName("a")).get(0);
        return UpdateButton;
    }
    
    public static WebElement SelectCancelByColumnIndexFromTable(WebElement TablesBody, int SelectRowByIndex, int SelectColumnByIndex) 
    {
        WebElement TBody = TablesBody;
        WebElement Row = TBody.findElements(By.tagName("tr")).get(SelectRowByIndex);
        WebElement Column = Row.findElements(By.tagName("td")).get(SelectColumnByIndex);
        WebElement CancelButton = Column.findElements(By.tagName("a")).get(1);
        return CancelButton;
    }
    
    public static WebElement SelectInteractiveElementByColumnIndexFromTable(WebElement TablesBody, int SelectRowByIndex, int SelectColumnByIndex, String ChildTagName) 
    {
        WebElement TBody = TablesBody;
        WebElement Row = TBody.findElements(By.tagName("tr")).get(SelectRowByIndex);
        WebElement Column = Row.findElements(By.tagName("td")).get(SelectColumnByIndex);
        WebElement UpdateButtonOrCancel = Column.findElements(By.tagName(ChildTagName)).get(SelectRowByIndex);
        return UpdateButtonOrCancel;
    }
}
