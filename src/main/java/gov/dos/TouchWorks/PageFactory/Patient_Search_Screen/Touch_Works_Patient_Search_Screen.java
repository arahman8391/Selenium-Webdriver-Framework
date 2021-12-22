package gov.dos.TouchWorks.PageFactory.Patient_Search_Screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import gov.dos.Allscripts.Utility.BaseTest;

public class Touch_Works_Patient_Search_Screen {

	WebDriver driver;
	
	public Touch_Works_Patient_Search_Screen(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By PatientSearchField = By.xpath("//*[@id=\"SearchInputPanel\"]/tw-mini-patient-search/form/input[1]");
	By PatientSearchButton = By.xpath("//*[@id=\"SearchInputPanel\"]/tw-mini-patient-search/form/input[2]");
	By PatientSelectionSoloSearch = By.xpath("//*[@id=\"patientName\"]");
	By AllPatientFromFilteredSearch = By.xpath("//*[@id=\"ResultPanel\"]/div[1]/div[2]/table/tbody");
	
	public WebElement PatientSearchField() 
	{
		return driver.findElement(PatientSearchField);
	}
	public WebElement PatientSearchButton() 
	{
		return driver.findElement(PatientSearchButton);
	}
	public WebElement PatientSelectionSoloSearch() 
	{
		return driver.findElement(PatientSelectionSoloSearch);
	}
	public WebElement AllPatientFromFilteredSearch() 
	{
		return driver.findElement(AllPatientFromFilteredSearch);
	}
	
	By CancelButton = By.xpath("//*[text()='Cancel']");
	
	public WebElement CancelButton() 
	{
		BaseTest.WaitUntilClickable(driver, CancelButton, 120);
		BaseTest.MoveToElement(driver, driver.findElement(CancelButton));
		BaseTest.Wait(1);
		return driver.findElement(CancelButton);
	}
}
