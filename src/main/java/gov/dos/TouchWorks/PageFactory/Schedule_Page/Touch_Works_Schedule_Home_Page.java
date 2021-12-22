package gov.dos.TouchWorks.PageFactory.Schedule_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import gov.dos.Allscripts.Utility.BaseTest;

public class Touch_Works_Schedule_Home_Page {

	WebDriver driver;
	
	public Touch_Works_Schedule_Home_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By SearchPatientField = By.xpath("//*[@id=\"user_header_bar\"]/patient-search-header/div/form/span/span/input");
	By SearchPatientButton = By.xpath("//*[@id=\"user_header_bar\"]/patient-search-header/div/form/div");
	
	public WebElement SearchPatientField() 
	{
		return driver.findElement(SearchPatientField);
	}
	public WebElement SearchPatientButton() 
	{
		return driver.findElement(SearchPatientButton);
	}
	
	By SelectEclipseToClearPatient = By.xpath("//*[@id=\"pat_banner_info_toggle\"]");
	By SelectClearPatient = By.xpath("/html/body/div[*]/ul/li[2]/span");
	
	public WebElement SelectEclipseToClearPatient() 
	{
		return driver.findElement(SelectEclipseToClearPatient);
	}
	public WebElement SelectClearPatient() 
	{
		return driver.findElement(SelectClearPatient);
	}
	
	By SelectAddNewProblem = By.xpath("//*[@id=\"AddNewProblem\"]");
	
	public WebElement SelectAddNewProblem() 
	{
		return driver.findElement(SelectAddNewProblem);
	}
	
	By TodaysDateButton = By.xpath("//*[@id=\"btnToday\"]");
	By ScheduleApptDateCalanderButton = By.xpath("//*[@id=\"divProvider\"]/div[2]/div[2]/span/span/span/span");
	By ScheduleApptDateCalanderBody = By.xpath("/html/body/div[*]/div/div/table/tbody");
	By ScheduleApptTodaysDate = By.xpath("/html/body/div[*]/div/div/div[2]/a");
	
	public WebElement TodaysDateButton() 
	{
		BaseTest.WaitUntilClickable(driver, TodaysDateButton, 60);
		BaseTest.MoveToElement(driver, driver.findElement(TodaysDateButton));
		BaseTest.Wait(2);
		return driver.findElement(TodaysDateButton);
	}
	public WebElement ScheduleApptDateCalanderButton() 
	{
		return driver.findElement(ScheduleApptDateCalanderButton);
	}
	public WebElement ScheduleApptDateCalanderBody() 
	{
		return driver.findElement(ScheduleApptDateCalanderBody);
	}
	public WebElement ScheduleApptTodaysDate() 
	{
		return driver.findElement(ScheduleApptTodaysDate);
	}
	
	By ProviderSearchScreenIFrame = By.xpath("//*[@id=\"dialog0\"]/iframe");
	By ProviderSearchIcon = By.xpath("//*[@id=\"btnSearch\"]");
	By ProviderSearchField = By.xpath("//*[@id=\"inSearch\"]");
	By ProviderSearchButton = By.xpath("//*[@id=\"btnSearch1\"]");
	By ProviderSearchSelection = By.xpath("//*[@id=\"trRow\"]/td");
	By ProviderSearchOkButton = By.xpath("//*[@id=\"btnOk\"]");
	
	public WebElement ProviderSearchScreenIFrame() 
	{
		BaseTest.WaitUntilClickable(driver, ProviderSearchScreenIFrame, 60);
		return driver.findElement(ProviderSearchScreenIFrame);
	}
	
	public WebElement ProviderSearchIcon() 
	{
		BaseTest.WaitUntilClickable(driver, ProviderSearchIcon, 60);
		BaseTest.MoveToElement(driver, driver.findElement(ProviderSearchIcon));
		return driver.findElement(ProviderSearchIcon);
	}
	public WebElement ProviderSearchField() 
	{
		BaseTest.WaitUntilClickable(driver, ProviderSearchField, 60);
		BaseTest.MoveToElement(driver, driver.findElement(ProviderSearchField));
		return driver.findElement(ProviderSearchField);
	}
	public WebElement ProviderSearchButton() 
	{
		BaseTest.WaitUntilClickable(driver, ProviderSearchButton, 60);
		BaseTest.MoveToElement(driver, driver.findElement(ProviderSearchButton));
		return driver.findElement(ProviderSearchButton);
	}
	public WebElement ProviderSearchOkButton() 
	{
		BaseTest.WaitUntilClickable(driver, ProviderSearchOkButton, 60);
		BaseTest.MoveToElement(driver, driver.findElement(ProviderSearchOkButton));
		return driver.findElement(ProviderSearchOkButton);
	}
	public WebElement ProviderSearchSelection() 
	{
		BaseTest.WaitUntilClickable(driver, ProviderSearchSelection, 60);
		BaseTest.MoveToElement(driver, driver.findElement(ProviderSearchSelection));
		return driver.findElement(ProviderSearchSelection);
	}
	
	By ProviderListDropdown = By.xpath("//*[@id=\"selAuthor\"]");
	By TaskButton = By.xpath("//*[@id=\"NewTask\"]");
	By SelectPatientButton = By.xpath("//*[@id=\"no-patient\"]/a");
	By PatientSearchScreen = By.xpath("/html/body/div[6]");
	
	public Select ProviderListDropdown() 
	{
		BaseTest.WaitUntilClickable(driver, ProviderListDropdown, 120);
		driver.findElement(ProviderListDropdown).click();
		BaseTest.Wait(1);
		Select s= new Select(driver.findElement(ProviderListDropdown));
		BaseTest.Wait(1);
		driver.findElement(ProviderListDropdown).click();
		return s;
	}
	public WebElement TaskButton() 
	{
		BaseTest.WaitUntilWebElementVisible(driver, driver.findElement(TaskButton), 120);
		BaseTest.MoveToElement(driver, driver.findElement(TaskButton));
		BaseTest.Wait(2);
		return driver.findElement(TaskButton);
	}
	public WebElement SelectPatientButton() 
	{
		return driver.findElement(SelectPatientButton);
	}
	
	By AddNewLabsIcon = By.xpath("//*[@id=\"AddNewLabDiag\"]");
	
	public WebElement AddNewLabsIcon() 
	{
		return driver.findElement(AddNewLabsIcon);
	}
	
	By GearIcon = By.xpath("//*[@id=\"Customize\"]");
	By SelectedScheduleContentFilterLink1 = By.xpath("//*[@id=\"spnLink\"]");
	By PrintButton = By.xpath("//*[@id=\"Print\"]");
	
	public WebElement GearIcon() 
	{
		return driver.findElement(GearIcon);
	}
	public WebElement SelectedScheduleContentFilterLink1() 
	{
		return driver.findElement(SelectedScheduleContentFilterLink1);
	}
	public WebElement PrintButton() 
	{
		return driver.findElement(PrintButton);
	}

	By SelectFirstRow = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/div[4]/div[2]/div[3]/div/div[2]/table/tbody/tr[*]");
	
	public WebElement SelectFirstRow() 
	{
		return driver.findElement(SelectFirstRow);
	}
	
	By ScheduleTable = By.xpath("//*[@id=\"tblSchedule\"]/tbody");
	By AColumnDefaultRow = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/div[4]/div[2]/div[3]/div/div[2]/table/tbody/tr[*]/td[8]");
	By TimeColumnDefaultRow = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/div[4]/div[2]/div[3]/div/div[2]/table/tbody/tr[*]/td[11]");
	By PatientColumnDefaultRow = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/div[4]/div[2]/div[3]/div/div[2]/table/tbody/tr[*]/td[12]");
	By ApptTypeColumnDefaultRow = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/div[4]/div[2]/div[3]/div/div[2]/table/tbody/tr[*]/td[14]");
	By DurationColumnDefaultRow = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/div[4]/div[2]/div[3]/div/div[2]/table/tbody/tr[*]/td[15]");
	By CommentColumnDefaultRow = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/div[4]/div[2]/div[3]/div/div[2]/table/tbody/tr[*]/td[16]");
	
	public WebElement ScheduleTable() 
	{
		return driver.findElement(ScheduleTable);
	}
	public WebElement AColumnDefaultRow() 
	{
		return driver.findElement(AColumnDefaultRow);
	}
	public WebElement TimeColumnDefaultRow() 
	{
		return driver.findElement(TimeColumnDefaultRow);
	}
	public WebElement PatientColumnDefaultRow() 
	{
		return driver.findElement(PatientColumnDefaultRow);
	}
	public WebElement ApptTypeColumnDefaultRow() 
	{
		return driver.findElement(ApptTypeColumnDefaultRow);
	}
	public WebElement DurationColumnDefaultRow() 
	{
		return driver.findElement(DurationColumnDefaultRow);
	}
	public WebElement CommentColumnDefaultRow() 
	{
		return driver.findElement(CommentColumnDefaultRow);
	}	
	
	By HighlightAppointmentAndSelectElllipses = By.xpath("//*[@id=\"trSchedule\"]/td[*]/span");
	By QuickApptButton = By.xpath("/html/body/div[*]/ul/li[5]/span");
	By QuickApptTableBody = By.xpath("//*[@id=\"dgAppointment_ug\"]/div[2]/table/tbody");
	By QuickApptPopUpCloseButton = By.xpath("/html/body/div[*]/div[1]/div/a[2]");
	
	public WebElement HighlightAppointmentAndSelectElllipses() 
	{
		return driver.findElement(HighlightAppointmentAndSelectElllipses);
	}	
	public WebElement QuickApptButton() 
	{
		return driver.findElement(QuickApptButton);
	}	
	public WebElement QuickApptTableBody() 
	{
		return driver.findElement(QuickApptTableBody);
	}	
	public WebElement QuickApptPopUpCloseButton() 
	{
		return driver.findElement(QuickApptPopUpCloseButton);
	}	
	
}
