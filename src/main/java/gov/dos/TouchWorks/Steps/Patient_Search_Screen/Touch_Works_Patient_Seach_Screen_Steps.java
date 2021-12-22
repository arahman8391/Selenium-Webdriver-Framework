package gov.dos.TouchWorks.Steps.Patient_Search_Screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import gov.dos.Allscripts.Utility.BaseTest;
import gov.dos.TouchWorks.PageFactory.Patient_Search_Screen.Touch_Works_Patient_Search_Screen;
import gov.dos.TouchWorks.PageFactory.Schedule_Page.Touch_Works_Schedule_Home_Page;

public class Touch_Works_Patient_Seach_Screen_Steps extends BaseTest {

	public Touch_Works_Patient_Seach_Screen_Steps(WebDriver driver)
	{
		BaseTest.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SearchForPatient() 
	{
		Touch_Works_Schedule_Home_Page t = new Touch_Works_Schedule_Home_Page(driver);
		
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"no-patient\"]/a"), 120);
		
		if(t.SelectPatientButton().isDisplayed()) {
			BaseTest.MoveToElement(driver, t.SelectPatientButton());
			BaseTest.Wait(2);
			t.SelectPatientButton().click();
			BaseTest.Wait(2);
			log.info("Successfully Selected Patient Button....");
		}
		else {
			log.info("Unable To Select Patient Button....");
		}
	}
	
	public void EnterPatientSearchKeyword(String PATIENT_SEARCH_KEYWORD) 
	{
		Touch_Works_Patient_Search_Screen s = new Touch_Works_Patient_Search_Screen(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"SearchInputPanel\"]/tw-mini-patient-search/form/input[1]"), 120);
		
		if(s.PatientSearchField().isDisplayed()) {
			BaseTest.MoveToElement(driver, s.PatientSearchField());
			BaseTest.Wait(2);
			s.PatientSearchField().clear();
			BaseTest.Wait(2);
			s.PatientSearchField().sendKeys(PATIENT_SEARCH_KEYWORD);
			BaseTest.Wait(2);
			log.info("Successfully Entered Patient Search Keyword: '" + PATIENT_SEARCH_KEYWORD + "'");
			BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"SearchInputPanel\"]/tw-mini-patient-search/form/input[2]"), 120);
		}
		else {
			log.error("Unable To Entered Patient Search Keyword: '" + PATIENT_SEARCH_KEYWORD + "'");
		}
		
		if(s.PatientSearchButton().isDisplayed()) {
			BaseTest.MoveToElement(driver, s.PatientSearchButton());
			BaseTest.Wait(2);
			s.PatientSearchButton().click();
			BaseTest.Wait(2);
			log.info("Successfully Selected Patient Search Button....");
		}
		else {
			log.error("Unable To Search For Patient....");
		}
	}
	
	public void SelectPatientAndSelectOKButton() 
	{
		Touch_Works_Patient_Search_Screen s = new Touch_Works_Patient_Search_Screen(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"patientName\"]"), 120);
		
		if(s.PatientSelectionSoloSearch().isDisplayed()) {
			BaseTest.MoveToElement(driver, s.PatientSelectionSoloSearch());
			BaseTest.Wait(2);
			s.PatientSelectionSoloSearch().click();
			BaseTest.Wait(3);
			log.info("Successfully Selected Patient & Navigated To Patient Home Page....");
		}
		else {
			log.error("Unable To Select Patient And Click OK....");
		}
	}
	
	public void ClickCancelOnPatientSearch() 
	{
		Touch_Works_Patient_Search_Screen s = new Touch_Works_Patient_Search_Screen(driver);
		
		if(s.CancelButton().isDisplayed()) {
			BaseTest.MoveToElement(driver, s.CancelButton());
			BaseTest.Wait(2);
			s.CancelButton().click();
			BaseTest.Wait(3);
			log.info("Successfully Selected Cancel Button & Exited Patient Search Screen....");
		}
		else {
			log.error("Unable To Cancel Button & Exited Patient Search Screen....");
		}
	}
	
	public void ValidatePatientName(String EXPECTED_PATIENT_NAME) 
	{
		Touch_Works_Patient_Search_Screen s = new Touch_Works_Patient_Search_Screen(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"patientName\"]"), 120);
		BaseTest.Wait(5);
		
		if(s.PatientSelectionSoloSearch().isDisplayed()) {
			String ACTUAL_PATIENT_NAME = s.PatientSelectionSoloSearch().getText();
			Assert.assertEquals(ACTUAL_PATIENT_NAME, EXPECTED_PATIENT_NAME);
			log.info("Successfully Validated Filtered Patient: " + ACTUAL_PATIENT_NAME);
		}
		else {
			log.error("Unable To Validated Filtered Patient: " + EXPECTED_PATIENT_NAME);
		}	
	}
	
	public void ListAllPatientFromFilteredSearch() 
	{
		Touch_Works_Patient_Search_Screen s = new Touch_Works_Patient_Search_Screen(driver);
		BaseTest.WaitUntilClickable(driver, By.xpath("//*[@id=\"ResultPanel\"]/div[1]/div[2]/table/tbody"), 60);
		BaseTest.Wait(3);
		
		if(s.AllPatientFromFilteredSearch().isDisplayed()) {
			log.info("Successfully Listed Filtered Patients In Patient Search Field: " + s.AllPatientFromFilteredSearch().getText());
		}
		else {
			log.error("Unable To List Filtered Patients In Patient Search Field....");
		}
	}
}
